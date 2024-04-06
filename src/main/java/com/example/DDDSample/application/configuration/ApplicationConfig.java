package com.example.DDDSample.application.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@EnableConfigurationProperties
@Configuration
@ConfigurationProperties(prefix = "api")
@Getter
public class ApplicationConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    private GW gw = new GW();

    @Getter @Setter
    public static class GW {
        private String ip;
        private Integer port;
        private Integer timeout;
        private String whitelist;
    }
}
