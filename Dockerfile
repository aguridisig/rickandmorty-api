FROM openjdk:17-jdk-alpine
COPY target/rickandmorty-api-0.0.1-SNAPSHOT.jar rickandmorty-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/rickandmorty-api-0.0.1-SNAPSHOT.jar"]