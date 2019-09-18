FROM openjdk:12-jdk
LABEL maintainer="michzuerch@gmail.com"
VOLUME /tmp
ADD target/LocateIPAddress.jar LocateIPAddress.jar
EXPOSE 8080
RUN sh -c 'touch /LocateIPAddress.jar'
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongodb/locateipaddress", "-Djava.security.egd=file:/dev/./urandom","-jar","/LocateIPAddress.jar"]
