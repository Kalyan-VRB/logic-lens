package org.logiclens.backend.repository;

import org.logiclens.backend.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProblemRepository extends JpaRepository<Problem, UUID> {
    List<Problem> findByCategory_Id(Long categoryId);

    List<Problem> findByDifficulty_Id(Long difficultyId);
}
