FROM openjdk:17
MAINTAINER mpu
COPY build/libs/certificates-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
