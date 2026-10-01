# language: es
@transaccion @bdd
Funcionalidad: Procesamiento de transacciones
  Como originador de créditos
  Necesito procesar solicitudes de pago de manera idempotente
  Para garantizar que cada transacción se registre una sola vez y evitar duplicados

  # Escenario guiado por BDD - Fase 3
  @bdd-transaccion-exitosa
  Escenario: Procesar una transacción exitosa con validaciones completas
    Dado que el cliente "Juan Perez" está validado correctamente
    Y tiene un límite de crédito disponible de "10000.00"
    Y el monto de la transacción es "500.00"
    Y el número de operación es "TXN-2024-0001"
    Y el canal de origen es "WEB"
    Cuando el sistema procesa la transacción
    Entonces la transacción debe ser "APROBADA"
    Y se debe registrar en el sistema con estado "COMPLETADA"
    Y debe generar un comprobante con ID único

  # Escenario de validación de antifraude
  @bdd-antifraude
  Escenario: Transacción rechazada por motor antifraude
    Dado que el cliente "Carlos Rodriguez" está validado correctamente
    Y el monto de la transacción es "15000.00"
    Y el número de operación es "TXN-2024-0002"
    Y el canal de origen es "API"
    Cuando el sistema procesa la transacción
    Entonces la transacción debe ser "RECHAZADA"
    Y el motivo debe ser "Monto excede el límite de riesgo permitido"
    Y no debe generar comprobante

  # Escenario de idempotencia - primera solicitud
  @bdd-idempotencia-primera
  Escenario: Registrar primera solicitud con clave idempotente
    Dado que el cliente "Maria Lopez" está validado correctamente
    Y el monto de la transacción es "1000.00"
    Y el número de operación es "TXN-2024-0003"
    Y el canal de origen es "APP"
    Y no existe registro previo con clave idempotente
    Cuando el sistema procesa la transacción
    Entonces debe crear un nuevo registro de transacción
    Y el estado debe ser "PENDIENTE"
    Y debe almacenar la clave idempotente

  # Escenario de idempotencia - solicitud duplicada
  @bdd-idempotencia-duplicada
  Escenario: Retornar resultado existente para solicitud duplicada
    Dado que el cliente "Maria Lopez" está validado correctamente
    Y el monto de la transacción es "1000.00"
    Y el número de operación es "TXN-2024-0003"
    Y el canal de origen es "APP"
    Y ya existe un registro con la misma clave idempotencia
    Y el registro existente tiene estado "COMPLETADA"
    Cuando el sistema procesa la transacción
    Entonces debe retornar el registro existente
    Y no debe crear un nuevo registro
    Y debe retornar el mismo ID de transacción

  # Escenario de consulta a buró de riesgos
  @bdd-buro-riesgos
  Escenario: Transacción rechazada por buró de riesgos
    Dado que el cliente "Pedro Sanchez" está validado correctamente
    Y el monto de la transacción es "2000.00"
    Y el número de operación es "TXN-2024-0004"
    Y el canal de origen es "WEB"
    Y el buró de riesgos retorna score "650"
    Cuando el sistema procesa la transacción
    Entonces la transacción debe ser "RECHAZADA"
    Y el motivo debe ser "Score de riesgo insuficiente en buró"

  # Escenario de validación de saldo disponible
  @bdd-saldo-insuficiente
  Escenario: Transacción rechazada por saldo insuficiente
    Dado que el cliente "Ana Garcia" está validado correctamente
    Y tiene un límite de crédito disponible de "500.00"
    Y el monto de la transacción es "600.00"
    Y el número de operación es "TXN-2024-0005"
    Y el canal de origen es "API"
    Cuando el sistema procesa la transacción
    Entonces la transacción debe ser "RECHAZADA"
    Y el motivo debe ser "Saldo insuficiente para la operación"

  # Escenario de procesamiento en hora pico
  @bdd-rendimiento
  Escenario: Procesar transacción dentro de los parámetros de rendimiento
    Dado que el sistema está procesando "1500" solicitudes por segundo
    Y el cliente "Luis Martinez" está validado correctamente
    Y el monto de la transacción es "100.00"
    Y el número de operación es "TXN-2024-0006"
    Y el canal de origen es "APP"
    Cuando el sistema procesa la transacción
    Entonces la transacción debe ser "APROBADA"
    Y el tiempo de respuesta debe ser menor a "200" milisegundos