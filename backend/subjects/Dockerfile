FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
MAINTAINER baeldung.com
WORKDIR /app
COPY --from=builder /app/target/*.jar subjects.jar

EXPOSE 9090
ENTRYPOINT ["java","-jar","/subjects.jar"]