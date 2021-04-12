#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
MAINTAINER Gabriel Smith (gabrielwsmith20@gmail.com)
COPY src /Aumni_Selenium_Test/
COPY pom.xml /Aumni_Selenium_Test/
RUN mvn -f /Aumni_Selenium_Test/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /Aumni_Selenium_Test/target/Aumni_Selenium_Test.jar /Aumni_Selenium_Test/target/Aumni_Selenium_Test.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Aumni_Selenium_Test/target/Aumni_Selenium_Test.jar"]