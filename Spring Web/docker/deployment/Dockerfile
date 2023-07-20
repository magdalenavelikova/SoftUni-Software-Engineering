FROM openjdk:11-jre

VOLUME /tmp
COPY build/libs/docker.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Xms256m -Xmx512m", "-jar","/app.jar"]