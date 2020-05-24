FROM openjdk:8-jre-alpine
WORKDIR /var/lib/jenkins/workspace/mysharedlib
COPY target/spring-boot-rest-example-0.5.0.war app.war
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=test", "app.war"]
