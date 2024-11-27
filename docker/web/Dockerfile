FROM maven:3.8.5-openjdk-17-slim AS build

WORKDIR /app

COPY . .

CMD mvn package && chmod -R 777 ./target && mvn spring-boot:run
