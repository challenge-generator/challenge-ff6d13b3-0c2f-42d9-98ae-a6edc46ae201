package com.fintech.payments.stepdefinitions;

import com.fintech.payments.questions.ElResultadoDeLaValidacion;
import com.fintech.payments.tasks.ValidarInformacionCliente;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class ValidarInformacionClienteSteps {

    @Dado("que el usuario {string} existe en el sistema")
    public void queElUsuarioExisteEnElSistema(String nombreActor) {
        Actor actor = Actor.named(nombreActor);
        actor.can(CallAnApi.at("http://localhost:8080/api"));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(nombreActor);
    }

    @Cuando("el usuario introduce los datos del cliente con email {string} y fecha de nacimiento {string}")
    public void elUsuarioIntroduceLosDatosDelCliente(String email, String fechaNacimiento) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            ValidarInformacionCliente.conDatos(email, fechaNacimiento)
        );
    }

    @Y("el límite de crédito es {double}")
    public void elLimiteDeCreditoEs(Double limiteCredito) {
    }

    @Entonces("el sistema debe validar que el cliente es mayor de edad")
    public void elSistemaDebeValidarQueElClienteEsMayorDeEdad() {
        OnStage.theActorInTheSpotlight()
            .should(seeThat(ElResultadoDeLaValidacion.esValida()));
    }

    @Entonces("el sistema debe mostrar un mensaje de error indicando que el cliente es menor de edad")
    public void elSistemaDebeMostrarUnMensajeDeErrorIndicandoQueElClienteEsMenorDeEdad() {
        OnStage.theActorInTheSpotlight()
            .should(seeThat(ElResultadoDeLaValidacion.tieneError(), is(true)));
    }

    @Entonces("el sistema debe validar que el límite de crédito es válido para el canal {string}")
    public void elSistemaDebeValidarQueElLimiteDeCreditoEsValidoParaElCanal(String canal) {
        OnStage.theActorInTheSpotlight()
            .should(seeThat(ElResultadoDeLaValidacion.esValida()));
    }

    @Entonces("el sistema debe rechazar la solicitud por límite de crédito insuficiente")
    public void elSistemaDebeRechazarLaSolicitudPorLimiteDeCreditoInsuficiente() {
        OnStage.theActorInTheSpotlight()
            .should(seeThat(ElResultadoDeLaValidacion.tieneError(), is(true)));
    }

    @Cuando("el usuario intenta validar un cliente con email inválido {string}")
    public void elUsuarioIntentaValidarUnClienteConEmailInvalido(String emailInvalido) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            ValidarInformacionCliente.conDatos(emailInvalido, "1990-01-01")
        );
    }

    @Entonces("el sistema debe lanzar una excepción {string}")
    public void elSistemaDebeLanzarUnaExcepcion(String tipoExcepcion) {
    }
}