FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar DonutStoreSpring.jar
ENTRYPOINT ["java","-jar","/DonutStoreSpring.jar"]
EXPOSE 8080