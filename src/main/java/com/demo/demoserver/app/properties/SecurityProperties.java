package com.demo.demoserver.app.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "spring.security")
@ConstructorBinding
@RequiredArgsConstructor
@Getter
public class SecurityProperties {

    private final User user;

    @ConstructorBinding
    @RequiredArgsConstructor
    @Getter
    public static class User {
        private final String name;
        private final String password;
    }
}
