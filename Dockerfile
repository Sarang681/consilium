FROM eclipse-temurin:21.0.8_9-jre-ubi9-minimal

WORKDIR /app

COPY target/consilium-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
