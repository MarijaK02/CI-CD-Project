FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /subjects
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
MAINTAINER baeldung.com
WORKDIR /subjects
COPY --from=builder /subjects/target/*.jar subjects.jar
ENTRYPOINT ["java","-jar","/subjects.jar"]