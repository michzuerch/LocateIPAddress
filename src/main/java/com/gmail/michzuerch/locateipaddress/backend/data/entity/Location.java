package com.gmail.michzuerch.locateipaddress.backend.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "Location")
public class Location extends AbstractEntity {
    @NotNull(message = "{locateipaddress.geonameId.required")
    @Size(min = 3)
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

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Block> blocks;

    private Location(Builder builder) {
        setGeonameId(builder.geonameId);
        setLocaleCode(builder.localeCode);
        setContinentCode(builder.continentCode);
        setContinentName(builder.continentName);
        setCountryIsoCode(builder.countryIsoCode);
        setCountryName(builder.countryName);
        setSubdivision1isoCode(builder.subdivision1isoCode);
        setSubdivision1name(builder.subdivision1name);
        setSubdivision2isoCode(builder.subdivision2isoCode);
        setSubdivision2name(builder.subdivision2name);
        setCityName(builder.cityName);
        setMetroCode(builder.metroCode);
        setTimeZone(builder.timeZone);
        setIsInEuropeanUnion(builder.isInEuropeanUnion);
        setCountry(builder.country);
        setCity(builder.city);
        setPostalcode(builder.postalcode);
        setLatitude(builder.latitude);
        setLongitude(builder.longitude);
        setBlocks(builder.blocks);
    }

    public Location() {
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

    public static final class Builder {
        private @NotNull(message = "{locateipaddress.geonameId.required") @Size(min = 3) String geonameId;
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
        private List<Block> blocks;

        public Builder() {
        }

        public Builder geonameId(@NotNull(message = "{locateipaddress.geonameId.required") @Size(min = 3) String val) {
            geonameId = val;
            return this;
        }

        public Builder localeCode(String val) {
            localeCode = val;
            return this;
        }

        public Builder continentCode(String val) {
            continentCode = val;
            return this;
        }

        public Builder continentName(String val) {
            continentName = val;
            return this;
        }

        public Builder countryIsoCode(String val) {
            countryIsoCode = val;
            return this;
        }

        public Builder countryName(String val) {
            countryName = val;
            return this;
        }

        public Builder subdivision1isoCode(String val) {
            subdivision1isoCode = val;
            return this;
        }

        public Builder subdivision1name(String val) {
            subdivision1name = val;
            return this;
        }

        public Builder subdivision2isoCode(String val) {
            subdivision2isoCode = val;
            return this;
        }

        public Builder subdivision2name(String val) {
            subdivision2name = val;
            return this;
        }

        public Builder cityName(String val) {
            cityName = val;
            return this;
        }

        public Builder metroCode(String val) {
            metroCode = val;
            return this;
        }

        public Builder timeZone(String val) {
            timeZone = val;
            return this;
        }

        public Builder isInEuropeanUnion(String val) {
            isInEuropeanUnion = val;
            return this;
        }

        public Builder country(String val) {
            country = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Builder postalcode(String val) {
            postalcode = val;
            return this;
        }

        public Builder latitude(BigDecimal val) {
            latitude = val;
            return this;
        }

        public Builder longitude(BigDecimal val) {
            longitude = val;
            return this;
        }

        public Builder blocks(List<Block> val) {
            blocks = val;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}