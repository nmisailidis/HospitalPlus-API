# HospitalPlus-API

A modern, secure REST API for hospital patient management, built with **Spring Boot**.

**HospitalPlus-API** is the next-generation evolution of [HospitalPlus](https://github.com/nmisailidis/HospitalPlus) — a console-based Hospital Management System originally built with Java, JDBC and MySQL. This project re-imagines it as a layered, production-oriented web service with PostgreSQL persistence, JWT-based authentication and fully documented endpoints.

> **📌 Project Status:** 🚧 Under Active Development (September 2026).
> This repository is being built incrementally following a structured roadmap. See the [Roadmap](#%EF%B8%8F-roadmap) section for live progress.

---

## ✨ Features

- **Patient Management (CRUD)** — Create, read, update and delete patient records
- **Advanced Search** — Query patients by AMKA
- **JWT Authentication** — Stateless, token-based security with BCrypt password hashing
- **Protected Endpoints** — All patient routes require a valid Bearer token
- **Input Validation** — Bean Validation with meaningful error responses
- **Centralized Error Handling** — Consistent API errors via `@ControllerAdvice`
- **API Documentation** — Interactive Swagger / OpenAPI UI
- **Layered Architecture** — Clean separation: Controller → Service → Repository
- **DTO Pattern** — Entities are never exposed directly to API clients

---

## 🛠️ Technology Stack

| Technology | Purpose |
| --- | --- |
| Java 17 | Core application language |
| Spring Boot 3 | Application framework |
| Spring Web | REST API layer |
| Spring Data JPA | Database access (Hibernate) |
| Spring Security | Authentication & authorization |
| JWT | Stateless token-based auth |
| PostgreSQL | Data persistence |
| Maven | Dependency management & build |
| Springdoc OpenAPI | Swagger documentation |
| Docker | Local PostgreSQL container |

---

## 🏗️ Architecture

```
            ┌────────────────────────────┐
            │        HTTP Client         │
            │   (Postman / Frontend)     │
            └─────────────┬──────────────┘
                          │  JSON + Bearer Token
                          ▼
            ┌────────────────────────────┐
            │  Spring Security + JWT     │
            │      (Auth Filter)         │
            └─────────────┬──────────────┘
                          ▼
            ┌────────────────────────────┐
            │        Controllers         │
            │   (REST endpoints, DTOs)   │
            └─────────────┬──────────────┘
                          ▼
            ┌────────────────────────────┐
            │         Services           │
            │      (business logic)      │
            └─────────────┬──────────────┘
                          ▼
            ┌────────────────────────────┐
            │        Repositories        │
            │     (Spring Data JPA)      │
            └─────────────┬──────────────┘
                          ▼
            ┌────────────────────────────┐
            │         PostgreSQL         │
            └────────────────────────────┘
```

---

## 📁 Project Structure

```
HospitalPlus-API/
│
├── src/main/java/com/hospital/api/
│   ├── HospitalPlusApiApplication.java
│   ├── controller/
│   │   ├── AuthController.java
│   │   └── PatientController.java
│   ├── service/
│   │   ├── AuthService.java
│   │   └── PatientService.java
│   ├── repository/
│   │   ├── PatientRepository.java
│   │   └── UserRepository.java
│   ├── model/
│   │   ├── Patient.java
│   │   └── User.java
│   ├── dto/
│   │   ├── PatientRequestDTO.java
│   │   ├── PatientResponseDTO.java
│   │   ├── AuthRequestDTO.java
│   │   └── AuthResponseDTO.java
│   ├── security/
│   │   ├── JwtService.java
│   │   └── JwtAuthFilter.java
│   ├── config/
│   │   ├── SecurityConfig.java
│   │   └── OpenApiConfig.java
│   └── exception/
│       └── GlobalExceptionHandler.java
│
├── src/main/resources/
│   └── application.yml
│
├── pom.xml
└── README.md
```

---

## 🔌 API Endpoints

### Authentication

| Method | Endpoint | Description | Auth |
| --- | --- | --- | --- |
| POST | `/api/auth/register` | Register a new user | ❌ Public |
| POST | `/api/auth/login` | Authenticate and receive a JWT | ❌ Public |

### Patients

| Method | Endpoint | Description | Auth |
| --- | --- | --- | --- |
| GET | `/api/patients` | List all patients | 🔒 Bearer token |
| GET | `/api/patients/{id}` | Get a patient by ID | 🔒 Bearer token |
| POST | `/api/patients` | Create a new patient | 🔒 Bearer token |
| PUT | `/api/patients/{id}` | Update an existing patient | 🔒 Bearer token |
| DELETE | `/api/patients/{id}` | Delete a patient | 🔒 Bearer token |
| GET | `/api/patients/search?amka={amka}` | Search by AMKA | 🔒 Bearer token |

### Example Usage

```bash
# 1. Login and receive a JWT
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username": "admin", "password": "admin123"}'

# 2. Call a protected endpoint with the token
curl http://localhost:8080/api/patients \
  -H "Authorization: Bearer <YOUR_JWT_TOKEN>"
```

---

## 🧱 Data Model

### `patients`

| Column | Type | Description |
| --- | --- | --- |
| `id` | BIGSERIAL (PK) | Unique patient identifier |
| `first_name` | VARCHAR | Patient first name |
| `last_name` | VARCHAR | Patient last name |
| `amka` | VARCHAR (UNIQUE) | Greek national insurance number |
| `birth_date` | DATE | Date of birth |
| `department` | VARCHAR | Hospital department |

### `users`

| Column | Type | Description |
| --- | --- | --- |
| `id` | BIGSERIAL (PK) | Unique user identifier |
| `username` | VARCHAR (UNIQUE) | Login username |
| `password` | VARCHAR | BCrypt-hashed password |
| `role` | VARCHAR | Authorization role |

---

## ⚙️ Prerequisites

- Java JDK 17+
- Maven 3.8+
- Docker (for the PostgreSQL container) — or a local PostgreSQL server
- IntelliJ IDEA (recommended)

---

## 🚀 Installation & Run

### 1. Clone the repository

```bash
git clone https://github.com/nmisailidis/HospitalPlus-API.git
cd HospitalPlus-API
```

### 2. Start PostgreSQL with Docker

```bash
docker run --name hospital-db \
  -e POSTGRES_DB=hospital \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  -d postgres:16
```

### 3. Configuration

Database credentials live in `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/hospital
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### 4. Run the application

```bash
mvn spring-boot:run
```

The API becomes available at `http://localhost:8080`.

### 5. Explore the API

Swagger UI: `http://localhost:8080/swagger-ui.html`

---

## 🔐 Security Model

- Passwords are hashed with **BCrypt** — never stored in plain text.
- Authentication is **stateless**: the server issues a signed JWT on login.
- Every request to `/api/patients/**` must include a valid `Authorization: Bearer <token>` header.
- `/api/auth/**` endpoints remain public.

---

## 🗺️ Roadmap

- [ ] Project setup (Spring Initializr, layered structure)
- [ ] Patient entity + repository
- [ ] PostgreSQL integration
- [ ] DTOs + validation
- [ ] Patient CRUD + search endpoints
- [ ] Swagger documentation
- [ ] JWT authentication (register / login / protected routes)
- [ ] Unit & integration tests (JUnit 5 + Mockito)
- [ ] Docker Compose for one-command setup

*Checkboxes are ticked as development progresses — commit history reflects each milestone.*

---

## 🧭 Design Principles

- Object-Oriented Programming
- Separation of Concerns (layered architecture)
- Encapsulation via the DTO pattern
- Fail-fast input validation
- Stateless, scalable security

---

## 👨‍💻 Author

**Nikos Misailidis**
BSc in Applied Informatics — University of Macedonia
GitHub: [https://github.com/nmisailidis](https://github.com/nmisailidis)

*This project is the API-first successor of [HospitalPlus](https://github.com/nmisailidis/HospitalPlus).*

---

## 🙏 Acknowledgements

- Spring Boot & the Spring ecosystem
- PostgreSQL
- Docker
- Springdoc OpenAPI
