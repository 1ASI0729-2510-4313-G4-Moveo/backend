FROM openjdk:24-jdk AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8080

