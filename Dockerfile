FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/docker-to-do-list-1.0.0.jar to-do-list-1.0.0.jar
ENTRYPOINT ["java","-jar","/message-server-1.0.0.jar"]