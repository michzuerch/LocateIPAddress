package com.gmail.michzuerch.locateipaddress.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "locateipaddress")
@Data
public class LocateIPAddressConfiguration {

    private String prop;
}
