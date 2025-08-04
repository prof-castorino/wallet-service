# Dockerfile

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/wallet-1.0.0.jar wallet.jar
ENTRYPOINT ["java", "-jar", "wallet.jar"]
