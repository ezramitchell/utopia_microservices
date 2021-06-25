FROM adoptopenjdk:16-jre-openj9
COPY /target/AdminService-0.0.1-SNAPSHOT.jar /var/app.jar
CMD ["java", "-jar", "/var/app.jar", "--spring.datasource.url=jdbc:mysql://db:3306/test", "--spring.datasource.hikari.initialization-fail-timeout=0", "--eureka.client.serviceUrl.defaultZone=http://eureka:8761/eureka"]

