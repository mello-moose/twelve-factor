FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar","-Dspring.output.ansi.enabled=always","-Dcom.sun.management.jmxremote","-Dspring.jmx.enabled=true","-Dspring.liveBeansView.mbeanDomain","-Dspring.application.admin.enabled=true"]
