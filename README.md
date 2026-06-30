# 🏥 Hospital Management System Backend

An enterprise-level Hospital Management System backend built using **Spring Boot**, **PostgreSQL**, **Spring Security**, **JWT Authentication**, **Docker**.

The project is designed to digitize hospital operations while following modern backend architecture and production-ready development practices.

It provides secure REST APIs for:

- 👨‍⚕️ Doctor Management
- 🧑‍🤝‍🧑 Patient Management
- 📅 Appointment Scheduling
- 🏥 Department Management
- 🩺 Insurance Management
- 🔐 Authentication & Authorization

---

# 🚀 Features

## 🔐 Authentication & Authorization

- JWT-based Authentication
- Spring Security
- Role-Based Access Control (RBAC)
- OAuth2 Login (Google & GitHub)
- BCrypt Password Encryption
- Stateless Authentication

---

## 👨‍⚕️ Doctor Management

- Add Doctor
- Update Doctor
- Delete Doctor
- View Doctor Details
- Department Assignment

---

## 🧑‍🤝‍🧑 Patient Management

- Add Patient
- Update Patient Records
- Blood Group Management
- Insurance Information
- Medical Record Tracking

---

## 📅 Appointment Management

- Book Appointments
- Update Appointments
- View Appointment Details
- Doctor-Patient Scheduling

---

## 🏥 Department Management

- Create Departments
- Assign Head Doctor
- Associate Doctors with Departments

---

## 🛡️ Security

- JWT Authentication
- OAuth2 Authentication
- Protected REST APIs
- Role-Based Authorization
- Password Encryption using BCrypt

---

## 🐳 Containerization

- Dockerized Spring Boot Application
- Docker Compose Configuration
- PostgreSQL Container
- Environment Variable Support
- Easy Local Deployment

---

## ⚙️ Continuous Integration

- GitHub Actions Workflow
- Automatic Maven Build
- Unit Test Execution
- Docker Image Build Verification
- Build Validation on Every Push & Pull Request

---

# 🛠️ Tech Stack

| Layer | Technology |
|--------|------------|
| Backend | Spring Boot 4 |
| Language | Java 21 |
| Database | PostgreSQL |
| ORM | Spring Data JPA / Hibernate |
| Security | Spring Security + JWT |
| OAuth2 | Google & GitHub |
| Validation | Hibernate Validator |
| Documentation | Swagger / OpenAPI |
| Build Tool | Maven |
| Containerization | Docker & Docker Compose |
| CI | GitHub Actions |
| API Testing | Postman |

---

# 🏗️ Project Structure

```text
src/main/java/com/example/hospital
│
├── config
├── controller
├── dto
├── entity
├── exception
├── mapper
├── repository
├── security
├── service
└── HospitalApplication.java
```

---

# 🐳 Running with Docker

## Build the application

```bash
mvn clean package
```

## Build Docker image

```bash
docker build -t hospital:v1 .
```

## Run using Docker Compose

```bash
docker compose up -d
```

Application will be available at:

```
http://localhost:8080/hospital
```

---

# 🔄 Continuous Integration

The project includes a **GitHub Actions** workflow that automatically executes on every push and pull request.

The workflow performs:

- Checkout Repository
- Setup Java 21
- Maven Dependency Cache
- Build the Project
- Run Unit Tests
- Verify Docker Image Build

This ensures the application remains buildable and deployment-ready.

---

# 📖 API Documentation

Once the application is running, Swagger UI is available at:

```
http://localhost:8080/hospital/swagger-ui/index.html
```

---

# 🔐 Authentication

The application supports:

- Email & Password Authentication (JWT)
- Google OAuth2 Login
- GitHub OAuth2 Login

Protected endpoints require a JWT token.

Example:

```
Authorization: Bearer <JWT_TOKEN>
```

---

# 📌 Future Enhancements

- Spring Cloud Gateway
- Eureka Service Discovery
- Spring Cloud Config
- OpenFeign Client
- Resilience4j Circuit Breaker
- Distributed Tracing
- Centralized Logging (ELK)
- Prometheus & Grafana Monitoring
- Kubernetes Deployment

---

# 👨‍💻 Author

**Vishal**

Java Backend Developer | Spring Boot | PostgreSQL | Docker | GitHub Actions