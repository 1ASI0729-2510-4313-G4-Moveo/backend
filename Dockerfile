FROM eclipse-temurin:24-jdk

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

# Expone el puerto por defecto de Spring Boot
EXPOSE 8080