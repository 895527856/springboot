package com.example.zuul.config;

import com.example.zuul.Filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetWayConfig {
        @Bean
        public AccessFilter accessFilter(){
            return new AccessFilter();
        }

}
