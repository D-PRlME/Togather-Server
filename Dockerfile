FROM openjdk:11

EXPOSE 8080

ADD build/libs/Draw-Server-0.0.1-SNAPSHOT.jar Draw-Server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","Draw-Server-0.0.1-SNAPSHOT.jar"]