## Stage 1: Build
FROM gradle:8.5-jdk17 AS build
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
COPY gradlew ./
COPY src ./src
RUN gradle build -x test

## Stage 2: Runtime
FROM registry.access.redhat.com/ubi8/openjdk-17:1.14
ENV LANGUAGE='en_US:en'
COPY --from=build /app/build/quarkus-app/lib/ /deployments/lib/
COPY --from=build /app/build/quarkus-app/*.jar /deployments/
COPY --from=build /app/build/quarkus-app/app/ /deployments/app/
COPY --from=build /app/build/quarkus-app/quarkus/ /deployments/quarkus/
EXPOSE 8080
CMD ["java", "-jar", "/deployments/quarkus-run.jar"]
