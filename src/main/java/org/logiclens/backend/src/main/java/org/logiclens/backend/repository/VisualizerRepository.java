package org.logiclens.backend.repository;

import org.logiclens.backend.model.Visualizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VisualizerRepository extends JpaRepository<Visualizer, UUID> {
    List<Visualizer> findByProblem_Id(UUID problemId);
}
