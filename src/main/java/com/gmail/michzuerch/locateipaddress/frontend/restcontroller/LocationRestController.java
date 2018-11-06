package com.gmail.michzuerch.locateipaddress.frontend.restcontroller;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Location;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.LocationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class LocationRestController {
    private LocationRepository repository;

    public LocationRestController(LocationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/locations")
    public Collection<Location> locations() {
        return repository.findAll().stream()
                //.filter(this::isCool)
                .collect(Collectors.toList());
    }

}

//class CoolCarController {
//    private CarRepository repository;
//
//    public CoolCarController(CarRepository repository) {
//        this.repository = repository;
//    }
//
//    @GetMapping("/cool-cars")
//    public Collection<Car> coolCars() {
//        return repository.findAll().stream()
//                .filter(this::isCool)
//                .collect(Collectors.toList());
//    }
//
//    private boolean isCool(Car car) {
//        return !car.getName().equals("AMC Gremlin") &&
//                !car.getName().equals("Triumph Stag") &&
//                !car.getName().equals("Ford Pinto") &&
//                !car.getName().equals("Yugo GV");
//    }
//}