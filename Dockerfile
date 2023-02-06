FROM mcr.microsoft.com/java/jre:17-zulu-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} portfolio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/portfolio-0.0.1-SNAPSHOT.jar"]
