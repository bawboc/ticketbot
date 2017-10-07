package com.ticketbot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <h1>Mapping Configuration for Cross Origin</h1>
 * 
 * @author James Lawley
 * @version 1.0
 * */
@Configuration
public class TicketBotConfiguration {

	@Bean
	public WebMvcConfigurerAdapter corsSonfigurer() {
		return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
	}
}
