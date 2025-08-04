# 📦 Run Project with Docker

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
