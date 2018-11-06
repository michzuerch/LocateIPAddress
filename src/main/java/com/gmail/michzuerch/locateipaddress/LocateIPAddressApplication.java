package com.gmail.michzuerch.locateipaddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableResourceServer
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

//    @Bean
//    ApplicationRunner init(CarRepository repository) {
//        return args -> {
//            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
//                    "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
//                Car car = new Car();
//                car.setName(name);
//                repository.save(car);
//            });
//            repository.findAll().forEach(System.out::println);
//        };
//    }

}
