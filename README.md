# Implementación de TDD y BDD en un Sistema de Gestión de Pagos

En el contexto de un sistema de gestión de pagos para una fintech, el objetivo es implementar y validar la práctica de Test Driven Development (TDD) y Behavior Driven Development (BDD) para garantizar la calidad del producto, eficiencia del desarrollo y satisfacción del cliente. El sistema debe manejar solicitudes de pago, validar información del cliente, consultar saldos y procesar transacciones. Los actores involucrados son el originador de créditos, el motor antifraude, el buró de riesgos y el core bancario. El sistema debe procesar un mínimo de 1 500 solicitudes por segundo en hora pico y mantener una latencia máxima de 200ms. La idempotencia del registro de la solicitud se garantiza por número de operación y canal, asegurando que dos invocaciones con la misma clave produzcan un solo registro y devuelvan la misma respuesta dentro de una ventana de 24 horas.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | TDD y BDD en Automatización de Pruebas |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 15 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración del Entorno de Pruebas

**Objetivo:** Establecer un entorno de pruebas que permita la aplicación de TDD y BDD.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Identificar las dependencias necesarias para aplicar TDD y BDD en el sistema de gestión de pagos.
- Configurar el entorno de pruebas para que soporte la ejecución de tests unitarios y de comportamiento.

**Entregable:** Entorno de pruebas configurado y listo para la aplicación de TDD y BDD.

<details>
<summary>Pistas de conocimiento</summary>

- Importancia de separar las responsabilidades en el código para facilitar las pruebas.
- Beneficios de la aplicación de TDD y BDD en el ciclo de desarrollo.

</details>

### Fase 2: Implementación de Tests Unitarios con TDD

**Objetivo:** Aplicar TDD para desarrollar una funcionalidad de validación de información del cliente.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Escribir un test unitario que falle inicialmente para validar la información del cliente.
- Implementar el código mínimo necesario para pasar el test.
- Refactorizar el código para mejorar su calidad y reutilización.

**Entregable:** Test unitario implementado y refactorizado para validar la información del cliente.

<details>
<summary>Pistas de conocimiento</summary>

- Importancia de escribir tests que fallen inicialmente en TDD.
- Principios de refactorización para mejorar la calidad del código.

</details>

### Fase 3: Implementación de Tests de Comportamiento con BDD

**Objetivo:** Aplicar BDD para desarrollar una funcionalidad de procesamiento de transacciones.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Escribir un escenario de comportamiento que describa el procesamiento de una transacción.
- Implementar el código necesario para pasar el escenario de comportamiento.
- Validar que el comportamiento del sistema coincide con las expectativas del negocio.

**Entregable:** Escenario de comportamiento implementado y validado para el procesamiento de transacciones.

<details>
<summary>Pistas de conocimiento</summary>

- Importancia de escribir escenarios de comportamiento en lenguaje del negocio.
- Cómo validar que el comportamiento del sistema coincide con las expectativas del negocio.

</details>

### Fase 4: Integración y Validación de las Funcionalidades

**Objetivo:** Integrar y validar las funcionalidades implementadas con TDD y BDD en el sistema de gestión de pagos.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Integrar las funcionalidades de validación de información del cliente y procesamiento de transacciones en el sistema.
- Ejecutar los tests unitarios y de comportamiento para validar el funcionamiento del sistema.
- Identificar y corregir cualquier fallo o inconsistencia en el comportamiento del sistema.

**Entregable:** Sistema de gestión de pagos con las funcionalidades implementadas y validadas mediante TDD y BDD.

<details>
<summary>Pistas de conocimiento</summary>

- Importancia de la integración y validación de las funcionalidades en el sistema.
- Cómo identificar y corregir fallos o inconsistencias en el comportamiento del sistema.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es TDD y BDD y cómo se aplican en el desarrollo de software?
- **paraQueSirve**: ¿Para qué sirven TDD y BDD en el ciclo de desarrollo y cómo mejoran la calidad del producto?
- **comoSeUsa**: ¿Cómo se aplica TDD para desarrollar una funcionalidad de validación de información del cliente?
- **erroresComunes**: ¿Cuáles son los errores comunes al aplicar TDD y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica la integración y validación de las funcionalidades implementadas con TDD y BDD en el sistema de gestión de pagos?

## Criterios de Evaluacion

- Configuración correcta del entorno de pruebas para aplicar TDD y BDD.
- Implementación y refactorización correcta de un test unitario con TDD.
- Implementación y validación correcta de un escenario de comportamiento con BDD.
- Integración y validación correcta de las funcionalidades implementadas con TDD y BDD en el sistema de gestión de pagos.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean test-compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
