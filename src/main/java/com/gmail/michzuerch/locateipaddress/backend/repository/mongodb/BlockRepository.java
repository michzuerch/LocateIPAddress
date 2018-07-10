package com.gmail.michzuerch.locateipaddress.backend.repository.mongodb;

import com.gmail.michzuerch.locateipaddress.backend.domain.Block;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "blocks", path = "blocks")
public interface BlockRepository extends MongoRepository<Block, Long> {
    Collection<Block> findByPostalCodeContainingIgnoreCase(String postalCode);

    Block findByGeonameId(String geonameId);
}