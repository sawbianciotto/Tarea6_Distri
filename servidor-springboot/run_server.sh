#!/usr/bin/env bash
set -euo pipefail

# Ejecuta el servidor Spring Boot usando el wrapper maven
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

# Ejecutar (skipea tests para rapidez)
./mvnw -DskipTests spring-boot:run
