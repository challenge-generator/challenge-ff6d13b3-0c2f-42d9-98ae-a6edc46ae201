package com.fintech.payments.exceptions;

public class InformacionInvalidaException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String codigoError;
    private String campo;
    private Object valorRecibido;
    private String operacion;

    public InformacionInvalidaException(String mensaje) {
        super(mensaje);
    }

    public InformacionInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public InformacionInvalidaException conCodigo(String codigoError) {
        this.codigoError = codigoError;
        return this;
    }

    public InformacionInvalidaException enCampo(String campo) {
        this.campo = campo;
        return this;
    }

    public InformacionInvalidaException conValor(Object valorRecibido) {
        this.valorRecibido = valorRecibido;
        return this;
    }

    public InformacionInvalidaException enOperacion(String operacion) {
        this.operacion = operacion;
        return this;
    }

    public String getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public Object getValorRecibido() {
        return valorRecibido;
    }

    public void setValorRecibido(Object valorRecibido) {
        this.valorRecibido = valorRecibido;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (codigoError != null) {
            sb.append("[").append(codigoError).append("] ");
        }
        sb.append(getMessage());
        if (campo != null) {
            sb.append(" | Campo: ").append(campo);
        }
        if (valorRecibido != null) {
            sb.append(" | Valor: ").append(valorRecibido);
        }
        if (operacion != null) {
            sb.append(" | Operación: ").append(operacion);
        }
        return sb.toString();
    }

    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"codigoError\":\"");
        sb.append(codigoError != null ? codigoError : "");
        sb.append("\",\"mensaje\":\"");
        sb.append(getMessage() != null ? getMessage().replace("\"", "\\\"") : "");
        sb.append("\",\"campo\":\"");
        sb.append(campo != null ? campo : "");
        sb.append("\",\"valorRecibido\":\"");
        sb.append(valorRecibido != null ? valorRecibido.toString() : "");
        sb.append("\",\"operacion\":\"");
        sb.append(operacion != null ? operacion : "");
        sb.append("\"}");
        return sb.toString();
    }
}