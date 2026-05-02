# ---------- Stage 1: Build ----------
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /build

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests


# ---------- Stage 2: Run ----------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=builder /build/target/*.jar app.jar

# Install curl for health check
RUN apk add --no-cache curl

# Environment variables
ENV SPRING_PROFILES_ACTIVE=prod
ENV DB_URL=jdbc:mysql://localhost:3306/ecommerce
ENV DB_USER=root
ENV DB_PASS=password

EXPOSE 8080

# Health check (important)
HEALTHCHECK --interval=30s --timeout=5s --start-period=40s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

# Run app
ENTRYPOINT ["sh", "-c", "java -jar app.jar \
--spring.profiles.active=$SPRING_PROFILES_ACTIVE \
--spring.datasource.url=$DB_URL \
--spring.datasource.username=$DB_USER \
--spring.datasource.password=$DB_PASS"]