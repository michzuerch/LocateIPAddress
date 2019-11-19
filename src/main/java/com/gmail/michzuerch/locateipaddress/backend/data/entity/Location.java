package com.gmail.michzuerch.locateipaddress.backend.data.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "Location") // "Order" is a reserved word
public class Location extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Column
    @NotNull(message = "{locateipaddress.geonameId.required")
    @Size(min = 3)
    private String geonameId;

    @Column
    @Size(min = 3)
    private String localeCode;

    @Column
    @Size(min = 3)
    private String continentCode;

    @Column
    @Size(min = 3)
    private String continentName;

    @Column
    @Size(min = 3)
    private String countryIsoCode;

    @Column
    @Size(min = 3)
    private String countryName;

    @Column
    @Size(min = 3)
    private String subdivision1isoCode;

    @Column
    @Size(min = 3)
    private String subdivision1name;

    @Column
    @Size(min = 3)
    private String subdivision2isoCode;

    @Column
    @Size(min = 3)
    private String subdivision2name;

    @Column
    @Size(min = 3)
    private String cityName;

    @Column
    @Size(min = 3)
    private String metroCode;

    @Column
    @Size(min = 3)
    private String timeZone;

    @Column
    @Size(min = 3)
    private String isInEuropeanUnion;

    @Column
    @Size(min = 3)
    private String country;

    @Column
    @Size(min = 3)
    private String city;

    @Column
    @Size(min = 3)
    private String postalcode;

    @Column
    private BigDecimal latitude;

    @Column
    private BigDecimal longitude;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Block> blocks;

    public Location() {
    }

    public Location(String geonameId, String localeCode, String continentCode, String continentName,
            String countryIsoCode, String countryName, String subdivision1isoCode, String subdivision1name,
            String subdivision2isoCode, String subdivision2name, String cityName, String metroCode, String timeZone,
            String isInEuropeanUnion, String country, String city, String postalcode, BigDecimal latitude,
            BigDecimal longitude, List<Block> blocks) {
        this.geonameId = geonameId;
        this.localeCode = localeCode;
        this.continentCode = continentCode;
        this.continentName = continentName;
        this.countryIsoCode = countryIsoCode;
        this.countryName = countryName;
        this.subdivision1isoCode = subdivision1isoCode;
        this.subdivision1name = subdivision1name;
        this.subdivision2isoCode = subdivision2isoCode;
        this.subdivision2name = subdivision2name;
        this.cityName = cityName;
        this.metroCode = metroCode;
        this.timeZone = timeZone;
        this.isInEuropeanUnion = isInEuropeanUnion;
        this.country = country;
        this.city = city;
        this.postalcode = postalcode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.blocks = blocks;
    }

    public String getGeonameId() {
        return this.geonameId;
    }

    public void setGeonameId(String geonameId) {
        this.geonameId = geonameId;
    }

    public String getLocaleCode() {
        return this.localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public String getContinentCode() {
        return this.continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getContinentName() {
        return this.continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getCountryIsoCode() {
        return this.countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getSubdivision1isoCode() {
        return this.subdivision1isoCode;
    }

    public void setSubdivision1isoCode(String subdivision1isoCode) {
        this.subdivision1isoCode = subdivision1isoCode;
    }

    public String getSubdivision1name() {
        return this.subdivision1name;
    }

    public void setSubdivision1name(String subdivision1name) {
        this.subdivision1name = subdivision1name;
    }

    public String getSubdivision2isoCode() {
        return this.subdivision2isoCode;
    }

    public void setSubdivision2isoCode(String subdivision2isoCode) {
        this.subdivision2isoCode = subdivision2isoCode;
    }

    public String getSubdivision2name() {
        return this.subdivision2name;
    }

    public void setSubdivision2name(String subdivision2name) {
        this.subdivision2name = subdivision2name;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getMetroCode() {
        return this.metroCode;
    }

    public void setMetroCode(String metroCode) {
        this.metroCode = metroCode;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getIsInEuropeanUnion() {
        return this.isInEuropeanUnion;
    }

    public void setIsInEuropeanUnion(String isInEuropeanUnion) {
        this.isInEuropeanUnion = isInEuropeanUnion;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalcode() {
        return this.postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public BigDecimal getLatitude() {
        return this.latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return this.longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public Location geonameId(String geonameId) {
        this.geonameId = geonameId;
        return this;
    }

    public Location localeCode(String localeCode) {
        this.localeCode = localeCode;
        return this;
    }

    public Location continentCode(String continentCode) {
        this.continentCode = continentCode;
        return this;
    }

    public Location continentName(String continentName) {
        this.continentName = continentName;
        return this;
    }

    public Location countryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
        return this;
    }

    public Location countryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public Location subdivision1isoCode(String subdivision1isoCode) {
        this.subdivision1isoCode = subdivision1isoCode;
        return this;
    }

    public Location subdivision1name(String subdivision1name) {
        this.subdivision1name = subdivision1name;
        return this;
    }

    public Location subdivision2isoCode(String subdivision2isoCode) {
        this.subdivision2isoCode = subdivision2isoCode;
        return this;
    }

    public Location subdivision2name(String subdivision2name) {
        this.subdivision2name = subdivision2name;
        return this;
    }

    public Location cityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public Location metroCode(String metroCode) {
        this.metroCode = metroCode;
        return this;
    }

    public Location timeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    public Location isInEuropeanUnion(String isInEuropeanUnion) {
        this.isInEuropeanUnion = isInEuropeanUnion;
        return this;
    }

    public Location country(String country) {
        this.country = country;
        return this;
    }

    public Location city(String city) {
        this.city = city;
        return this;
    }

    public Location postalcode(String postalcode) {
        this.postalcode = postalcode;
        return this;
    }

    public Location latitude(BigDecimal latitude) {
        this.latitude = latitude;
        return this;
    }

    public Location longitude(BigDecimal longitude) {
        this.longitude = longitude;
        return this;
    }

    public Location blocks(List<Block> blocks) {
        this.blocks = blocks;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Location)) {
            return false;
        }
        Location location = (Location) o;
        return Objects.equals(geonameId, location.geonameId) && Objects.equals(localeCode, location.localeCode)
                && Objects.equals(continentCode, location.continentCode)
                && Objects.equals(continentName, location.continentName)
                && Objects.equals(countryIsoCode, location.countryIsoCode)
                && Objects.equals(countryName, location.countryName)
                && Objects.equals(subdivision1isoCode, location.subdivision1isoCode)
                && Objects.equals(subdivision1name, location.subdivision1name)
                && Objects.equals(subdivision2isoCode, location.subdivision2isoCode)
                && Objects.equals(subdivision2name, location.subdivision2name)
                && Objects.equals(cityName, location.cityName) && Objects.equals(metroCode, location.metroCode)
                && Objects.equals(timeZone, location.timeZone)
                && Objects.equals(isInEuropeanUnion, location.isInEuropeanUnion)
                && Objects.equals(country, location.country) && Objects.equals(city, location.city)
                && Objects.equals(postalcode, location.postalcode) && Objects.equals(latitude, location.latitude)
                && Objects.equals(longitude, location.longitude) && Objects.equals(blocks, location.blocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geonameId, localeCode, continentCode, continentName, countryIsoCode, countryName,
                subdivision1isoCode, subdivision1name, subdivision2isoCode, subdivision2name, cityName, metroCode,
                timeZone, isInEuropeanUnion, country, city, postalcode, latitude, longitude, blocks);
    }

    @Override
    public String toString() {
        return "{" + " geonameId='" + getGeonameId() + "'" + ", localeCode='" + getLocaleCode() + "'"
                + ", continentCode='" + getContinentCode() + "'" + ", continentName='" + getContinentName() + "'"
                + ", countryIsoCode='" + getCountryIsoCode() + "'" + ", countryName='" + getCountryName() + "'"
                + ", subdivision1isoCode='" + getSubdivision1isoCode() + "'" + ", subdivision1name='"
                + getSubdivision1name() + "'" + ", subdivision2isoCode='" + getSubdivision2isoCode() + "'"
                + ", subdivision2name='" + getSubdivision2name() + "'" + ", cityName='" + getCityName() + "'"
                + ", metroCode='" + getMetroCode() + "'" + ", timeZone='" + getTimeZone() + "'"
                + ", isInEuropeanUnion='" + getIsInEuropeanUnion() + "'" + ", country='" + getCountry() + "'"
                + ", city='" + getCity() + "'" + ", postalcode='" + getPostalcode() + "'" + ", latitude='"
                + getLatitude() + "'" + ", longitude='" + getLongitude() + "'" + ", blocks='" + getBlocks() + "'" + "}";
    }

}