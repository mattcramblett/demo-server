package com.demo.demoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.demo.demoserver")
public class DemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoServerApplication.class, args);
    }

}
