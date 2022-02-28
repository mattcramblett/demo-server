package com.demo.demoserver.integration

import com.demo.demoserver.DemoServerApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = IntegrationSpecInitializer, classes = DemoServerApplication.class)
class IntegrationSpec extends Specification {

    @LocalServerPort
    protected Integer serverPort

    @Autowired
    protected TestRestTemplate restTemplate
}
