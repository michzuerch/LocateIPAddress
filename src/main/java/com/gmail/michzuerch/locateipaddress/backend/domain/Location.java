package com.gmail.michzuerch.locateipaddress.backend.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(String geonameId) {
        this.geonameId = geonameId;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getSubdivision1isoCode() {
        return subdivision1isoCode;
    }

    public void setSubdivision1isoCode(String subdivision1isoCode) {
        this.subdivision1isoCode = subdivision1isoCode;
    }

    public String getSubdivision1name() {
        return subdivision1name;
    }

    public void setSubdivision1name(String subdivision1name) {
        this.subdivision1name = subdivision1name;
    }

    public String getSubdivision2isoCode() {
        return subdivision2isoCode;
    }

    public void setSubdivision2isoCode(String subdivision2isoCode) {
        this.subdivision2isoCode = subdivision2isoCode;
    }

    public String getSubdivision2name() {
        return subdivision2name;
    }

    public void setSubdivision2name(String subdivision2name) {
        this.subdivision2name = subdivision2name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getMetroCode() {
        return metroCode;
    }

    public void setMetroCode(String metroCode) {
        this.metroCode = metroCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getIsInEuropeanUnion() {
        return isInEuropeanUnion;
    }

    public void setIsInEuropeanUnion(String isInEuropeanUnion) {
        this.isInEuropeanUnion = isInEuropeanUnion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}

