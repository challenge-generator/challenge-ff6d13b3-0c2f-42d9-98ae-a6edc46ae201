# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de TDD y BDD en un Sistema de Gestión de Pagos**.

| | |
|---|---|
| Tema | TDD y BDD en Automatización de Pruebas |
| Nivel | senior-l2 |
| Chapter | Calidad de Software |
| Especialidad | Automatizador |
| Stack | Java / Serenity BDD con Cucumber y JUnit 5 |
| Patron arquitectonico | Screenplay con Page Object Model y capas de dominio segregadas |
| Tiempo estimado | 15 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz con el runner y el plugin de reportes`
- `src/test/resources/features con los .feature en Gherkin`
- `src/test/java/.../runners con el runner`
- `src/test/java/.../pages o /tasks con Page Objects o Screenplay`
- `src/test/java/.../steps con los step definitions`
- `serenity.conf o config del entorno`

Trampas conocidas:

- Sin parent POM que gestione versiones, TODA dependencia lleva su `<version>` completa de tres segmentos.
- El groupId de Serenity es `net.serenity-bdd`, NO `org.serenity-bdd`. Con el groupId equivocado el artefacto no existe y el build muere resolviendo dependencias.
- Coordenadas exactas de lo mas usado: Selenium `org.seleniumhq.selenium:selenium-java`, Rest Assured `io.rest-assured:rest-assured`, Karate `com.intuit.karate:karate-junit5`, Cucumber `io.cucumber:cucumber-java`.
- JUnit 5 se declara con `junit-jupiter` (agregador) y necesita `maven-surefire-plugin` reciente para ejecutarse.
- Serenity y Cucumber tienen que ser de lineas compatibles entre si; mezclarlas rompe el runner.

Dependencias:

- net.serenity-bdd:serenity-core 4.1.16
- net.serenity-bdd:serenity-cucumber 4.1.16
- io.cucumber:cucumber-java 7.15.0
- io.cucumber:cucumber-junit-platform-engine 7.15.0
- org.junit.jupiter:junit-jupiter 5.10.2
- org.seleniumhq.selenium:selenium-java 4.21.0
- io.rest-assured:rest-assured 5.4.0
- org.apache.maven.plugins:maven-surefire-plugin 3.2.5
- org.apache.maven.plugins:maven-failsafe-plugin 3.2.5
- jakarta.validation:jakarta.validation-api 3.0.2
- org.projectlombok:lombok 1.18.30

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean test-compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean test-compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Configuración del Entorno de Pruebas**: Entorno de pruebas configurado y listo para la aplicación de TDD y BDD.
- **Fase 2 — Implementación de Tests Unitarios con TDD**: Test unitario implementado y refactorizado para validar la información del cliente.
- **Fase 3 — Implementación de Tests de Comportamiento con BDD**: Escenario de comportamiento implementado y validado para el procesamiento de transacciones.
- **Fase 4 — Integración y Validación de las Funcionalidades**: Sistema de gestión de pagos con las funcionalidades implementadas y validadas mediante TDD y BDD.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/resources/features/validar_informacion_cliente.feature` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/resources/features/procesar_transaccion.feature` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/fintech/payments/runners/RunCucumberTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/fintech/payments/stepdefinitions/ValidarInformacionClienteSteps.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/fintech/payments/stepdefinitions/ProcesarTransaccionSteps.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/resources/serenity.conf` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/fintech/payments/TransaccionIntegrationTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/resources/data/clientes.csv` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (29)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `org.hamcrest.Matchers`
      El import org.hamcrest.Matchers pertenece a org.hamcrest.Matchers, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/fintech/payments/stepdefinitions/ValidarInformacionClienteSteps.java` — `org.hamcrest.Matchers`
      El import org.hamcrest.Matchers pertenece a org.hamcrest.Matchers, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/fintech/payments/stepdefinitions/ProcesarTransaccionSteps.java` — `org.hamcrest.Matchers`
      El import org.hamcrest.Matchers pertenece a org.hamcrest.Matchers, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/fintech/payments/TransaccionIntegrationTest.java` — `org.hamcrest.Matchers`
      El import org.hamcrest.Matchers pertenece a org.hamcrest.Matchers, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/fintech/payments/tasks/ValidarInformacionCliente.java` — `Cliente.getIdCliente`
      Se invoca `getIdCliente` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/tasks/ValidarInformacionCliente.java` — `Cliente.getFechaNacimiento`
      Se invoca `getFechaNacimiento` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/tasks/ValidarInformacionCliente.java` — `Cliente.getLimiteCredito`
      Se invoca `getLimiteCredito` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/tasks/ValidarInformacionCliente.java` — `Cliente.getEmail`
      Se invoca `getEmail` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/tasks/ValidarInformacionCliente.java` — `Cliente.getCanalRegistro`
      Se invoca `getCanalRegistro` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `ResultadoValidacion.setValido`
      Se invoca `setValido` sobre `ResultadoValidacion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `ResultadoValidacion.setMensajeError`
      Se invoca `setMensajeError` sobre `ResultadoValidacion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `InformacionInvalidaException.getMessage`
      Se invoca `getMessage` sobre `InformacionInvalidaException`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `ResultadoValidacion.setCodigoError`
      Se invoca `setCodigoError` sobre `ResultadoValidacion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `Cliente.getIdCliente`
      Se invoca `getIdCliente` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `Cliente.getFechaNacimiento`
      Se invoca `getFechaNacimiento` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `Cliente.getLimiteCredito`
      Se invoca `getLimiteCredito` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `Cliente.getEmail`
      Se invoca `getEmail` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `Cliente.getCanalRegistro`
      Se invoca `getCanalRegistro` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/utils/IdempotenciaUtils.java` — `EntradaIdempotencia.estaExpirada`
      Se invoca `estaExpirada` sobre `EntradaIdempotencia`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/fintech/payments/utils/IdempotenciaUtils.java` — `EntradaIdempotencia.getResultado`
      Se invoca `getResultado` sobre `EntradaIdempotencia`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setIdCliente`
      Se invoca `setIdCliente` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setNombreCompleto`
      Se invoca `setNombreCompleto` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setEmail`
      Se invoca `setEmail` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setFechaNacimiento`
      Se invoca `setFechaNacimiento` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setLimiteCredito`
      Se invoca `setLimiteCredito` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setCanalRegistro`
      Se invoca `setCanalRegistro` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setFechaRegistro`
      Se invoca `setFechaRegistro` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.getEmail`
      Se invoca `getEmail` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `pom.xml` — `net.serenity-bdd:serenity-bom@4.1.16`
      net.serenity-bdd:serenity-bom declara la version 4.1.16, pero Maven Central respondio que esa version no existe. Es una version inventada: reemplazala por una version publicada real, o si no se conoce con certeza, usa el mecanismo centralizado del ecosistema (BOM/parent/platform/version catalog) y no declares una version individual.

### Presentes (16)

- `pom.xml`
- `src/main/java/com/fintech/payments/models/Cliente.java`
- `src/main/java/com/fintech/payments/tasks/ValidarInformacionCliente.java`
- `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java`
- `src/main/java/com/fintech/payments/exceptions/InformacionInvalidaException.java`
- `src/main/java/com/fintech/payments/utils/IdempotenciaUtils.java`
- `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java`
- `src/test/resources/features/validar_informacion_cliente.feature`
- `src/test/resources/features/procesar_transaccion.feature`
- `src/test/java/com/fintech/payments/runners/RunCucumberTest.java`
- `src/test/java/com/fintech/payments/stepdefinitions/ValidarInformacionClienteSteps.java`
- `src/test/java/com/fintech/payments/stepdefinitions/ProcesarTransaccionSteps.java`
- `src/test/resources/serenity.conf`
- `src/test/java/com/fintech/payments/TransaccionIntegrationTest.java`
- `src/test/resources/data/clientes.csv`
- `README.md`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/fintech/payments`
- `src/main/java/com/fintech/payments/tasks`
- `src/main/java/com/fintech/payments/questions`
- `src/main/java/com/fintech/payments/interactions`
- `src/main/java/com/fintech/payments/models`
- `src/main/java/com/fintech/payments/exceptions`
- `src/main/java/com/fintech/payments/utils`
- `src/test/java/com/fintech/payments`
- `src/test/java/com/fintech/payments/runners`
- `src/test/java/com/fintech/payments/stepdefinitions`
- `src/test/resources/features`
- `src/test/resources/data`
- `src/test/resources/serenity.conf`

## Verificacion

```bash
mvn clean test-compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **Screenplay con Page Object Model y capas de dominio segregadas**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Calidad de Software, Especialidad Automatizador, Senior
- Brecha que el reto ataca: Demuestra su compromiso con la práctica de marcos como TDD y BDD, lo cual ademas de fortalecer su liderazgo, se traduce en la excelencia en calidad del producto, eficiencia del desarrollo y satisfacción del cliente, siendo clave para el éxito general del equipo y del proyecto
- Mision: Profesional Senior en Automatización de pruebas con experiencia en marcos de testing

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
