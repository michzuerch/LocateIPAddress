package com.gmail.michzuerch.locateipaddress.backend.mongodb.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "location")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    private ObjectId id;
    @Indexed
    private String geonameId;
    private String localeCode;
    private String continentCode;
    private String continentName;
    private String countryIsoCode;
    private String countryName;
    private String subdivision1isoCode;
    private String subdivision1name;
    private String subdivision2isoCode;
    private String subdivision2name;
    private String cityName;
    private String metroCode;
    private String timeZone;
    private String isInEuropeanUnion;
    private String country;
    private String city;
    private String postalcode;
    private BigDecimal latitude;
    private BigDecimal longitude;

    @DBRef
    private List<Block> blocks;

    public void addBlock(Block block) {
        if (blocks == null) {
            blocks = new ArrayList<>();
        }
        this.blocks.add(block);
    }

}

