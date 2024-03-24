FROM openjdk:8
EXPOSE 8080
ADD target/spring-integration.jar spring-integration.jar
ENTRYPOINT ["java", "-jar", "spring-integration.jar"]


#docker container run --name spring-integration -p 8080:8080 -d spring-integration.jar
