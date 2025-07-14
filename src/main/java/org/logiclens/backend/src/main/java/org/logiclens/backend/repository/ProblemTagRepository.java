package org.logiclens.backend.repository;

import org.logiclens.backend.model.ProblemTag;
import org.logiclens.backend.model.ProblemTagId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemTagRepository extends JpaRepository<ProblemTag, ProblemTagId> {
}
