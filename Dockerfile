FROM openjdk:10-jdk
LABEL maintainer="michzuerch@gmail.com"
VOLUME /tmp
ADD target/locateipaddress.jar locateipaddress.jar
EXPOSE 8080
RUN sh -c 'touch /locateipaddress.jar'
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongodb/locateipaddress", "-Djava.security.egd=file:/dev/./urandom","-jar","/locateipaddress.jar"]
