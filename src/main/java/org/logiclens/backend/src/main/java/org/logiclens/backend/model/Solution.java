package org.logiclens.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "solutions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Solution {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @Lob
    @Column(nullable = false)
    private String code;

    private Boolean isOptimal = false;

    private LocalDateTime createdAt = LocalDateTime.now();
}
