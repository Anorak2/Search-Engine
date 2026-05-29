# Build stage
FROM gradle:7-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle :src:api:build --no-daemon

# Runtime stage
FROM eclipse-temurin:17-jre AS development
WORKDIR /app
COPY --from=build /app/src/api/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
