#!/usr/bin/env bash
# render-build.sh

# Instalar dependencias y construir el proyecto
mvn clean install -DskipTests

# Crear el jar ejecutable
mvn package -DskipTests