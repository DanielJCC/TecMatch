FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean install

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /tag/TecMatch-0.0.1-SNAPSHOT.jar TecMatch.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","TecMatch.jar"]