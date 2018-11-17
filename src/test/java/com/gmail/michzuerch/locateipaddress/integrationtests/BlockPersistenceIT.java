package com.gmail.michzuerch.locateipaddress.integrationtests;

import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Block;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.repository.BlockRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@DisplayName("Test Block Persistence")
public class BlockPersistenceIT {

    @Autowired
    private BlockRepository repository;

    @BeforeEach
    public void initAll() {
        Block block = Block.builder()
                .accuracyRadius("AR")
                .endip(new BigDecimal(2342))
                .geonameId("Testdata")
                .isAnonymousProxy("Y")
                .isSatelliteProvider("N")
                .latitude("3452345")
                .longitude("45345")
                .network("network")
                .postalCode("74345")
                .registeredCountryGeonameId("regcountgeoid")
                .representedCountryGeonameId("reprcountgeoid")
                .startip(new BigDecimal(25234))
                .build();

        repository.save(block);
    }

    @AfterEach
    public void tearDownAll() {
        Collection<Block> collection = repository.findByGeonameId("Testdata");
        collection.forEach(block -> repository.delete(block));
    }


    @Test
    @DisplayName("findByGeonameId_thenReturnBlock")
    void findByGeonameId_thenReturnBlock() {
        // given
        Block block = repository.findByGeonameId("Testdata").stream().findFirst().get();

        // when
        Block found = repository.findByGeonameId(block.getGeonameId()).stream().findFirst().get();

        // then
        assertEquals(found.getGeonameId(), block.getGeonameId());
    }


}
