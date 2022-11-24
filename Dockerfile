FROM openjdk:11-jre-slim

EXPOSE 8080

ADD build/libs/Draw-Server-0.0.1-SNAPSHOT.jar Draw-Server-0.0.1-SNAPSHOT.jar

LABEL "com.datadoghq.ad.logs"='[<LOGS_CONFIG>]'

ENTRYPOINT ["java","-jar","Draw-Server-0.0.1-SNAPSHOT.jar"]
