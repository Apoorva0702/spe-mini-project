FROM openjdk:17

WORKDIR /app

COPY target/*.jar calculator.jar

ENTRYPOINT ["java","-jar","calculator.jar"]