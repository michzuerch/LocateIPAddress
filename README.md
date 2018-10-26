LocateIPAddress
======================

Imports a CVS-File from Geolocate to a MongoDB-Database and provides a Webinterface.

Source can be found [here](https://gitlab.com/michzuerch/LocateIPAddress).

Following frameworks are used:
* Springboot 2.0 `@SpringBootApplication`.
* Vaadin Flow 10 (Beta)
* MongoDB

## Running the project from command line

Run `mvn clean install spring-boot:run` in the project root directory. After the server has started point your browser to [http://localhost:8080](http://localhost:8080) to see the resulting application.

## Running the project from your IDE

Navigate to the `com.gmail.michzuerch.locateipaddress.LocateIPAddressApplication` class and run it as a Java application.


## Running on Docker-Compose

First create a volume `docker volume create --name locateipaddress-mongo-data`