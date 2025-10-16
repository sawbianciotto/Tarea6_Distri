# Instrucciones para ejecutar con PostgreSQL local

Estas instrucciones suponen que usarás una instalación local de PostgreSQL en lugar de Docker.

Configuración por defecto en `application.properties`:
- URL: jdbc:postgresql://localhost:5432/db_globalex
- Usuario: postgres
- Contraseña: postgres

Nota: según tu comentario, la base `db_globalex` ya existe. No es necesario crearla. Asegúrate solo de que los valores en `application.properties` (URL, usuario y contraseña) coinciden con tu instalación local.

Para comprobar que la aplicación puede conectarse a la base existente puedes ejecutar:

```bash
# Verificar que puedes conectarte con psql (opcional)
psql -U postgres -d db_globalex -c "\l"
```

Arrancar el servidor Spring Boot (desde el directorio `servidor-springboot`):

```bash
# Hacer ejecutable el wrapper si es necesario
chmod +x mvnw
# Ejecutar
./mvnw -DskipTests spring-boot:run
```

Verifica el endpoint de saludo:

```bash
curl http://localhost:8100/api/personas/saludo
```

Cliente Python
---------------
En `cliente-python` ya hay un `setup_env.sh` que crea un virtualenv e instala dependencias.

```bash
cd /path/to/cliente-python
./setup_env.sh
source venv/bin/activate
python clientePersonas.py
```

Notas
-----
- `spring.jpa.hibernate.ddl-auto=update` está activado en `application.properties` para facilitar desarrollo local; en producción cambia a `none` o maneja las migraciones con Flyway/Liquibase.
- Si cambias el puerto o contexto, actualiza `cliente-python/ConfigFile.properties`.
