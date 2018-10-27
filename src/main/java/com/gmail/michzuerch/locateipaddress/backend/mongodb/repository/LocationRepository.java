package com.gmail.michzuerch.locateipaddress.backend.mongodb.repository;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "locations", path = "locations")
public interface LocationRepository extends MongoRepository<Location, Long> {

    Collection<Location> findByCityLike(String city);

    Collection<Location> findByCityIgnoreCase(String city);
}