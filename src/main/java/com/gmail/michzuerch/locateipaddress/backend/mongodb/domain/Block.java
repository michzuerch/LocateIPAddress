package com.gmail.michzuerch.locateipaddress.backend.mongodb.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "block")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Block {
    @Id
    private ObjectId id;
    private String network;
    private String geonameId;
    private String registeredCountryGeonameId;
    private String representedCountryGeonameId;
    private String isAnonymousProxy;
    private String isSatelliteProvider;
    private String postalCode;
    private String latitude;
    private String longitude;
    private String accuracyRadius;
    @Indexed
    private BigDecimal startip;
    @Indexed
    private BigDecimal endip;

}