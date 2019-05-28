FROM maven:3.5.3-jdk-8

WORKDIR /code
COPY *.xml /code/
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

COPY src /code/src
RUN ["mvn", "package"]

EXPOSE 80
CMD ["java", "-jar", "target/Bankas-1.0-SNAPSHOT-jar-with-dependencies.jar"]
