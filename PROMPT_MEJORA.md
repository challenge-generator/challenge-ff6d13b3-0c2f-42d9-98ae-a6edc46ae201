# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/resources/features/validar_informacion_cliente.feature` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/resources/features/procesar_transaccion.feature` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/fintech/payments/runners/RunCucumberTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/fintech/payments/stepdefinitions/ValidarInformacionClienteSteps.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/fintech/payments/stepdefinitions/ProcesarTransaccionSteps.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/resources/serenity.conf` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/fintech/payments/TransaccionIntegrationTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/resources/data/clientes.csv` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `org.hamcrest.Matchers`: El import org.hamcrest.Matchers pertenece a org.hamcrest.Matchers, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/fintech/payments/stepdefinitions/ValidarInformacionClienteSteps.java` — `org.hamcrest.Matchers`: El import org.hamcrest.Matchers pertenece a org.hamcrest.Matchers, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/fintech/payments/stepdefinitions/ProcesarTransaccionSteps.java` — `org.hamcrest.Matchers`: El import org.hamcrest.Matchers pertenece a org.hamcrest.Matchers, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/fintech/payments/TransaccionIntegrationTest.java` — `org.hamcrest.Matchers`: El import org.hamcrest.Matchers pertenece a org.hamcrest.Matchers, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/fintech/payments/tasks/ValidarInformacionCliente.java` — `Cliente.getIdCliente`: Se invoca `getIdCliente` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/tasks/ValidarInformacionCliente.java` — `Cliente.getFechaNacimiento`: Se invoca `getFechaNacimiento` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/tasks/ValidarInformacionCliente.java` — `Cliente.getLimiteCredito`: Se invoca `getLimiteCredito` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/tasks/ValidarInformacionCliente.java` — `Cliente.getEmail`: Se invoca `getEmail` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/tasks/ValidarInformacionCliente.java` — `Cliente.getCanalRegistro`: Se invoca `getCanalRegistro` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `ResultadoValidacion.setValido`: Se invoca `setValido` sobre `ResultadoValidacion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `ResultadoValidacion.setMensajeError`: Se invoca `setMensajeError` sobre `ResultadoValidacion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `InformacionInvalidaException.getMessage`: Se invoca `getMessage` sobre `InformacionInvalidaException`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `ResultadoValidacion.setCodigoError`: Se invoca `setCodigoError` sobre `ResultadoValidacion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `Cliente.getIdCliente`: Se invoca `getIdCliente` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `Cliente.getFechaNacimiento`: Se invoca `getFechaNacimiento` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `Cliente.getLimiteCredito`: Se invoca `getLimiteCredito` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `Cliente.getEmail`: Se invoca `getEmail` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java` — `Cliente.getCanalRegistro`: Se invoca `getCanalRegistro` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/utils/IdempotenciaUtils.java` — `EntradaIdempotencia.estaExpirada`: Se invoca `estaExpirada` sobre `EntradaIdempotencia`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/payments/utils/IdempotenciaUtils.java` — `EntradaIdempotencia.getResultado`: Se invoca `getResultado` sobre `EntradaIdempotencia`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setIdCliente`: Se invoca `setIdCliente` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setNombreCompleto`: Se invoca `setNombreCompleto` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setEmail`: Se invoca `setEmail` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setFechaNacimiento`: Se invoca `setFechaNacimiento` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setLimiteCredito`: Se invoca `setLimiteCredito` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setCanalRegistro`: Se invoca `setCanalRegistro` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.setFechaRegistro`: Se invoca `setFechaRegistro` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java` — `Cliente.getEmail`: Se invoca `getEmail` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `pom.xml` — `net.serenity-bdd:serenity-bom@4.1.16`: net.serenity-bdd:serenity-bom declara la version 4.1.16, pero Maven Central respondio que esa version no existe. Es una version inventada: reemplazala por una version publicada real, o si no se conoce con certeza, usa el mecanismo centralizado del ecosistema (BOM/parent/platform/version catalog) y no declares una version individual.

## Como saber que terminaste

```bash
mvn clean test-compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Calidad de Software, Especialidad Automatizador, Senior

### Brecha de conocimiento
Demuestra su compromiso con la práctica de marcos como TDD y BDD, lo cual ademas de fortalecer su liderazgo, se traduce en la excelencia en calidad del producto, eficiencia del desarrollo y satisfacción del cliente, siendo clave para el éxito general del equipo y del proyecto

### Misión / candidato
Profesional Senior en Automatización de pruebas con experiencia en marcos de testing

### Reto
- Tema: TDD y BDD en Automatización de Pruebas
- Seniority: senior-l2
- Tipo: practical
- Título: Implementación de TDD y BDD en un Sistema de Gestión de Pagos
- Tiempo estimado: 15 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración del Entorno de Pruebas — objetivo: Establecer un entorno de pruebas que permita la aplicación de TDD y BDD. — entregable (NO resolver): Entorno de pruebas configurado y listo para la aplicación de TDD y BDD.
- Fase 2: Implementación de Tests Unitarios con TDD — objetivo: Aplicar TDD para desarrollar una funcionalidad de validación de información del cliente. — entregable (NO resolver): Test unitario implementado y refactorizado para validar la información del cliente.
- Fase 3: Implementación de Tests de Comportamiento con BDD — objetivo: Aplicar BDD para desarrollar una funcionalidad de procesamiento de transacciones. — entregable (NO resolver): Escenario de comportamiento implementado y validado para el procesamiento de transacciones.
- Fase 4: Integración y Validación de las Funcionalidades — objetivo: Integrar y validar las funcionalidades implementadas con TDD y BDD en el sistema de gestión de pagos. — entregable (NO resolver): Sistema de gestión de pagos con las funcionalidades implementadas y validadas mediante TDD y BDD.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.fintech.payments</groupId>
    <artifactId>payments-automation</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <serenity.version>4.1.16</serenity.version>
        <cucumber.version>7.15.0</cucumber.version>
        <junit.version>5.10.2</junit.version>
        <selenium.version>4.21.0</selenium.version>
        <restassured.version>5.4.0</restassured.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>net.serenity-bdd</groupId>
                <artifactId>serenity-bom</artifactId>
                <version>${serenity.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <!-- Serenity BDD -->
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-cucumber</artifactId>
        </dependency>

        <!-- Cucumber -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit-platform-engine</artifactId>
            <version>${cucumber.version}</version>
        </dependency>

        <!-- JUnit 5 -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>

        <!-- Selenium -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>${selenium.version}</version>
        </dependency>

        <!-- REST Assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>${restassured.version}</version>
            <scope>test</scope>
        </dependency>

        <!-- Jakarta Validation -->
        <dependency>
            <groupId>jakarta.validation</groupId>
            <artifactId>jakarta.validation-api</artifactId>
            <version>3.0.2</version>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
                <configuration>
                    <includes>
                        <include>**/*Test.java</include>
                        <include>**/*Steps.java</include>
                    </includes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-failsafe-plugin</artifactId>
                <version>3.2.5</version>
                <configuration>
                    <includes>
                        <include>**/RunCucumberTest.java</include>
                    </includes>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>integration-test</goal>
                            <goal>verify</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>net.serenity-bdd.maven.plugins</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>${serenity.version}</version>
                <executions>
                    <execution>
                        <id>serenity-reports</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>aggregate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/fintech/payments/models/Cliente.java ===
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

// === ARCHIVO: src/main/java/com/fintech/payments/tasks/ValidarInformacionCliente.java ===
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

// === ARCHIVO: src/main/java/com/fintech/payments/questions/ElResultadoDeLaValidacion.java ===
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

// === ARCHIVO: src/main/java/com/fintech/payments/exceptions/InformacionInvalidaException.java ===
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

// === ARCHIVO: src/main/java/com/fintech/payments/utils/IdempotenciaUtils.java ===
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

// === ARCHIVO: src/test/java/com/fintech/payments/ValidarInformacionClienteTest.java ===
package com.fintech.payments;

import com.fintech.payments.models.Cliente;
import com.fintech.payments.exceptions.InformacionInvalidaException;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.Actor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.time.LocalDate;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Superficie de práctica: Test unitario para validar información del cliente.
 * El estudiante debe implementar la lógica de validación siguiendo TDD.
 */
@Disabled("Superficie de práctica - implementar según las fases del reto")
class ValidarInformacionClienteTest {

    private Actor clienteActor;
    private Cliente clienteValido;
    private Cliente clienteMenorDeEdad;
    private Cliente clienteSinLimiteCredito;

    @BeforeEach
    void setUp() {
        OnStage.setTheStage(new OnlineCast());
        clienteActor = OnStage.theActorCalled("ClienteValidado");

        clienteValido = new Cliente();
        clienteValido.setIdCliente("CLI-001");
        clienteValido.setNombreCompleto("Juan Perez Gomez");
        clienteValido.setEmail("juan.perez@email.com");
        clienteValido.setFechaNacimiento(LocalDate.of(1990, 5, 15));
        clienteValido.setLimiteCredito(new BigDecimal("5000.00"));
        clienteValido.setCanalRegistro("WEB");
        clienteValido.setFechaRegistro(LocalDate.now());

        clienteMenorDeEdad = new Cliente();
        clienteMenorDeEdad.setIdCliente("CLI-002");
        clienteMenorDeEdad.setNombreCompleto("Maria Lopez");
        clienteMenorDeEdad.setEmail("maria.lopez@email.com");
        clienteMenorDeEdad.setFechaNacimiento(LocalDate.of(2010, 8, 20));
        clienteMenorDeEdad.setLimiteCredito(new BigDecimal("3000.00"));
        clienteMenorDeEdad.setCanalRegistro("APP");
        clienteMenorDeEdad.setFechaRegistro(LocalDate.now());

        clienteSinLimiteCredito = new Cliente();
        clienteSinLimiteCredito.setIdCliente("CLI-003");
        clienteSinLimiteCredito.setNombreCompleto("Pedro Sanchez");
        clienteSinLimiteCredito.setEmail("pedro.sanchez@email.com");
        clienteSinLimiteCredito.setFechaNacimiento(LocalDate.of(1985, 3, 10));
        clienteSinLimiteCredito.setLimiteCredito(BigDecimal.ZERO);
        clienteSinLimiteCredito.setCanalRegistro("API");
        clienteSinLimiteCredito.setFechaRegistro(LocalDate.now());
    }

    @Test
    void validarQueClienteMayorDeEdadEsAprobado() {
        // TODO: Implementar test que verifique que un cliente mayor de edad pasa la validación
        // Given: un cliente mayor de edad con datos válidos
        // When: se ejecuta la validación de información
        // Then: el resultado debe ser aprobado
        assertTrue(clienteValido.isMayorDeEdad(), "El cliente debe ser mayor de edad");
    }

    @Test
    void validarQueClienteMenorDeEdadEsRechazado() {
        // TODO: Implementar test que verifique que un cliente menor de edad no pasa la validación
        // Given: un cliente menor de edad
        // When: se ejecuta la validación de información
        // Then: debe lanzar InformacionInvalidaException
        assertFalse(clienteMenorDeEdad.isMayorDeEdad(), "El cliente no debe ser mayor de edad");
    }

    @Test
    void validarLimiteCreditoPorCanalWEB() {
        // TODO: Implementar test que verifique el límite de crédito para canal WEB
        // Given: un cliente registrado por el canal WEB
        // When: se valida el límite de crédito
        // Then: el límite debe ser válido para el canal WEB (mínimo 1000)
        assertTrue(clienteValido.isLimiteCreditoValidoParaCanal(),
            "El límite de crédito debe ser válido para el canal WEB");
    }

    @Test
    void validarLimiteCreditoInvalidoParaCanalAPI() {
        // TODO: Implementar test que verifique límite inválido para canal API
        // Given: un cliente registrado por el canal API con límite cero
        // When: se valida el límite de crédito
        // Then: debe retornar false
    }

    @Test
    void validarGeneracionDeClaveIdempotencia() {
        // TODO: Implementar test que verifique la generación de clave de idempotencia
        // Given: un cliente válido
        // When: se genera la clave de idempotencia con número de operación "OP-12345"
        // Then: debe generar una clave única basada en idCliente + numeroOperacion + canal
        String clave = clienteValido.generarClaveIdempotencia("OP-12345");
        assertThat(clave, is(notNullValue()));
        assertThat(clave, containsString("CLI-001"));
        assertThat(clave, containsString("OP-12345"));
    }

    @Test
    void validarEmailConFormatoValido() {
        // TODO: Implementar test que verifique formato de email válido
        // Given: un cliente con email en formato válido
        // When: se valida el email
        // Then: debe pasar la validación de formato
        assertTrue(clienteValido.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$"),
            "El email debe tener formato válido");
    }

    @Test
    void validarEmailConFormatoInvalido() {
        // TODO: Implementar test que verifique que email inválido es rechazado
        // Given: un cliente con email sin formato válido
        // When: se valida el email
        // Then: debe fallar la validación
    }

    @Test
    void validarIntegracionConValidarInformacionClienteTask() {
        // TODO: Implementar test de integración con el task de Serenity
        // Given: el actor ha iniciado sesión
        // When: el actor intenta validar información de cliente
        // Then: debe ver el resultado de la validación
    }

    @Test
    void validarExcepcionInformacionInvalida() {
        // TODO: Implementar test que verifique que se lanza la excepción correcta
        // Given: un cliente con información inválida
        // When: se ejecuta la validación
        // Then: debe lanzar InformacionInvalidaException con mensaje descriptivo
        Executable validacion = () -> {
            throw new InformacionInvalidaException("El cliente es menor de edad");
        };
        assertThrows(InformacionInvalidaException.class, validacion);
    }
}

// === ARCHIVO: src/test/resources/features/validar_informacion_cliente.feature ===
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

// === ARCHIVO: src/test/resources/features/procesar_transaccion.feature ===
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

// === ARCHIVO: src/test/java/com/fintech/payments/runners/RunCucumberTest.java ===
package com.fintech.payments.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.fintech.payments.stepdefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber/cucumber-report.html",
        "json:target/cucumber/cucumber.json",
        "junit:target/cucumber/cucumber-junit.xml"
    },
    tags = "@smoke or @regression",
    dryRun = false,
    strict = true
)
public class RunCucumberTest {
}

// === ARCHIVO: src/test/java/com/fintech/payments/stepdefinitions/ValidarInformacionClienteSteps.java ===
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

// === ARCHIVO: src/test/java/com/fintech/payments/stepdefinitions/ProcesarTransaccionSteps.java ===
package com.fintech.payments.stepdefinitions;

import com.fintech.payments.questions.ElResultadoDeLaValidacion;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Enonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class ProcesarTransaccionSteps {

    @Dado("que el cliente {string} tiene un límite de crédito de {double}")
    public void queElClienteTieneUnLimiteDeCreditoDe(String idCliente, Double limite) {
        Actor actor = Actor.named("Cliente_" + idCliente);
        actor.can(CallAnApi.at("http://localhost:8080/api"));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Cliente_" + idCliente);
    }

    @Cuando("el usuario inicia una transacción por {double} con número de operación {string}")
    public void elUsuarioIniciaUnaTransaccionPorConNumeroDeOperacion(Double monto, String numeroOperacion) {
    }

    @Y("el canal de origen es {string}")
    public void elCanalDeOrigenEs(String canal) {
    }

    @Entonces("el sistema debe procesar la transacción exitosamente")
    public void elSistemaDebeProcesarLaTransaccionExitosamente() {
        OnStage.theActorInTheSpotlight()
            .should(seeThat(ElResultadoDeLaValidacion.esValida()));
    }

    @Y("el sistema debe generar una clave de idempotencia única")
    public void elSistemaDebeGenerarUnaClaveDeIdempotenciaUnica() {
    }

    @Cuando("el usuario intenta procesar la misma transacción nuevamente")
    public void elUsuarioIntentaProcesarLaMismaTransaccionNuevamente() {
    }

    @Entonces("el sistema debe devolver la respuesta original sin procesar nuevamente")
    public void elSistemaDebeDevolverLaRespuestaOriginalSinProcesarNuevamente() {
    }

    @Cuando("el usuario intenta procesar una transacción por {double} que excede el límite")
    public void elUsuarioIntentaProcesarUnaTransaccionQueExcedeElLimite(Double monto) {
    }

    @Entonces("el sistema debe rechazar la transacción por monto excedido")
    public void elSistemaDebeRechazarLaTransaccionPorMontoExcedido() {
        OnStage.theActorInTheSpotlight()
            .should(seeThat(ElResultadoDeLaValidacion.tieneError(), is(true)));
    }

    @Dado("que el sistema está procesando {int} transacciones por segundo")
    public void queElSistemaEstaProcesandoTransaccionesPorSegundo(int tps) {
    }

    @Cuando("el usuario envía {int} solicitudes en un segundo")
    public void elUsuarioEnviaSolicitudesEnUnSegundo(int cantidad) {
    }

    @Entonces("el sistema debe mantener una latencia menor a {int} milisegundos")
    public void elSistemaDebeMantenerUnaLatenciaMenorAMilisegundos(int latenciaMax) {
    }

    @Y("el sistema debe procesar todas las solicitudes exitosamente")
    public void elSistemaDebeProcesarTodasLasSolicitudesExitosamente() {
    }
}

// === ARCHIVO: src/test/resources/serenity.conf ===
webdriver {
  driver = chrome
  auto.download = true
  implicit.timeout = 5000
}

environments {
  default = "qa"
  qa {
    base.url = "http://localhost:8080"
    api.url = "http://localhost:8080/api"
    timeout = 30000
  }
  staging {
    base.url = "https://staging.fintech.com"
    api.url = "https://staging.fintech.com/api"
    timeout = 45000
  }
  production {
    base.url = "https://fintech.com"
    api.url = "https://fintech.com/api"
    timeout = 60000
  }
}

serenity {
  take.screenshots = AFTER_EACH_STEP
  outputDirectory = "target/site/serenity"
  report = {
    title = "Reporte de Pruebas - Sistema de Pagos"
    show.step.details = true
  }
}

// === ARCHIVO: src/test/java/com/fintech/payments/TransaccionIntegrationTest.java ===
package com.fintech.payments;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TransaccionIntegrationTest {

    private static final String BASE_URL = "http://localhost:8080/api";
    private String idTransaccion;
    private String claveIdempotencia;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        idTransaccion = UUID.randomUUID().toString();
        claveIdempotencia = "OPE-" + System.currentTimeMillis() + "-CANAL-WEB";
    }

    @Test
    void debeProcesarTransaccionExitosa() {
        String requestBody = buildTransaccionRequest("CLI-001", new BigDecimal("1500.00"), "PAGO_CUENTA");

        given()
            .contentType(ContentType.JSON)
            .header("X-Idempotency-Key", claveIdempotencia)
            .body(requestBody)
        .when()
            .post("/transacciones/procesar")
        .then()
            .statusCode(200)
            .body("estado", equalTo("APROBADA"))
            .body("idTransaccion", notNullValue());
    }

    @Test
    void debeValidarMontoNegativo() {
        String requestBody = buildTransaccionRequest("CLI-002", new BigDecimal("-500.00"), "TRANSFERENCIA");

        given()
            .contentType(ContentType.JSON)
            .header("X-Idempotency-Key", claveIdempotencia + "-neg")
            .body(requestBody)
        .when()
            .post("/transacciones/procesar")
        .then()
            .statusCode(400)
            .body("mensaje", containsString("monto"));
    }

    @Test
    void debeRechazarTransaccionPorFraude() {
        String requestBody = buildTransaccionRequest("CLI-003", new BigDecimal("50000.00"), "TRANSFERENCIA");

        given()
            .contentType(ContentType.JSON)
            .header("X-Idempotency-Key", claveIdempotencia + "-fraude")
            .body(requestBody)
        .when()
            .post("/transacciones/procesar")
        .then()
            .statusCode(422)
            .body("estado", equalTo("RECHAZADA"))
            .body("motivo", containsString("fraude"));
    }

    @Test
    void debeGarantizarIdempotencia() {
        String requestBody = buildTransaccionRequest("CLI-004", new BigDecimal("100.00"), "PAGO_CUENTA");
        String claveIdempotente = "OPE-IDEMP-" + System.currentTimeMillis();

        Response respuesta1 = given()
            .contentType(ContentType.JSON)
            .header("X-Idempotency-Key", claveIdempotente)
            .body(requestBody)
        .when()
            .post("/transacciones/procesar");

        String idPrimera = respuesta1.getBody().jsonPath().getString("idTransaccion");

        Response respuesta2 = given()
            .contentType(ContentType.JSON)
            .header("X-Idempotency-Key", claveIdempotente)
            .body(requestBody)
        .when()
            .post("/transacciones/procesar");

        String idSegunda = respuesta2.getBody().jsonPath().getString("idTransaccion");

        respuesta1.then().statusCode(200);
        respuesta2.then().statusCode(200);
        org.junit.jupiter.api.Assertions.assertEquals(idPrimera, idSegunda,
            "La clave idempotente debe devolver la misma transacción");
    }

    @Test
    void debeConsultarEstadoTransaccion() {
        String requestBody = buildTransaccionRequest("CLI-005", new BigDecimal("200.00"), "PAGO_SERVICIO");

        Response crearResponse = given()
            .contentType(ContentType.JSON)
            .header("X-Idempotency-Key", claveIdempotencia + "-consulta")
            .body(requestBody)
        .when()
            .post("/transacciones/procesar");

        String idTrans = crearResponse.getBody().jsonPath().getString("idTransaccion");

        given()
            .pathParam("id", idTrans)
        .when()
            .get("/transacciones/{id}")
        .then()
            .statusCode(200)
            .body("idTransaccion", equalTo(idTrans))
            .body("estado", notNullValue());
    }

    private String buildTransaccionRequest(String idCliente, BigDecimal monto, String tipoOperacion) {
        return String.format("""
            {
                "idCliente": "%s",
                "monto": %s,
                "tipoOperacion": "%s",
                "cuentaDestino": "CUENTA-%s",
                "descripcion": "Test automatizado",
                "fechaOperacion": "%s"
            }
            """, idCliente, monto, tipoOperacion, idCliente, LocalDateTime.now().toString());
    }
}

// === ARCHIVO: src/test/resources/data/clientes.csv ===
id_cliente,nombre_completo,email,fecha_nacimiento,limite_credito,canal_registro,fecha_registro,estado_cliente,es_mayor_edad,limite_valido
CLI-001,Maria Garcia,maria.garcia@email.com,1990-05-15,15000.00,WEB,2023-01-15,ACTIVO,true,true
CLI-002,Juan Lopez,juan.lopez@email.com,2005-12-20,8000.00,MOBILE,2023-02-10,ACTIVO,false,true
CLI-003,Carlos Rodriguez,carlos.r@email.com,1985-08-30,25000.00,WEB,2022-11-05,ACTIVO,true,true
CLI-004,Ana Martinez,ana.martinez@email.com,1992-03-22,12000.00,AGENCIA,2023-03-01,ACTIVO,true,true
CLI-005,Pedro Sanchez,pedro.s@email.com,1988-07-14,5000.00,WEB,2023-04-20,SUSPENDIDO,true,true
CLI-006,Laura Torres,laura.torres@email.com,1995-11-08,18000.00,MOBILE,2023-01-25,ACTIVO,true,true
CLI-007,Miguel Hernandez,miguel.h@email.com,2000-01-01,3000.00,WEB,2023-05-10,ACTIVO,true,false
CLI-008,Isabel Ramirez,isabel.ramirez@email.com,1982-06-18,35000.00,AGENCIA,2022-08-15,ACTIVO,true,true
CLI-009,David Gonzalez,david.g@email.com,1998-09-25,6000.00,MOBILE,2023-06-01,INACTIVO,true,true
CLI-010,Patricia Lopez,patricia.l@email.com,1975-04-12,50000.00,WEB,2021-12-01,ACTIVO,true,true
CLI-011,Fernando Castro,fernando.c@email.com,2006-02-28,2000.00,MOBILE,2023-07-15,ACTIVO,false,true
CLI-012,Sofia Ruiz,sofia.ruiz@email.com,1993-10-05,22000.00,WEB,2022-09-20,ACTIVO,true,true
CLI-013,Alejandro Diaz,alejandro.d@email.com,1989-12-31,15000.00,AGENCIA,2023-02-14,ACTIVO,true,true
CLI-014,Claudia Morales,claudia.m@email.com,1991-07-09,10000.00,MOBILE,2023-03-25,ACTIVO,true,true
CLI-015,Roberto Vega,roberto.vega@email.com,1987-03-17,28000.00,WEB,2022-10-10,ACTIVO,true,true

// === ARCHIVO: README.md ===
# Payments Automation - Serenity BDD

Proyecto de automatización de pruebas para el sistema de gestión de pagos de fintech, implementado con Serenity BDD, Cucumber y JUnit 5. Utiliza el patrón Screenplay para separar las tareas, preguntas e interacciones del actor, garantizando mantenibilidad y legibilidad en los escenarios de comportamiento.

## Requisitos del Entorno

Para ejecutar este proyecto necesitas:

- **Java Development Kit (JDK) 21** - Verifica la instalación con `java -version`
- **Apache Maven 3.9+** - Verifica con `mvn -version`
- **Navegador Web** - Chrome o Firefox para pruebas de interfaz de usuario
- **Variables de entorno** - Configura JAVA_HOME apuntando al directorio del JDK

## Estructura del Proyecto

```
payments-automation/
├── pom.xml                          # Manifiesto de dependencias Maven
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/fintech/payments/
│   │           ├── models/          # Entidades del dominio
│   │           ├── tasks/           # Tareas Screenplay
│   │           ├── questions/       # Preguntas Screenplay
│   │           ├── exceptions/      # Excepciones personalizadas
│   │           └── utils/           # Utilidades de apoyo
│   └── test/
│       ├── java/
│       │   └── com/fintech/payments/
│       │       ├── runners/         # Ejecutores Cucumber
│       │       └── stepdefinitions/ # Definiciones de pasos
│       ├── resources/
│       │   ├── features/            # Escenarios Gherkin
│       │   ├── serenity.conf        # Configuración Serenity
│       │   └── data/                # Datos de prueba CSV
│       └── features/
└── target/                          # Compilación y reportes
```

## Configuración Inicial

### 1. Compilar el Proyecto

```bash
mvn clean compile
```

Este comando descarga todas las dependencias declaradas en el pom.xml, compila el código fuente y prepara el entorno de ejecución. La primera ejecución puede tomar varios minutos dependiendo de la velocidad de tu conexión a internet.

### 2. Compilar Tests

```bash
mvn test-compile
```

Este comando compila los archivos de prueba located en src/test. Verifica que no haya errores de compilación en los step definitions, runners y clases de test antes de ejecutar las pruebas.

## Ejecución de Pruebas

### Tests Unitarios JUnit 5

Ejecuta solo los tests unitarios con:

```bash
mvn test
```

Este comando ejecuta todos los métodos de prueba marcados con @Test en las clases del directorio src/test/java. Los resultados se muestran en la consola y se genera un reporte HTML básico en target/surefire-reports.

### Tests de Integración BDD con Cucumber

Ejecuta los escenarios BDD mediante el runner de Cucumber:

```bash
mvn verify
```

El comando verify ejecuta el ciclo completo: compila el proyecto, ejecuta los tests de integración mediante maven-failsafe-plugin, y genera los reportes Serenity. Este es el comando recomendado para validar el comportamiento del sistema.

### Ejecutar Escenario Específico

Para ejecutar un archivo feature específico, modifica el runner o ejecuta con el filtro de tags:

```bash
mvn verify -Dcucumber.filter.tags="@smoke"
```

Los tags permiten ejecutar subconjuntos de escenarios. Define tags en tus archivos .feature como @smoke, @regression, @integration, etc.

## Reportes Serenity

### Reporte HTML Aggregate

Después de ejecutar `mvn verify`, genera el reporte Serenity con:

```bash
mvn serenity:aggregate
```

Este comando produce un reporte interactivo en target/site/serenity/index.html que incluye:

- Resumen ejecutivo de resultados
- Gráficos de tendencias
- Detalle de cada escenario ejecutado
- Evidencia de pantallas capturadas (si aplica)
- Trazas de ejecución con timestamps

### Visualizar Reporte en Navegador

Abre el reporte generado en tu navegador:

```bash
# En Linux/Mac
xdg-open target/site/serenity/index.html

# En Windows
start target/site/serenity/index.html

# En Mac
open target/site/serenity/index.html
```

## Configuración de Serenity

El archivo src/test/resources/serenity.conf contiene la configuración del entorno de pruebas. Puedes ajustar:

- URL base del sistema bajo prueba
- Tiempo de espera implícito
- Configuración del driver Selenium
- Nivel de logs

```properties
webdriver.base.url=https://demo.payments.fintech.com
webdriver.wait.for.timeout=5000
serenity.take.screenshots=FOR_FAILURES
```

## Patrón Screenplay

Este proyecto implementa el patrón Screenplay, una evolución del Page Object Model que promueve:

- **Separación de responsabilidades**: Las tareas (Tasks) representan acciones del actor, las preguntas (Questions) obtienen información del sistema, y los interactions manipulan elementos de interfaz.
- **Reusabilidad**: Las tareas pueden componerse para crear flujos complejos.
- **Legibilidad**: Los escenarios Gherkin se leen como sentences en lenguaje natural.

### Estructura de una Tarea Screenplay

```java
public class RealizarPago implements Task {
    private final BigDecimal monto;
    
    public RealizarPago(BigDecimal monto) {
        this.monto = monto;
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(monto).into(PagoPage.MONTO_CAMPO),
            Click.on(PagoPage.BOTON_ENVIAR)
        );
    }
}
```

## Escenarios Gherkin

Los archivos .feature en src/test/resources/features definen el comportamiento esperado usando la sintaxis Given-When-Then:

```gherkin
Feature: Validación de información del cliente
  
  Scenario: Cliente mayor de edad con límite de crédito válido
    Given el cliente "Juan Pérez" con email "juan@fintech.com"
    And tiene 25 años de edad
    And el canal de registro es "APP_MOVIL"
    When valido su información
    Then el sistema debe aprobar la validación
```

## Datos de Prueba

Los archivos CSV en src/test/resources/data/ contienen los datos de prueba utilizados en los escenarios. Formato esperado: заголовки en primera fila, valores separados por comas.

## Troubleshooting

### Error: Dependencias no resueltas

Si Maven no puede resolver dependencias, verifica tu conexión a internet y el archivo pom.xml. Ejecuta:

```bash
mvn dependency:resolve
```

### Error: Tests fallan por timeout

Aumenta el tiempo de espera en serenity.conf o usa:

```bash
mvn verify -Dwebdriver.wait.for.timeout=10000
```

### Error: Driver de navegador no encontrado

Serenity descarga automáticamente el WebDriver. Si persisten problemas, descarga manualmente ChromeDriver y agrega al PATH del sistema.

## Comandos Útiles

| Comando | Descripción |
|---------|-------------|
| `mvn clean` | Limpia el directorio target |
| `mvn compile` | Compila código fuente |
| `mvn test-compile` | Compila tests |
| `mvn test` | Ejecuta tests unitarios |
| `mvn verify` | Ejecuta tests de integración |
| `mvn serenity:aggregate` | Genera reporte Serenity |
| `mvn clean test` | Limpia y ejecuta tests unitarios |
| `mvn clean verify` | Limpia y ejecuta integración completa |

## Métricas de Calidad

El proyecto mide:

- **Cobertura de código**: Porcentaje de clases/métodos ejercitados
- **Tasa de éxito**: Porcentaje de escenarios que pasan
- **Tiempo de ejecución**: Duración total del suite de pruebas
- **Reportes**: Generación automática de evidencia HTML

## Siguientes Pasos

1. Ejecutar `mvn clean verify` para validar el entorno
2. Revisar el reporte Serenity generado
3. Ejecutar tests específicos por tag
4. Agregar nuevos escenarios en archivos .feature
5. Implementar nuevos step definitions según necesidad
```
