package com.example.ApiGateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

public class SecurityConfig {

    
	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity httpSecurity) {
		httpSecurity
        .authorizeExchange()
        .anyExchange()
        .authenticated()
        .and()
        .oauth2Client()
        .and()
        .oauth2ResourceServer()
        .jwt();

		return httpSecurity.build();
}
}
