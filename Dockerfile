FROM openjdk:21-jdk
LABEL authors="samm1"

COPY target/controle-0.0.1-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]