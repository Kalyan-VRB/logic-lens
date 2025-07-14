package org.logiclens.backend.repository;

import org.logiclens.backend.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TestCaseRepository extends JpaRepository<TestCase, UUID> {
    List<TestCase> findByProblem_Id(UUID problemId);
}
