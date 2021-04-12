FROM java:8

MAINTAINER Gabriel Smith (gabrielwsmith20@gmail.com)

EXPOSE 8080

ADD target/Aumni_Selenium_Test.jar Aumni_Selenium_Test.jar

ENTRYPOINT ["java", "-jar", "Aumni_Selenium_Test.jar"