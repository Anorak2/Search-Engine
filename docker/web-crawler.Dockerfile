# Build stage
FROM gradle:jdk21-ubi10 AS build
WORKDIR /app
COPY . .
RUN gradle web-crawler:build --no-daemon

# Runtime stage
FROM eclipse-temurin:21-jre AS development
WORKDIR /app
COPY --from=build /app/web-crawler/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
