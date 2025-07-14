package org.logiclens.backend.repository;

import org.logiclens.backend.model.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DifficultyRepository extends JpaRepository<Difficulty, Long> {
}
