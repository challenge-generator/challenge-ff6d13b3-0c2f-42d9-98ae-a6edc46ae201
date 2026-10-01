package com.fintech.payments.models;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @NotNull(message = "El identificador del cliente no puede ser nulo")
    @Pattern(regexp = "^[A-Z]{2}\d{8,12}$", message = "El identificador debe tener formato XX seguido de 8 a 12 dígitos")
    private String idCliente;

    @NotBlank(message = "El nombre completo no puede estar vacío")
    @Size(min = 5, max = 100, message = "El nombre debe tener entre 5 y 100 caracteres")
    private String nombreCompleto;

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El formato del correo electrónico no es válido")
    private String email;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
    private LocalDate fechaNacimiento;

    @NotNull(message = "El límite de crédito no puede ser nulo")
    @PositiveOrZero(message = "El límite de crédito debe ser un valor positivo o cero")
    @Digits(integer = 10, fraction = 2, message = "El límite de crédito debe tener máximo 10 dígitos enteros y 2 decimales")
    private BigDecimal limiteCredito;

    @NotBlank(message = "El canal de registro no puede estar vacío")
    @Pattern(regexp = "^(APP|WEB|API|KIOSKO)$", message = "El canal debe ser uno de: APP, WEB, API, KIOSKO")
    private String canalRegistro;

    @NotNull(message = "La fecha de registro no puede ser nula")
    @PastOrPresent(message = "La fecha de registro no puede ser futura")
    private LocalDate fechaRegistro;

    @AssertTrue(message = "El cliente debe ser mayor de 18 años")
    public boolean isMayorDeEdad() {
        return fechaNacimiento != null &&
               fechaNacimiento.plusYears(18).isBefore(LocalDate.now()) ||
               fechaNacimiento.plusYears(18).isEqual(LocalDate.now());
    }

    @AssertTrue(message = "El límite de crédito no puede exceder 100,000 para clientes registrados por KIOSKO")
    public boolean isLimiteCreditoValidoParaCanal() {
        return !("KIOSKO".equals(canalRegistro) && limiteCredito != null && limiteCredito.compareTo(new BigDecimal("100000")) > 0);
    }

    public String generarClaveIdempotencia(String numeroOperacion) {
        return String.format("%s-%s-%s", idCliente, canalRegistro, numeroOperacion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return idCliente.equals(cliente.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente);
    }
}