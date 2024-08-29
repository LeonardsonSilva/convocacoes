FROM java:1.0.0

WORKDIR /app

COPY src ./src

CMD mvn package && chmod -R 777 ./target && mvn spring-boot:run
