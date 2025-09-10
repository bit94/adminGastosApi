# En la raíz de tu proyecto
echo 'FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 10000
CMD ["java", "-jar", "app.jar"]' > Dockerfile