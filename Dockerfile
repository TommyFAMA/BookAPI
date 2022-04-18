FROM openjdk:11.0.14-jre-slim-buster
COPY target/book-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]