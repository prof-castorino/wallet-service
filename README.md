# 💰 Wallet Service

A simple microservice for managing user wallets, supporting deposit, withdraw, transfer, and historical balance tracking.

## 🚀 Features

- ✅ Create User
- ✅ Create Wallet
- ✅ Retrieve Current Balance
- ✅ Retrieve Historical Balance
- ✅ Deposit Funds
- ✅ Withdraw Funds
- ✅ Transfer Funds Between Wallets
- ✅ Full transaction traceability for auditing
- ✅ Swagger API Documentation

---

## 🧰 Tech Stack

- Java 21
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Maven
- Docker & Docker Compose
- Swagger/OpenAPI (springdoc)

---

## 🏗️ Project Structure

wallet/
├── src/
│ ├── main/
│ │ ├── java/com/wallet/
│ │ │ ├── config/
│ │ │ ├── controller/
│ │ │ ├── dto/
│ │ │ ├── exception/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ └── Application.java
│ │ └── resources/
│ │ ├── application.yml
│ │ └── schema.sql
│ └── test/java/com/wallet/
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
