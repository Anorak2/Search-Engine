# Build stage
FROM gradle:jdk21-ubi10 AS build
WORKDIR /app
COPY api/ .
RUN gradle build --no-daemon

# Runtime stage
FROM eclipse-temurin:21-jre AS development
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
