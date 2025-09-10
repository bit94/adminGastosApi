FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar el jar
COPY target/*.jar app.jar

# Exponer puerto
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
