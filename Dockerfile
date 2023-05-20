FROM docker.io/openjdk:19-slim

VOLUME /tmp

# ARG JAR_FILE

# COPY ${JAR_FILE} app.jar

RUN wget https://github.com/willschipp/performance-java-app/releases/download/pre-release/performance-java-app-0.0.1-SNAPSHOT.jar -O app.jar

ENTRYPOINT ["java","-jar","/app.jar"]