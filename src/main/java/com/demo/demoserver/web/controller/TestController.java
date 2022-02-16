package com.demo.demoserver.web.controller;

import com.demo.demoserver.data.entity.TestEntity;
import com.demo.demoserver.data.repository.TestRepository;
import com.demo.demoserver.web.request.TestRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/test")
public class TestController {

    private final TestRepository testRepository;

    @GetMapping
    public ResponseEntity<List<TestEntity>> list() {
        return ResponseEntity.ok(testRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<TestEntity> create(@RequestBody final TestRequest request) {
        final TestEntity newEntity = new TestEntity();
        newEntity.setName(request.getName());
        newEntity.setTime(request.getTime());
        newEntity.setActive(request.isActive());
        final TestEntity savedEntity = testRepository.save(newEntity);
        return ResponseEntity.ok(savedEntity);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<TestEntity> update(@PathVariable final long id, @RequestBody final TestRequest request) {
        final Optional<TestEntity> entityMaybe = testRepository.findById(id);
        if (entityMaybe.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        TestEntity entity = entityMaybe.get();
        entity.setName(request.getName());
        entity.setTime(request.getTime());
        entity.setActive(request.isActive());
        final TestEntity savedEntity = testRepository.save(entity);
        return ResponseEntity.ok(savedEntity);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable final long id) {
        final Optional<TestEntity> entityMaybe = testRepository.findById(id);
        entityMaybe.ifPresent(testRepository::delete);
        return ResponseEntity.ok("Successfully deleted.");
    }

}
