# CRUD Spring Boot con Java 23 y Postman

Este proyecto es un sistema CRUD (Crear, Leer, Actualizar, Eliminar) para la gestión de estudiantes, desarrollado con Spring Boot y Java 23, utilizando Postman para las pruebas de la API.

## ️ Tecnologías Utilizadas

-   **Backend:** Spring Boot
-   **Lenguaje:** Java 23
-   **Herramientas de Prueba:** Postman
-   **Base de Datos:** (Debes especificar la base de datos que utilizas, por ejemplo, PostgreSQL, MySQL, H2, etc.)

###  Dependencias Principales

-   Spring Web
-   Spring Data JPA (si utilizas JPA para la persistencia)
-   (Dependencia del driver de la base de datos que uses, por ejemplo, `postgresql`, `mysql-connector-java`, `h2database`)

---

##  Estructura del Proyecto

```
crud-spring-boot-postgres/
│
├── src/main/java/com/crud_estudiantes/
│   ├── controller/          # Controladores REST
│   │   └── EstudianteController.java
│   ├── entity/              # Entidades JPA
│   │   └── Estudiante.java
│   ├── repo/                # Repositorios
│   │   └── EstudianteRepo.java
│   ├── service/             # Lógica de negocio
│   │   └── EstudianteService.java
│   └── CrudEstudiantesApplication.java  # Clase principal
│
├── src/main/resources/
│   ├── application.properties  # Configuración de la app
│   └── data.sql                 # Datos iniciales (opcional)
│
├── postman/   # Colección de pruebas
│   └── CRUD_Estudiantes.postman_collection.json
│
├── README.md  # Este archivo
└── pom.xml    # Configuración de Maven
```



## Endpoints API

| Método  | Endpoint               | Descripción                         |
|----------|------------------------|-------------------------------------|
| **GET**  | `/estudiante`          | Listar todos los estudiantes       |
| **GET**  | `/estudiante/{id}`     | Obtener estudiante por ID          |
| **POST** | `/estudiante`          | Crear nuevo estudiante             |
| **PUT**  | `/estudiante`          | Actualizar estudiante existente    |
| **DELETE** | `/estudiante/{id}`   | Eliminar estudiante por ID         |

---

## Pruebas con Postman

### **Crear Estudiante (POST)**
**Endpoint:** `POST http://localhost:8080/estudiante`

```json
{
  "nombre": "Esther Sara",
  "apellido": "Copa Quispe",
  "email": "esther.copa@example.com",
  "fechaNacimiento": "2002-05-10",
  "numeroInscripcion": "S12345"
}
```
**Respuesta esperada:** `201 Created`

### **Listar Estudiantes (GET)**
**Endpoint:** `GET http://localhost:8080/estudiante`

### **Actualizar Estudiante (PUT)**
**Endpoint:** `PUT http://localhost:8080/estudiante`

```json
{
  "id": 1,
  "nombre": "Esther Sara",
  "apellido": "Copa Quispe",
  "email": "esther.copa@example.com",
  "fechaNacimiento": "2002-05-10",
  "numeroInscripcion": "S12345"
}
```
**Respuesta esperada:** `200 OK`

### **Eliminar Estudiante (DELETE)**
**Endpoint:** `DELETE http://localhost:8080/estudiante/1`

**Respuesta esperada:** `204 No Content`

## ‍ Desarrollado por

**Esther Sara Copa Quispe**

 Contacto: [e.sara.cq.25@gmail.com](mailto:e.sara.cq.25@gmail.com)

 Repositorio: [https://github.com/Sara200325/Practica_1](https://github.com/Sara200325/Practica_1)