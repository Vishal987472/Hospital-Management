# 🏥 Hospital Management System Backend

An enterprise-level Hospital Management System backend built using **Spring Boot**, **PostgreSQL**, **Spring Security**, and **JWT Authentication**.

This project is designed to manage hospital operations digitally including:
- patient management,
- doctor management,
- appointment scheduling,
- authentication & authorization,
- insurance handling,
- and secure REST APIs.

The backend follows modern enterprise backend architecture and production-ready practices.

---

# 🚀 Features

## 🔐 Authentication & Authorization
- JWT-based authentication
- Spring Security integration
- Role-Based Access Control (RBAC)
- OAuth2 Login (Google & GitHub)
- BCrypt password encryption
- Stateless authentication

---

## 👨‍⚕️ Doctor Management
- Add doctor
- Update doctor
- Delete doctor
- View doctor details
- Department management

---

## 🧑‍🤝‍🧑 Patient Management
- Add patients
- Update patient records
- Manage blood groups
- Insurance details
- Medical information tracking

---

## 📅 Appointment Management
- Book appointments
- View appointments
- Manage doctor-patient appointments
- Appointment scheduling APIs

---

## 🛡️ Security Features
- JWT token authentication
- OAuth2 authentication
- Protected APIs
- Role-based authorization
- Password hashing using BCrypt

---

# 🛠️ Tech Stack

| Layer | Technology |
|-------|-------------|
| Backend | Spring Boot |
| Language | Java |
| Database | PostgreSQL |
| ORM | Spring Data JPA / Hibernate |
| Security | Spring Security + JWT |
| OAuth2 | Google & GitHub Login |
| Validation | Hibernate Validator |
| Build Tool | Maven |
| API Testing | Postman |
| Documentation | Swagger/OpenAPI |

---

# 🏗️ Backend Architecture

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
