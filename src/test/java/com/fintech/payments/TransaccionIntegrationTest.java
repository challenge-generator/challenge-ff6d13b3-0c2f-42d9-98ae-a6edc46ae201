package com.fintech.payments;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TransaccionIntegrationTest {

    private static final String BASE_URL = "http://localhost:8080/api";
    private String idTransaccion;
    private String claveIdempotencia;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        idTransaccion = UUID.randomUUID().toString();
        claveIdempotencia = "OPE-" + System.currentTimeMillis() + "-CANAL-WEB";
    }

    @Test
    void debeProcesarTransaccionExitosa() {
        String requestBody = buildTransaccionRequest("CLI-001", new BigDecimal("1500.00"), "PAGO_CUENTA");

        given()
            .contentType(ContentType.JSON)
            .header("X-Idempotency-Key", claveIdempotencia)
            .body(requestBody)
        .when()
            .post("/transacciones/procesar")
        .then()
            .statusCode(200)
            .body("estado", equalTo("APROBADA"))
            .body("idTransaccion", notNullValue());
    }

    @Test
    void debeValidarMontoNegativo() {
        String requestBody = buildTransaccionRequest("CLI-002", new BigDecimal("-500.00"), "TRANSFERENCIA");

        given()
            .contentType(ContentType.JSON)
            .header("X-Idempotency-Key", claveIdempotencia + "-neg")
            .body(requestBody)
        .when()
            .post("/transacciones/procesar")
        .then()
            .statusCode(400)
            .body("mensaje", containsString("monto"));
    }

    @Test
    void debeRechazarTransaccionPorFraude() {
        String requestBody = buildTransaccionRequest("CLI-003", new BigDecimal("50000.00"), "TRANSFERENCIA");

        given()
            .contentType(ContentType.JSON)
            .header("X-Idempotency-Key", claveIdempotencia + "-fraude")
            .body(requestBody)
        .when()
            .post("/transacciones/procesar")
        .then()
            .statusCode(422)
            .body("estado", equalTo("RECHAZADA"))
            .body("motivo", containsString("fraude"));
    }

    @Test
    void debeGarantizarIdempotencia() {
        String requestBody = buildTransaccionRequest("CLI-004", new BigDecimal("100.00"), "PAGO_CUENTA");
        String claveIdempotente = "OPE-IDEMP-" + System.currentTimeMillis();

        Response respuesta1 = given()
            .contentType(ContentType.JSON)
            .header("X-Idempotency-Key", claveIdempotente)
            .body(requestBody)
        .when()
            .post("/transacciones/procesar");

        String idPrimera = respuesta1.getBody().jsonPath().getString("idTransaccion");

        Response respuesta2 = given()
            .contentType(ContentType.JSON)
            .header("X-Idempotency-Key", claveIdempotente)
            .body(requestBody)
        .when()
            .post("/transacciones/procesar");

        String idSegunda = respuesta2.getBody().jsonPath().getString("idTransaccion");

        respuesta1.then().statusCode(200);
        respuesta2.then().statusCode(200);
        org.junit.jupiter.api.Assertions.assertEquals(idPrimera, idSegunda,
            "La clave idempotente debe devolver la misma transacción");
    }

    @Test
    void debeConsultarEstadoTransaccion() {
        String requestBody = buildTransaccionRequest("CLI-005", new BigDecimal("200.00"), "PAGO_SERVICIO");

        Response crearResponse = given()
            .contentType(ContentType.JSON)
            .header("X-Idempotency-Key", claveIdempotencia + "-consulta")
            .body(requestBody)
        .when()
            .post("/transacciones/procesar");

        String idTrans = crearResponse.getBody().jsonPath().getString("idTransaccion");

        given()
            .pathParam("id", idTrans)
        .when()
            .get("/transacciones/{id}")
        .then()
            .statusCode(200)
            .body("idTransaccion", equalTo(idTrans))
            .body("estado", notNullValue());
    }

    private String buildTransaccionRequest(String idCliente, BigDecimal monto, String tipoOperacion) {
        return String.format("""
            {
                "idCliente": "%s",
                "monto": %s,
                "tipoOperacion": "%s",
                "cuentaDestino": "CUENTA-%s",
                "descripcion": "Test automatizado",
                "fechaOperacion": "%s"
            }
            """, idCliente, monto, tipoOperacion, idCliente, LocalDateTime.now().toString());
    }
}