PROYECTO: JAVA_SGRH
Evidencia: GA7-220501096-AA3-EV01
Aprendiz: Alexis Gonzalez Sogamoso

Repositorio del proyecto (GitHub):
[https://github.com/alexispasta/codificaci-n-de-m-dulos-del-software-Stand-alone/tree/40e8d36ecb07b41720690e6bbcfd16b2cbf649a5]  

Descripción del proyecto:
Este proyecto corresponde a la codificación del módulo principal del sistema de información para gestión de recursos humanos (SGRH), desarrollado como aplicación web utilizando el framework Spring Boot junto con Hibernate para la gestión de datos y Maven para la gestión de dependencias.

El sistema incluye funcionalidades completas para gestionar entidades como Empresa, Persona, Asistencia, Certificados, Permisos, Reportes, Informes, y Nómina. Cada entidad cuenta con su respectivo controlador REST para las operaciones CRUD (crear, leer, actualizar, eliminar), conectados a una base de datos MySQL.

Estructura del proyecto:
- `modelo`: contiene las clases entidad (annotadas con `@Entity`) como Persona, Empresa, Asistencia, etc.
- `repositorio`: contiene interfaces que extienden `JpaRepository` para interactuar con la base de datos.
- `controller`: contiene los controladores REST que exponen los endpoints HTTP.
- `DemoApplication.java`: clase principal que arranca el proyecto y verifica la conexión con los repositorios.

Frameworks y tecnologías utilizadas:
- Java 17
- Spring Boot
- Hibernate (JPA)
- Maven (gestor de dependencias)
- MySQL
- Spring Data JPA
- Spring Web (RESTful API)
- Visual Studio Code y/o IntelliJ IDEA
- MySQL Workbench

Pruebas:
Cada clase de controlador ha sido probada individualmente a través de solicitudes HTTP a los endpoints `/personas`, `/asistencias`, `/reportes`, etc., usando herramientas como Postman o navegador. También se incluyó un `CommandLineRunner` para verificar al inicio la cantidad de registros en cada tabla.

Instrucciones básicas para ejecución:
1. Clonar el repositorio.
2. Crear una base de datos MySQL y ejecutar el script SQL correspondiente para crear las tablas.
3. Configurar `application.properties` con los datos de conexión a la base de datos.
4. Ejecutar el proyecto con `SpringApplication.run()` desde la clase `DemoApplication`.
5. Probar los endpoints disponibles con herramientas como Postman.

Observaciones:
- La codificación sigue los estándares recomendados por Spring.
- Se utilizaron anotaciones `@RestController`, `@Entity`, `@Autowired`, `@ManyToOne`, `@Enumerated`, etc.
- El proyecto fue construido en base a los artefactos generados en evidencias anteriores: historias de usuario, casos de uso, prototipos y diagramas de clases.

