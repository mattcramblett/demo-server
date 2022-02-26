package com.demo.demoserver

import com.demo.demoserver.data.entity.TestEntity
import com.demo.demoserver.data.repository.TestRepository
import com.demo.demoserver.web.controller.TestController
import com.demo.demoserver.web.request.TestRequest
import org.springframework.http.HttpStatus
import spock.lang.Specification

import java.time.Instant

class TestControllerSpec extends Specification {

    private TestController testController

    private TestRepository testRepository

    void setup() {
        testRepository = Mock(TestRepository)
        testController = new TestController(testRepository)
    }

    def "when get is performed the objects are read from the database"() {
        given: "some arbitrary sample data"
        def data = [
                new TestEntity(1L, "a", true, Instant.now()),
                new TestEntity(2L, "b", false, Instant.now()),
                new TestEntity(3L, "c", true, Instant.now().minusMillis(2000L)),
        ]

        and: "the repository finds this data"
        testRepository.findAll() >> data

        when: "we call the controller get method"
        def response = testController.list()

        then: "the response has OK status"
        response.getStatusCode() == HttpStatus.OK

        and: "the response contains the expected data"
        response.getBody() == data
    }

    def "when update is performed the object fields are persisted"() {
        given: "some object"
        def testObject = new TestEntity(1L, "old name", true, Instant.now())

        and: "the repository returns this entity"
        testRepository.findById(1L) >> Optional.of(testObject)

        when: "an update is invoked"
        testController.update(1L, new TestRequest("new name", false, Instant.EPOCH))

        then: "the object is saved with updated fields"
        1 * testRepository.save({ it.id == 1L && it.name == "new name" && it.active == false && it.time == Instant.EPOCH })
    }

    def "when create is invoked, the new object is persisted"() {
        when: "the create method is invoked"
        testController.create(new TestRequest("new object", false, Instant.ofEpochMilli(42)))

        then: "the entity is saved with all fields"
        1 * testRepository.save({ it.name == "new object" && !it.active && it.time == Instant.ofEpochMilli(42) })
    }

    def "when delete is invoked, the object is removed by the repository"() {
        given: "the repository finds an entity by the requested id"
        testRepository.findById(42L) >> Optional.of(new TestEntity(42L, "", true, Instant.now()))

        when: "the delete method is invoked"
        testController.delete(42L)

        then: "the repository deletes the entity"
        1 * testRepository.delete({ it.id == 42L })
    }
}
