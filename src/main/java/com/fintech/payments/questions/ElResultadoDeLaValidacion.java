package com.fintech.payments.questions;

import com.fintech.payments.exceptions.InformacionInvalidaException;
import com.fintech.payments.models.Cliente;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class ElResultadoDeLaValidacion implements Question<ResultadoValidacion> {

    private final Cliente cliente;
    private final String numeroOperacion;
    private final String canal;

    public ElResultadoDeLaValidacion(Cliente cliente, String numeroOperacion, String canal) {
        this.cliente = cliente;
        this.numeroOperacion = numeroOperacion;
        this.canal = canal;
    }

    @Override
    public ResultadoValidacion answeredBy(Actor actor) {
        ResultadoValidacion resultado = new ResultadoValidacion();
        resultado.setValido(true);

        try {
            validarIdentificacion(resultado);
            validarMayoriaEdad(resultado);
            validarLimiteCredito(resultado);
            validarEmail(resultado);
            validarCanalRegistro(resultado);
            validarFechaNacimiento(resultado);
        } catch (InformacionInvalidaException e) {
            resultado.setValido(false);
            resultado.setMensajeError(e.getMessage());
            resultado.setCodigoError(e.getCodigoError());
        }

        return resultado;
    }

    private void validarIdentificacion(ResultadoValidacion resultado) {
        if (cliente.getIdCliente() == null || cliente.getIdCliente().trim().isEmpty()) {
            throw new InformacionInvalidaException(
                "El identificador del cliente es requerido para procesar la operación"
            ).conCodigo("CLI001");
        }
        if (cliente.getIdCliente().length() < 5) {
            throw new InformacionInvalidaException(
                "El identificador del cliente debe tener al menos 5 caracteres"
            ).conCodigo("CLI002");
        }
    }

    private void validarMayoriaEdad(ResultadoValidacion resultado) {
        if (cliente.getFechaNacimiento() == null) {
            throw new InformacionInvalidaException(
                "La fecha de nacimiento es requerida para validar mayoría de edad"
            ).conCodigo("FEC001");
        }
        if (!cliente.isMayorDeEdad()) {
            throw new InformacionInvalidaException(
                "El cliente debe ser mayor de edad para realizar operaciones financieras"
            ).conCodigo("EDAD001");
        }
    }

    private void validarLimiteCredito(ResultadoValidacion resultado) {
        if (cliente.getLimiteCredito() == null) {
            throw new InformacionInvalidaException(
                "El límite de crédito es requerido para procesar la operación"
            ).conCodigo("CRE001");
        }
        if (cliente.getLimiteCredito().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InformacionInvalidaException(
                "El límite de crédito debe ser mayor a cero"
            ).conCodigo("CRE002");
        }
        if (!cliente.isLimiteCreditoValidoParaCanal()) {
            throw new InformacionInvalidaException(
                "El límite de crédito no es válido para el canal de registro del cliente"
            ).conCodigo("CRE003");
        }
    }

    private void validarEmail(ResultadoValidacion resultado) {
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            throw new InformacionInvalidaException(
                "El correo electrónico es requerido para procesar la operación"
            ).conCodigo("EMA001");
        }
        String email = cliente.getEmail();
        if (!email.contains("@") || !email.contains(".")) {
            throw new InformacionInvalidaException(
                "El formato del correo electrónico es inválido"
            ).conCodigo("EMA002");
        }
    }

    private void validarCanalRegistro(ResultadoValidacion resultado) {
        if (cliente.getCanalRegistro() == null || cliente.getCanalRegistro().trim().isEmpty()) {
            throw new InformacionInvalidaException(
                "El canal de registro es requerido para procesar la operación"
            ).conCodigo("CAN001");
        }
    }

    private void validarFechaNacimiento(ResultadoValidacion resultado) {
        LocalDate fechaNacimiento = cliente.getFechaNacimiento();
        LocalDate ahora = LocalDate.now();
        
        if (fechaNacimiento.isAfter(ahora)) {
            throw new InformacionInvalidaException(
                "La fecha de nacimiento no puede ser futura"
            ).conCodigo("FEC002");
        }
    }

    public static ElResultadoDeLaValidacion es() {
        return new ElResultadoDeLaValidacion(null, null, null);
    }

    public ElResultadoDeLaValidacion paraCliente(Cliente cliente) {
        return new ElResultadoDeLaValidacion(cliente, this.numeroOperacion, this.canal);
    }

    public ElResultadoDeLaValidacion conOperacion(String numeroOperacion) {
        return new ElResultadoDeLaValidacion(this.cliente, numeroOperacion, this.canal);
    }

    public ElResultadoDeLaValidacion porCanal(String canal) {
        return new ElResultadoDeLaValidacion(this.cliente, this.numeroOperacion, canal);
    }

    public static class ResultadoValidacion {
        private boolean valido;
        private String mensajeError;
        private String codigoError;

        public boolean isValido() {
            return valido;
        }

        public void setValido(boolean valido) {
            this.valido = valido;
        }

        public String getMensajeError() {
            return mensajeError;
        }

        public void setMensajeError(String mensajeError) {
            this.mensajeError = mensajeError;
        }

        public String getCodigoError() {
            return codigoError;
        }

        public void setCodigoError(String codigoError) {
            this.codigoError = codigoError;
        }
    }
}