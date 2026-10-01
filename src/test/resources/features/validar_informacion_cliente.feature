# language: es
@validacion @tdd
Funcionalidad: Validación de información del cliente
  Como sistema de gestión de pagos
  Necesito validar la información del cliente antes de procesar cualquier transacción
  Para garantizar la seguridad y cumplimiento normativo del sistema

  # Escenario guiado por TDD - Fase 2
  @tdd-cliente-mayor-de-edad
  Escenario: Validar que un cliente mayor de edad es aprobado
    Dado que el cliente "Juan Perez" tiene 25 años de edad
    Y su correo electrónico es "juan.perez@fintech.com"
    Y está registrado por el canal "WEB"
    Cuando el sistema valida la información del cliente
    Entonces el resultado de la validación debe ser "APROBADO"
    Y se debe generar una clave de idempotencia única

  # Escenario para cliente menor de edad
  @tdd-cliente-menor-de-edad
  Escenario: Validar que un cliente menor de edad es rechazado
    Dado que el cliente "Maria Lopez" tiene 16 años de edad
    Y su correo electrónico es "maria.lopez@fintech.com"
    Y está registrada por el canal "APP"
    Cuando el sistema valida la información del cliente
    Entonces el resultado de la validación debe ser "RECHAZADO"
    Y el mensaje de error debe indicar "El cliente debe ser mayor de edad"

  # Escenario para límite de crédito por canal
  @tdd-limite-credito
  Escenario: Validar límite de crédito mínimo para canal WEB
    Dado que el cliente "Carlos Rodriguez" tiene 35 años
    Y su correo electrónico es "carlos.r@fintech.com"
    Y está registrado por el canal "WEB"
    Y tiene un límite de crédito de "5000.00"
    Cuando el sistema valida la información del cliente
    Entonces el resultado de la validación debe ser "APROBADO"
    Y el límite de crédito debe ser válido para el canal

  # Escenario para límite de crédito insuficiente
  @tdd-limite-insuficiente
  Escenario: Validar que el límite de crédito sea suficiente para el canal
    Dado que el cliente "Ana Garcia" tiene 40 años
    Y su correo electrónico es "ana.garcia@fintech.com"
    Y está registrada por el canal "API"
    Y tiene un límite de crédito de "0.00"
    Cuando el sistema valida la información del cliente
    Entonces el resultado de la validación debe ser "RECHAZADO"
    Y el mensaje de error debe indicar "El límite de crédito es insuficiente para el canal API"

  # Escenario para validación de email
  @tdd-email-invalido
  Escenario: Validar formato de correo electrónico
    Dado que el cliente "Pedro Sanchez" tiene 30 años
    Y su correo electrónico es "pedro.sanchez-invalido"
    Y está registrado por el canal "WEB"
    Cuando el sistema valida la información del cliente
    Entonces el resultado de la validación debe ser "RECHAZADO"
    Y el mensaje de error debe indicar "El formato del correo electrónico es inválido"

  # Escenario de generación de clave idempotencia
  @tdd-idempotencia
  Escenario: Generar clave de idempotencia para validación
    Dado que el cliente "Luis Martinez" tiene 28 años
    Y su correo electrónico es "luis.m@fintech.com"
    Y está registrado por el canal "APP"
    Y el número de operación es "OP-2024-001"
    Cuando el sistema valida la información del cliente
    Entonces debe generar una clave de idempotencia
    Y la clave debe contener el ID del cliente
    Y la clave debe contener el número de operación
    Y la clave debe contener el canal de registro