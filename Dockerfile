FROM openjdk:17
ADD target/spring-petclinic-3.3.0-SNAPSHOT.jar  spring-petclinic.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-petclinic.jar"]
