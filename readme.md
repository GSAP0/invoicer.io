# Invoicer


Invoicer is a modular, microservice-based platform designed for invoicing, billing, customer management (CRM), and time tracking. It follows a clean architecture with independent services that communicate via REST and Kafka, and a shared `commons` module for interoperability.

---

## 📐 Architecture Overview

- **Frontend**: Vue 3 app (outside this repo)
- **Backend**: Java 24 microservices using Spring Boot
- **Service Communication**:
    - REST (internal APIs)
    - Kafka (domain events)
- **Authentication**: Keycloak
- **Deployment**: Docker Compose (dev), Docker Swarm (prod)

### 🧱 Core Services

| Service         | Description                              |
|----------------|------------------------------------------|
| `auth`         | Handles authentication via Keycloak      |
| `crm`          | Manages customers and emits events       |
| `billing`      | Handles invoices, payments, subscriptions|
| `gateway`      | Routes external requests to services     |
| `commons`      | Shared events, DTOs, and base contracts  |

---

## 🧰 Tech Stack

- Java 24, Spring Boot 3.2.x
- Vue 3 (frontend)
- MySQL (relational storage)
- Redis (cache)
- Kafka (event messaging)
- Keycloak (identity & access)
- Docker / Docker Swarm

---

## 🚀 Development Setup

### 1. Prerequisites

- Java 24
- Docker + Docker Compose
- Maven
- Node.js (for frontend)

### 2. Run Infrastructure

```bash
docker-compose -f docker-compose.dev.yml up
```

Services included:

MySQL (localhost:3306)

Redis (localhost:6379)

Kafka + Zookeeper

Keycloak (http://localhost:8080)

3. Build & Run Services
From root:

```bash
mvn clean install
```

Then, for each service (e.g., CRM):
```bash
cd services/crm
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```
