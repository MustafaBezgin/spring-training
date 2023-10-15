package com.cydeo.streotype_annotation.config;

import com.cydeo.streotype_annotation.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.cydeo.streotype_annotation")
public class PcConfig {

    @Bean
    public Dimensions dimensions(){
        return new Dimensions(50, 10, 10);
    }

}
