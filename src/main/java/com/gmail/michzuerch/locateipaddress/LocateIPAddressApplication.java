package com.gmail.michzuerch.locateipaddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocateIPAddressApplication {

    /**
     * The main method makes it possible to run the application as a plain Java
     * application which starts embedded web server via Spring Boot.
     * <p>
     * Ein Commit nach init
     *
     * @param args command line parameters
     */
    public static void main(String[] args) {
        SpringApplication.run(LocateIPAddressApplication.class, args);
    }
}
