package com.fintech.payments.stepdefinitions;

import com.fintech.payments.questions.ElResultadoDeLaValidacion;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Enonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class ProcesarTransaccionSteps {

    @Dado("que el cliente {string} tiene un límite de crédito de {double}")
    public void queElClienteTieneUnLimiteDeCreditoDe(String idCliente, Double limite) {
        Actor actor = Actor.named("Cliente_" + idCliente);
        actor.can(CallAnApi.at("http://localhost:8080/api"));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Cliente_" + idCliente);
    }

    @Cuando("el usuario inicia una transacción por {double} con número de operación {string}")
    public void elUsuarioIniciaUnaTransaccionPorConNumeroDeOperacion(Double monto, String numeroOperacion) {
    }

    @Y("el canal de origen es {string}")
    public void elCanalDeOrigenEs(String canal) {
    }

    @Entonces("el sistema debe procesar la transacción exitosamente")
    public void elSistemaDebeProcesarLaTransaccionExitosamente() {
        OnStage.theActorInTheSpotlight()
            .should(seeThat(ElResultadoDeLaValidacion.esValida()));
    }

    @Y("el sistema debe generar una clave de idempotencia única")
    public void elSistemaDebeGenerarUnaClaveDeIdempotenciaUnica() {
    }

    @Cuando("el usuario intenta procesar la misma transacción nuevamente")
    public void elUsuarioIntentaProcesarLaMismaTransaccionNuevamente() {
    }

    @Entonces("el sistema debe devolver la respuesta original sin procesar nuevamente")
    public void elSistemaDebeDevolverLaRespuestaOriginalSinProcesarNuevamente() {
    }

    @Cuando("el usuario intenta procesar una transacción por {double} que excede el límite")
    public void elUsuarioIntentaProcesarUnaTransaccionQueExcedeElLimite(Double monto) {
    }

    @Entonces("el sistema debe rechazar la transacción por monto excedido")
    public void elSistemaDebeRechazarLaTransaccionPorMontoExcedido() {
        OnStage.theActorInTheSpotlight()
            .should(seeThat(ElResultadoDeLaValidacion.tieneError(), is(true)));
    }

    @Dado("que el sistema está procesando {int} transacciones por segundo")
    public void queElSistemaEstaProcesandoTransaccionesPorSegundo(int tps) {
    }

    @Cuando("el usuario envía {int} solicitudes en un segundo")
    public void elUsuarioEnviaSolicitudesEnUnSegundo(int cantidad) {
    }

    @Entonces("el sistema debe mantener una latencia menor a {int} milisegundos")
    public void elSistemaDebeMantenerUnaLatenciaMenorAMilisegundos(int latenciaMax) {
    }

    @Y("el sistema debe procesar todas las solicitudes exitosamente")
    public void elSistemaDebeProcesarTodasLasSolicitudesExitosamente() {
    }
}