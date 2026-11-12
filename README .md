# ConexionTester

## Descripción
Aplicación de escritorio desarrollada en Java que permite comprobar la conexión con una base de datos mediante JDBC, utilizando una interfaz gráfica construida con Java Swing.

## Objetivo
Implementar una herramienta que permita ingresar los datos de conexión a una base de datos y verificar si la conexión se establece correctamente.

## Tecnologías utilizadas

- **Java:** lenguaje utilizado para desarrollar la aplicación.
- **Java Swing:** biblioteca utilizada para construir la interfaz gráfica.
- **JDBC:** API que permite establecer la comunicación entre Java y la base de datos.
- **SQLite:** sistema de base de datos local.
- **Apache Maven:** herramienta utilizada para administrar las dependencias del proyecto.
- **Visual Studio Code:** editor utilizado para desarrollar y ejecutar la aplicación.
- **Git y GitHub:** herramientas utilizadas para el control de versiones y almacenamiento del proyecto.

## Componentes de la interfaz gráfica

La interfaz se construyó utilizando los siguientes componentes de Java Swing:

- JFrame: ventana principal de la aplicación.

- JPanel: contenedor para organizar los elementos.

- JLabel: etiquetas descriptivas de los campos.

- JTextField: campos para ingresar la URL y el nombre de usuario.

- JPasswordField: campo para ingresar la contraseña.

- JButton: botón para iniciar la prueba de conexión.

- JTextArea: área destinada a mostrar los resultados.

- JScrollPane: permite desplazarse por el área de resultados.

## Funcionalidades
- Interfaz gráfica para ingresar los datos de conexión.
- Validación de conexión mediante JDBC.
- Visualización de mensajes de éxito y error.
- Manejo de excepciones.
- Cierre seguro de los recursos de conexión.
## Estructura del proyecto

ConexionTester/

│

├── src/

│   └── ConexionTester.java

│

├── README.md

└── .gitignore

└── pom.xml

## Configuración de la conexión con la base de datos

### Configuración de Maven

Se configuró Apache Maven mediante el archivo `pom.xml`, donde se agregó la dependencia `sqlite-jdbc`, necesaria para conectar Java con SQLite.

Maven permite descargar y administrar automáticamente esta biblioteca, evitando tener que agregar manualmente el archivo `.jar`.

### Conexión con SQLite

La aplicación utiliza la siguiente URL de conexión:

`jdbc:sqlite:inventario.db`

SQLite trabaja con una base de datos local y puede crear automáticamente el archivo `inventario.db` cuando se establece la conexión, si este todavía no existe.

La conexión se realiza mediante JDBC y la clase `DriverManager`. La interfaz permite ingresar los datos de conexión y ejecutar una prueba mediante el botón **Probar conexión**.

Además, se utiliza `try-with-resources` para cerrar automáticamente la conexión y el manejo de excepciones para identificar posibles errores.

### Ejecución del proyecto

Para compilar el proyecto desde la terminal se utiliza:

```bash
mvn clean compile
```

Para ejecutar la aplicación mediante Maven:

```bash
mvn exec:java -Dexec.mainClass=ConexionTester
```

También es posible ejecutar la clase principal directamente desde Visual Studio Code, una vez que el entorno Java reconoce las dependencias del proyecto.

### Archivos excluidos del repositorio

Se configuró el archivo `.gitignore` para excluir elementos que no necesitan almacenarse en GitHub:

- `target/`: contiene archivos generados durante la compilación de Maven.
- `inventario.db`: corresponde a la base de datos local utilizada para las pruebas.

Estos archivos se conservan en el equipo local, pero no forman parte de los archivos versionados en el repositorio.

## Control de versiones

El proyecto utiliza Git y GitHub para registrar los cambios realizados durante su desarrollo, mantener un historial de avances y facilitar la documentación del proceso.

## Autor
Joenny Barrera

Duberney Barrios

Laura Jaramillo.
