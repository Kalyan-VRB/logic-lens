package org.logiclens.backend.repository;

import org.logiclens.backend.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SolutionRepository extends JpaRepository<Solution, UUID> {
    List<Solution> findByProblem_Id(UUID problemId);
}
