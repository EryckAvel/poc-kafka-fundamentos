FROM maven:3.9-eclipse-temurin-17-alpine AS BUILD

WORKDIR ./app

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

EXPOSE 8080

COPY --from=BUILD /app/target/*.jar app.jar