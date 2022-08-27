FROM openjdk:17
ADD target/commands-execute-docker.jar commands-execute-docker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","commands-execute-docker.jar"]