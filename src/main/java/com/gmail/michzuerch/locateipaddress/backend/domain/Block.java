package com.gmail.michzuerch.locateipaddress.backend.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(String geonameId) {
        this.geonameId = geonameId;
    }

    public String getRegisteredCountryGeonameId() {
        return registeredCountryGeonameId;
    }

    public void setRegisteredCountryGeonameId(String registeredCountryGeonameId) {
        this.registeredCountryGeonameId = registeredCountryGeonameId;
    }

    public String getRepresentedCountryGeonameId() {
        return representedCountryGeonameId;
    }

    public void setRepresentedCountryGeonameId(String representedCountryGeonameId) {
        this.representedCountryGeonameId = representedCountryGeonameId;
    }

    public String getIsAnonymousProxy() {
        return isAnonymousProxy;
    }

    public void setIsAnonymousProxy(String isAnonymousProxy) {
        this.isAnonymousProxy = isAnonymousProxy;
    }

    public String getIsSatelliteProvider() {
        return isSatelliteProvider;
    }

    public void setIsSatelliteProvider(String isSatelliteProvider) {
        this.isSatelliteProvider = isSatelliteProvider;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAccuracyRadius() {
        return accuracyRadius;
    }

    public void setAccuracyRadius(String accuracyRadius) {
        this.accuracyRadius = accuracyRadius;
    }

    public BigDecimal getStartip() {
        return startip;
    }

    public void setStartip(BigDecimal startip) {
        this.startip = startip;
    }

    public BigDecimal getEndip() {
        return endip;
    }

    public void setEndip(BigDecimal endip) {
        this.endip = endip;
    }
}