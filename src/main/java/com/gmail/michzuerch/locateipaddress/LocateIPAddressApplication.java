package com.gmail.michzuerch.locateipaddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocateIPAddressApplication {
    public static void main(final String[] args) {
        SpringApplication.run(LocateIPAddressApplication.class, args);
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
