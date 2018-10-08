FROM openjdk:10-jre-slim
COPY ./target/LocateIPAddress-1.0.0-SNAPSHOT.jar /usr/src/michzuerch/
WORKDIR /usr/src/michzuerch
EXPOSE 8080
CMD ["java", "-jar", "LocateIPAddress-1.0.0-SNAPSHOT.jar"]
