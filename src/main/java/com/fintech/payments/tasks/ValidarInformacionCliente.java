package com.fintech.payments.tasks;

import com.fintech.payments.exceptions.InformacionInvalidaException;
import com.fintech.payments.models.Cliente;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class ValidarInformacionCliente implements Task {

    private final Cliente cliente;
    private final String numeroOperacion;
    private final String canal;

    public ValidarInformacionCliente(Cliente cliente, String numeroOperacion, String canal) {
        this.cliente = cliente;
        this.numeroOperacion = numeroOperacion;
        this.canal = canal;
    }

    @Override
    @Step("{0} valida la información del cliente")
    public <T extends Actor> void performAs(T actor) {
        validarIdentificacion();
        validarMayoriaEdad();
        validarLimiteCredito();
        validarEmail();
        validarCanalRegistro();
        validarFechaNacimiento();
    }

    private void validarIdentificacion() {
        if (cliente.getIdCliente() == null || cliente.getIdCliente().trim().isEmpty()) {
            throw new InformacionInvalidaException(
                "El identificador del cliente es requerido para procesar la operación"
            );
        }
        if (cliente.getIdCliente().length() < 5) {
            throw new InformacionInvalidaException(
                "El identificador del cliente debe tener al menos 5 caracteres"
            );
        }
    }

    private void validarMayoriaEdad() {
        if (cliente.getFechaNacimiento() == null) {
            throw new InformacionInvalidaException(
                "La fecha de nacimiento es requerida para validar mayoría de edad"
            );
        }
        if (!cliente.isMayorDeEdad()) {
            throw new InformacionInvalidaException(
                "El cliente debe ser mayor de edad para realizar operaciones financieras. " +
                "Fecha de nacimiento: " + cliente.getFechaNacimiento()
            );
        }
    }

    private void validarLimiteCredito() {
        if (cliente.getLimiteCredito() == null) {
            throw new InformacionInvalidaException(
                "El límite de crédito es requerido para procesar la operación"
            );
        }
        if (cliente.getLimiteCredito().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InformacionInvalidaException(
                "El límite de crédito debe ser mayor a cero"
            );
        }
        if (!cliente.isLimiteCreditoValidoParaCanal()) {
            BigDecimal limite = cliente.getLimiteCredito();
            throw new InformacionInvalidaException(
                "El límite de crédito de " + limite + " no es válido para el canal de registro del cliente"
            );
        }
    }

    private void validarEmail() {
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            throw new InformacionInvalidaException(
                "El correo electrónico es requerido para procesar la operación"
            );
        }
        String email = cliente.getEmail();
        if (!email.contains("@") || !email.contains(".")) {
            throw new InformacionInvalidaException(
                "El formato del correo electrónico es inválido: " + email
            );
        }
        if (email.length() > 254) {
            throw new InformacionInvalidaException(
                "El correo electrónico excede la longitud máxima permitida"
            );
        }
    }

    private void validarCanalRegistro() {
        if (cliente.getCanalRegistro() == null || cliente.getCanalRegistro().trim().isEmpty()) {
            throw new InformacionInvalidaException(
                "El canal de registro es requerido para procesar la operación"
            );
        }
        String canalValido = cliente.getCanalRegistro().toUpperCase();
        if (!canalValido.equals("WEB") && !canalValido.equals("MOVIL") && 
            !canalValido.equals("SUCURSAL") && !canalValido.equals("API")) {
            throw new InformacionInvalidaException(
                "El canal de registro debe ser uno de: WEB, MOVIL, SUCURSAL, API. " +
                "Canal proporcionado: " + cliente.getCanalRegistro()
            );
        }
    }

    private void validarFechaNacimiento() {
        LocalDate fechaNacimiento = cliente.getFechaNacimiento();
        LocalDate ahora = LocalDate.now();
        
        if (fechaNacimiento.isAfter(ahora)) {
            throw new InformacionInvalidaException(
                "La fecha de nacimiento no puede ser futura"
            );
        }
        
        int edad = Period.between(fechaNacimiento, ahora).getYears();
        if (edad > 120) {
            throw new InformacionInvalidaException(
                "La fecha de nacimiento indica una edad inválida mayor a 120 años"
            );
        }
    }

    public static ValidarInformacionCliente conDatos(Cliente cliente, String numeroOperacion, String canal) {
        return new ValidarInformacionCliente(cliente, numeroOperacion, canal);
    }
}