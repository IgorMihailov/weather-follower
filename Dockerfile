# creates a layer from the openjdk:17-alpine Docker image.
FROM openjdk:17-alpine

MAINTAINER dr.migo@yandex.ru

# cd /app
WORKDIR /app

# Refer to Maven build -> finalName
ARG JAR_FILE=target/spring-boot-docker-*.jar

# cp target/spring-boot-docker-0.0.1-SNAPSHOT.jar /app/spring-boot-docker.jar
COPY ${JAR_FILE} spring-boot-docker.jar

# java -jar /app/spring-boot-docker.jar
CMD ["java", "-jar", "-Xmx1024M", "/app/spring-boot-docker.jar"]

# Make port 8090 available to the world outside this container
EXPOSE 8090