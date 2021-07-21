FROM openjdk:11
ARG JAR_FILE=target/SQLite.demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} application.jar
COPY sample.db sample.db
EXPOSE 8090
ENTRYPOINT ["java","-jar","/application.jar"]
