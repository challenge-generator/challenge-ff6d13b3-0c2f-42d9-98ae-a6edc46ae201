package com.fintech.payments.utils;

import com.fintech.payments.models.Cliente;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IdempotenciaUtils {

    private static final Map<String, EntradaIdempotencia> REGISTRO_IDEMPOTENCIA = new ConcurrentHashMap<>();
    private static final Duration VENTANA_TEMPORAL = Duration.ofHours(24);

    private IdempotenciaUtils() {
    }

    public static String generarClaveIdempotencia(Cliente cliente, String numeroOperacion, String canal) {
        if (numeroOperacion == null || numeroOperacion.isBlank()) {
            throw new IllegalArgumentException("El número de operación no puede ser nulo o vacío");
        }
        if (canal == null || canal.isBlank()) {
            throw new IllegalArgumentException("El canal no puede ser nulo o vacío");
        }
        String claveBase = numeroOperacion.trim().toUpperCase() + "|" + canal.trim().toUpperCase();
        return claveBase;
    }

    public static boolean esOperacionIdempotente(String claveIdempotencia, String numeroOperacion, String canal) {
        if (claveIdempotencia == null || claveIdempotencia.isBlank()) {
            return false;
        }
        String claveGenerada = numeroOperacion.trim().toUpperCase() + "|" + canal.trim().toUpperCase();
        return claveIdempotencia.equals(claveGenerada);
    }

    public static synchronized ResultadoIdempotencia registrarOperacion(String claveIdempotencia, Object resultado) {
        limpiarEntradasExpiradas();
        EntradaIdempotencia entradaExistente = REGISTRO_IDEMPOTENCIA.get(claveIdempotencia);
        if (entradaExistente != null) {
            if (!entradaExistente.estaExpirada()) {
                return new ResultadoIdempotencia(true, entradaExistente.getResultado(), false);
            } else {
                REGISTRO_IDEMPOTENCIA.remove(claveIdempotencia);
            }
        }
        Instant timestamp = Instant.now();
        EntradaIdempotencia nuevaEntrada = new EntradaIdempotencia(resultado, timestamp);
        REGISTRO_IDEMPOTENCIA.put(claveIdempotencia, nuevaEntrada);
        return new ResultadoIdempotencia(false, resultado, true);
    }

    public static synchronized Object obtenerResultadoPrevio(String claveIdempotencia) {
        EntradaIdempotencia entrada = REGISTRO_IDEMPOTENCIA.get(claveIdempotencia);
        if (entrada != null && !entrada.estaExpirada()) {
            return entrada.getResultado();
        }
        return null;
    }

    public static synchronized boolean verificarExistencia(String claveIdempotencia) {
        EntradaIdempotencia entrada = REGISTRO_IDEMPOTENCIA.get(claveIdempotencia);
        return entrada != null && !entrada.estaExpirada();
    }

    public static synchronized void limpiarEntradasExpiradas() {
        Instant ahora = Instant.now();
        REGISTRO_IDEMPOTENCIA.entrySet().removeIf(entry -> entry.getValue().estaExpirada());
    }

    public static synchronized void limpiarTodo() {
        REGISTRO_IDEMPOTENCIA.clear();
    }

    public static int obtenerCantidadRegistros() {
        return REGISTRO_IDEMPOTENCIA.size();
    }

    private static class EntradaIdempotencia {
        private final Object resultado;
        private final Instant timestamp;

        public EntradaIdempotencia(Object resultado, Instant timestamp) {
            this.resultado = resultado;
            this.timestamp = timestamp;
        }

        public Object getResultado() {
            return resultado;
        }

        public Instant getTimestamp() {
            return timestamp;
        }

        public boolean estaExpirada() {
            return Duration.between(timestamp, Instant.now()).compareTo(VENTANA_TEMPORAL) > 0;
        }

        public long getTiempoRestanteSegundos() {
            long segundosTranscurridos = Duration.between(timestamp, Instant.now()).getSeconds();
            long segundosTotales = VENTANA_TEMPORAL.getSeconds();
            return Math.max(0, segundosTotales - segundosTranscurridos);
        }
    }

    public static class ResultadoIdempotencia {
        private final boolean esDuplicado;
        private final Object resultado;
        private final boolean esNuevo;

        public ResultadoIdempotencia(boolean esDuplicado, Object resultado, boolean esNuevo) {
            this.esDuplicado = esDuplicado;
            this.resultado = resultado;
            this.esNuevo = esNuevo;
        }

        public boolean isEsDuplicado() {
            return esDuplicado;
        }

        public Object getResultado() {
            return resultado;
        }

        public boolean isEsNuevo() {
            return esNuevo;
        }
    }
}