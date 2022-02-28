package com.demo.demoserver.test

import com.demo.demoserver.integration.IntegrationSpec
import com.demo.demoserver.web.controller.TestController
import com.demo.demoserver.web.request.TestRequest
import org.springframework.beans.factory.annotation.Autowired

import java.time.Instant
import java.time.temporal.ChronoUnit

class TestControllerIT extends IntegrationSpec {

    @Autowired
    private TestController testController

    void "create and list :: insert and read from database"() {
        given: "some arbitrary test data"
        def name = "testname"
        def time = Instant.now().truncatedTo(ChronoUnit.SECONDS)

        when: "we invoke the create method"
        testController.create(new TestRequest(name, true, time))

        then:
        with(testController.list().getBody().get(0)) {
            it.getName() == name
            it.isActive()
            it.getTime() == time
        }
    }
}
