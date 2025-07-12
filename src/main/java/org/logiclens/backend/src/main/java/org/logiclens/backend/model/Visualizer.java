package org.logiclens.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "visualizers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visualizer {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @Column(nullable = false)
    private String filePath; // Can be relative path or S3 URL

    private String description;

    private LocalDateTime createdAt = LocalDateTime.now();
}

