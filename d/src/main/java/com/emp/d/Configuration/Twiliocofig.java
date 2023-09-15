package com.emp.d.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
public class Twiliocofig {
    private String accountSid;
    private String authToken;
    private String PhoneNumber;
}
