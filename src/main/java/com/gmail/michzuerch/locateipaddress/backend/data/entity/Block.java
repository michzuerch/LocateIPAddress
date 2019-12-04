package com.gmail.michzuerch.locateipaddress.backend.data.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "Block") // "Order" is a reserved word
public class Block extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "{locateipaddress.network.required")
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

    private BigDecimal startip;

    private BigDecimal endip;

    @ManyToOne
    private Location location;

    public Block() {
    }

    public String getNetwork() {
        return this.network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getGeonameId() {
        return this.geonameId;
    }

    public void setGeonameId(String geonameId) {
        this.geonameId = geonameId;
    }

    public String getRegisteredCountryGeonameId() {
        return this.registeredCountryGeonameId;
    }

    public void setRegisteredCountryGeonameId(String registeredCountryGeonameId) {
        this.registeredCountryGeonameId = registeredCountryGeonameId;
    }

    public String getRepresentedCountryGeonameId() {
        return this.representedCountryGeonameId;
    }

    public void setRepresentedCountryGeonameId(String representedCountryGeonameId) {
        this.representedCountryGeonameId = representedCountryGeonameId;
    }

    public String getIsAnonymousProxy() {
        return this.isAnonymousProxy;
    }

    public void setIsAnonymousProxy(String isAnonymousProxy) {
        this.isAnonymousProxy = isAnonymousProxy;
    }

    public String getIsSatelliteProvider() {
        return this.isSatelliteProvider;
    }

    public void setIsSatelliteProvider(String isSatelliteProvider) {
        this.isSatelliteProvider = isSatelliteProvider;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAccuracyRadius() {
        return this.accuracyRadius;
    }

    public void setAccuracyRadius(String accuracyRadius) {
        this.accuracyRadius = accuracyRadius;
    }

    public BigDecimal getStartip() {
        return this.startip;
    }

    public void setStartip(BigDecimal startip) {
        this.startip = startip;
    }

    public BigDecimal getEndip() {
        return this.endip;
    }

    public void setEndip(BigDecimal endip) {
        this.endip = endip;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Block network(String network) {
        this.network = network;
        return this;
    }

    public Block geonameId(String geonameId) {
        this.geonameId = geonameId;
        return this;
    }

    public Block registeredCountryGeonameId(String registeredCountryGeonameId) {
        this.registeredCountryGeonameId = registeredCountryGeonameId;
        return this;
    }

    public Block representedCountryGeonameId(String representedCountryGeonameId) {
        this.representedCountryGeonameId = representedCountryGeonameId;
        return this;
    }

    public Block isAnonymousProxy(String isAnonymousProxy) {
        this.isAnonymousProxy = isAnonymousProxy;
        return this;
    }

    public Block isSatelliteProvider(String isSatelliteProvider) {
        this.isSatelliteProvider = isSatelliteProvider;
        return this;
    }

    public Block postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Block latitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public Block longitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public Block accuracyRadius(String accuracyRadius) {
        this.accuracyRadius = accuracyRadius;
        return this;
    }

    public Block startip(BigDecimal startip) {
        this.startip = startip;
        return this;
    }

    public Block endip(BigDecimal endip) {
        this.endip = endip;
        return this;
    }

    public Block location(Location location) {
        this.location = location;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Block)) {
            return false;
        }
        Block block = (Block) o;
        return Objects.equals(network, block.network) && Objects.equals(geonameId, block.geonameId) && Objects.equals(registeredCountryGeonameId, block.registeredCountryGeonameId) && Objects.equals(representedCountryGeonameId, block.representedCountryGeonameId) && Objects.equals(isAnonymousProxy, block.isAnonymousProxy) && Objects.equals(isSatelliteProvider, block.isSatelliteProvider) && Objects.equals(postalCode, block.postalCode) && Objects.equals(latitude, block.latitude) && Objects.equals(longitude, block.longitude) && Objects.equals(accuracyRadius, block.accuracyRadius) && Objects.equals(startip, block.startip) && Objects.equals(endip, block.endip) && Objects.equals(location, block.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(network, geonameId, registeredCountryGeonameId, representedCountryGeonameId, isAnonymousProxy, isSatelliteProvider, postalCode, latitude, longitude, accuracyRadius, startip, endip, location);
    }
}