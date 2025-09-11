# Usa JDK 24
FROM eclipse-temurin:24-jdk

# Crea directorio de trabajo
WORKDIR /app

# Copia todo el proyecto
COPY . .

# Da permisos al wrapper y compila sin tests
RUN chmod +x ./mvnw && ./mvnw -B -DskipTests clean install

# Expone el puerto (ajústalo si usas otro)
EXPOSE 8080

# Comando para ejecutar Spring Boot
CMD ["./mvnw", "spring-boot:run"]