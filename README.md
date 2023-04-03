# Concierge

### Application for collecting heating measures by dwelling

###
- Spring Boot
- Spring Data
- Spring Security
- Caffeine cache
- Postgres
- Minio

For this application need to set ENV variables:
```dotenv
IP_ADDRESS=host.docker.internal

APP_NAME=concierge
APP_PORT=[your application port here]
APP_URL=http://localhost:${APP_PORT}

POSTGRES_PORT=[your postgres port here]
POSTGRES_DB=concierge
POSTGRES_SCHEMA=concierge
POSTGRES_URL=jdbc:postgresql://${IP_ADDRESS}:${POSTGRES_PORT}/${POSTGRES_DB}
POSTGRES_USER=[your postgres user here]
POSTGRES_PASSWORD=[your postgres password here]

LIQUIBASE_CONTEXT=test
```

### Swagger documentation
- http://localhost:8080/swagger-ui/swagger-ui/index.html