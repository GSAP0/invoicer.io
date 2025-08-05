FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY services/crm/target/*.jar app.jar
COPY services/crm/src/main/resources/application.yml application.yml
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=file:/app/application.yml"]

