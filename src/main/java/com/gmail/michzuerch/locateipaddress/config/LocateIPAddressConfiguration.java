package com.gmail.michzuerch.locateipaddress.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Component
@PropertySource("classpath:application.yml")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "locateipaddress")
@Data
@Validated
public class LocateIPAddressConfiguration {
    @NotNull
    @Valid
    private String prop;
}
