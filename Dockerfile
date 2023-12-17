<<<<<<< HEAD
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/web-0.0.1-SNAPSHOT.jar web.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "web.jar"]
=======
FROM maven:3.8-openjdk-17 AS build
COPY . .
RUN ./mvnw clean package -Dskiptests

FROM openjdk:17-jdk-slim
COPY --from=build /target/web-0.0.1-SNAPSHOT.jar web.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","web.jar"]
>>>>>>> fd15b107bdd85edaf64e9d3c82e0287fe8d8a76c
