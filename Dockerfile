##FROM openjdk:8-jdk-alpine
##RUN addgroup -S spring && adduser -S spring -G spring
##USER spring:spring
##ARG JAR_FILE=target/*.jar
##COPY ${JAR_FILE} app.jar
##EXPOSE 8080
##ENTRYPOINT ["java","-jar","/app.jar","-Dspring.output.ansi.enabled=always","-Dcom.sun.management.jmxremote","-Dspring.jmx.enabled=true","-Dspring.liveBeansView.mbeanDomain","-Dspring.application.admin.enabled=true"]

#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/twelve-factor-1.0-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]
