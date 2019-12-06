package com.gmail.michzuerch.locateipaddress.backend.data.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity(name = "Block") // "Order" is a reserved word
public class Block extends AbstractEntity {
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

    private Block(Builder builder) {
        setNetwork(builder.network);
        setGeonameId(builder.geonameId);
        setRegisteredCountryGeonameId(builder.registeredCountryGeonameId);
        setRepresentedCountryGeonameId(builder.representedCountryGeonameId);
        setIsAnonymousProxy(builder.isAnonymousProxy);
        setIsSatelliteProvider(builder.isSatelliteProvider);
        setPostalCode(builder.postalCode);
        setLatitude(builder.latitude);
        setLongitude(builder.longitude);
        setAccuracyRadius(builder.accuracyRadius);
        setStartip(builder.startip);
        setEndip(builder.endip);
        setLocation(builder.location);
    }

    public Block() {
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static final class Builder {
        private @NotNull(message = "{locateipaddress.network.required") String network;
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
        private Location location;

        public Builder() {
        }

        public Builder network(@NotNull(message = "{locateipaddress.network.required") String val) {
            network = val;
            return this;
        }

        public Builder geonameId(String val) {
            geonameId = val;
            return this;
        }

        public Builder registeredCountryGeonameId(String val) {
            registeredCountryGeonameId = val;
            return this;
        }

        public Builder representedCountryGeonameId(String val) {
            representedCountryGeonameId = val;
            return this;
        }

        public Builder isAnonymousProxy(String val) {
            isAnonymousProxy = val;
            return this;
        }

        public Builder isSatelliteProvider(String val) {
            isSatelliteProvider = val;
            return this;
        }

        public Builder postalCode(String val) {
            postalCode = val;
            return this;
        }

        public Builder latitude(String val) {
            latitude = val;
            return this;
        }

        public Builder longitude(String val) {
            longitude = val;
            return this;
        }

        public Builder accuracyRadius(String val) {
            accuracyRadius = val;
            return this;
        }

        public Builder startip(BigDecimal val) {
            startip = val;
            return this;
        }

        public Builder endip(BigDecimal val) {
            endip = val;
            return this;
        }

        public Builder location(Location val) {
            location = val;
            return this;
        }

        public Block build() {
            return new Block(this);
        }
    }
}
