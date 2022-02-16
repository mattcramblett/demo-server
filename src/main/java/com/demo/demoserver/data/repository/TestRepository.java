package com.demo.demoserver.data.repository;

import com.demo.demoserver.data.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
}
