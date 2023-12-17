FROM maven:3.8-openjdk-17 AS build
COPY . .
RUN ./mvnw clean package -Dskiptests

FROM openjdk:17-jdk-slim
COPY --from=build /target/web-0.0.1-SNAPSHOT.jar web.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","web.jar"]
