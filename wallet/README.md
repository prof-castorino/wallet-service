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

### 📦 Run Project with Docker

1. **Clone the repository:**

```bash
git clone https://github.com/prof-castorino/wallet-service.git
cd wallet-service/wallet
``` 
2. **Build and run the Docker containers:**

```bash
docker-compose up --build
``` 

3. **Run the SQL script to create the database schema:**

```bash
docker exec -i wallet-service_db_1 psql -U postgres -d postgres < src/main/resources/db/schema.sql
``` 
4. **Access the application:**
- Open your browser and go to `http://localhost:8080/swagger-ui.html` to access the Swagger API documentation.
