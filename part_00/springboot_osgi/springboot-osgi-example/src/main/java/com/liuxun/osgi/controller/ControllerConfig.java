package com.liuxun.osgi.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {
    @Bean
    public TestController testController(){
        return new TestController();
    }
}
