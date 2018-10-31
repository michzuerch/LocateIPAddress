package com.gmail.michzuerch.locateipaddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocateIPAddressApplication implements CommandLineRunner {
    @Value("${info.app.name}")
    private String appname;

    public static void main(final String[] args) {
        SpringApplication.run(LocateIPAddressApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("appname              :" + appname);
    }
}
