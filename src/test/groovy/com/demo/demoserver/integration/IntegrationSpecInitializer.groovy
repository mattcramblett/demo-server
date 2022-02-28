package com.demo.demoserver.integration

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.DockerComposeContainer

class IntegrationSpecInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public static DockerComposeContainer COMPOSE
    static {
        COMPOSE = new DockerComposeContainer(new File("src/test/resources/docker/docker-compose.yml"))
                .withExposedService("mariadb_1", 3306)
        COMPOSE.start()
    }

    @Override
    void initialize(final ConfigurableApplicationContext applicationContext) {
        TestPropertyValues.of(
                "spring.datasource.url=jdbc:mysql://localhost:${COMPOSE.getServicePort("mariadb_1", 3306)}/demo?createDatabaseIfNotExist=true&serverTimezone=UTC",
                "spring.datasource.username=root",
                "spring.datasource.password=password"
        ).applyTo(applicationContext.getEnvironment())
    }
}
