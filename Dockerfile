FROM adoptopenjdk/openjdk11:alpine

WORKDIR /app

COPY SpringBootRedis-0.0.1-SNAPSHOT.jar SpringBootRedis-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "SpringBootRedis-0.0.1-SNAPSHOT.jar"]

FROM redis:latest

EXPOSE 6379