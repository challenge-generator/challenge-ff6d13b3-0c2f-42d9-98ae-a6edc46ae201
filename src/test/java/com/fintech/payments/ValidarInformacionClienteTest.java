package com.fintech.payments;

import com.fintech.payments.models.Cliente;
import com.fintech.payments.exceptions.InformacionInvalidaException;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.Actor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.time.LocalDate;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Superficie de práctica: Test unitario para validar información del cliente.
 * El estudiante debe implementar la lógica de validación siguiendo TDD.
 */
@Disabled("Superficie de práctica - implementar según las fases del reto")
class ValidarInformacionClienteTest {

    private Actor clienteActor;
    private Cliente clienteValido;
    private Cliente clienteMenorDeEdad;
    private Cliente clienteSinLimiteCredito;

    @BeforeEach
    void setUp() {
        OnStage.setTheStage(new OnlineCast());
        clienteActor = OnStage.theActorCalled("ClienteValidado");

        clienteValido = new Cliente();
        clienteValido.setIdCliente("CLI-001");
        clienteValido.setNombreCompleto("Juan Perez Gomez");
        clienteValido.setEmail("juan.perez@email.com");
        clienteValido.setFechaNacimiento(LocalDate.of(1990, 5, 15));
        clienteValido.setLimiteCredito(new BigDecimal("5000.00"));
        clienteValido.setCanalRegistro("WEB");
        clienteValido.setFechaRegistro(LocalDate.now());

        clienteMenorDeEdad = new Cliente();
        clienteMenorDeEdad.setIdCliente("CLI-002");
        clienteMenorDeEdad.setNombreCompleto("Maria Lopez");
        clienteMenorDeEdad.setEmail("maria.lopez@email.com");
        clienteMenorDeEdad.setFechaNacimiento(LocalDate.of(2010, 8, 20));
        clienteMenorDeEdad.setLimiteCredito(new BigDecimal("3000.00"));
        clienteMenorDeEdad.setCanalRegistro("APP");
        clienteMenorDeEdad.setFechaRegistro(LocalDate.now());

        clienteSinLimiteCredito = new Cliente();
        clienteSinLimiteCredito.setIdCliente("CLI-003");
        clienteSinLimiteCredito.setNombreCompleto("Pedro Sanchez");
        clienteSinLimiteCredito.setEmail("pedro.sanchez@email.com");
        clienteSinLimiteCredito.setFechaNacimiento(LocalDate.of(1985, 3, 10));
        clienteSinLimiteCredito.setLimiteCredito(BigDecimal.ZERO);
        clienteSinLimiteCredito.setCanalRegistro("API");
        clienteSinLimiteCredito.setFechaRegistro(LocalDate.now());
    }

    @Test
    void validarQueClienteMayorDeEdadEsAprobado() {
        // TODO: Implementar test que verifique que un cliente mayor de edad pasa la validación
        // Given: un cliente mayor de edad con datos válidos
        // When: se ejecuta la validación de información
        // Then: el resultado debe ser aprobado
        assertTrue(clienteValido.isMayorDeEdad(), "El cliente debe ser mayor de edad");
    }

    @Test
    void validarQueClienteMenorDeEdadEsRechazado() {
        // TODO: Implementar test que verifique que un cliente menor de edad no pasa la validación
        // Given: un cliente menor de edad
        // When: se ejecuta la validación de información
        // Then: debe lanzar InformacionInvalidaException
        assertFalse(clienteMenorDeEdad.isMayorDeEdad(), "El cliente no debe ser mayor de edad");
    }

    @Test
    void validarLimiteCreditoPorCanalWEB() {
        // TODO: Implementar test que verifique el límite de crédito para canal WEB
        // Given: un cliente registrado por el canal WEB
        // When: se valida el límite de crédito
        // Then: el límite debe ser válido para el canal WEB (mínimo 1000)
        assertTrue(clienteValido.isLimiteCreditoValidoParaCanal(),
            "El límite de crédito debe ser válido para el canal WEB");
    }

    @Test
    void validarLimiteCreditoInvalidoParaCanalAPI() {
        // TODO: Implementar test que verifique límite inválido para canal API
        // Given: un cliente registrado por el canal API con límite cero
        // When: se valida el límite de crédito
        // Then: debe retornar false
    }

    @Test
    void validarGeneracionDeClaveIdempotencia() {
        // TODO: Implementar test que verifique la generación de clave de idempotencia
        // Given: un cliente válido
        // When: se genera la clave de idempotencia con número de operación "OP-12345"
        // Then: debe generar una clave única basada en idCliente + numeroOperacion + canal
        String clave = clienteValido.generarClaveIdempotencia("OP-12345");
        assertThat(clave, is(notNullValue()));
        assertThat(clave, containsString("CLI-001"));
        assertThat(clave, containsString("OP-12345"));
    }

    @Test
    void validarEmailConFormatoValido() {
        // TODO: Implementar test que verifique formato de email válido
        // Given: un cliente con email en formato válido
        // When: se valida el email
        // Then: debe pasar la validación de formato
        assertTrue(clienteValido.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$"),
            "El email debe tener formato válido");
    }

    @Test
    void validarEmailConFormatoInvalido() {
        // TODO: Implementar test que verifique que email inválido es rechazado
        // Given: un cliente con email sin formato válido
        // When: se valida el email
        // Then: debe fallar la validación
    }

    @Test
    void validarIntegracionConValidarInformacionClienteTask() {
        // TODO: Implementar test de integración con el task de Serenity
        // Given: el actor ha iniciado sesión
        // When: el actor intenta validar información de cliente
        // Then: debe ver el resultado de la validación
    }

    @Test
    void validarExcepcionInformacionInvalida() {
        // TODO: Implementar test que verifique que se lanza la excepción correcta
        // Given: un cliente con información inválida
        // When: se ejecuta la validación
        // Then: debe lanzar InformacionInvalidaException con mensaje descriptivo
        Executable validacion = () -> {
            throw new InformacionInvalidaException("El cliente es menor de edad");
        };
        assertThrows(InformacionInvalidaException.class, validacion);
    }
}