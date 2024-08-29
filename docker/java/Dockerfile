FROM maven:3.8.5-openjdk-17-slim AS dependencies

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B
