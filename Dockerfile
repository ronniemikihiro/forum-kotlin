FROM openjdk:17-alpine
EXPOSE 8080
ADD /target/forum-kotlin-0.0.1-SNAPSHOT.jar forum.jar
ENTRYPOINT ["java", "-jar", "forum.jar"]
