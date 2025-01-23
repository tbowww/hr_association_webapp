package com.openclassrooms.webapp.repository;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="com.openclassrooms.webapp")
public class CustomProperties {
	String apiUrl;
}
