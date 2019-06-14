package com.kyle.portfolio.msa.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http
    		.authorizeRequests()
    			.antMatchers("/uaa/**", "/login", "/logout").permitAll()
    			.antMatchers("/api/admin/**").hasRole("ADMIN")
    			.antMatchers("/api/user/**").hasAnyRole("ADMIN", "USER")
    			.antMatchers("/api/guest/**").permitAll()
    			.anyRequest().authenticated()
        ;
    }
    
}
