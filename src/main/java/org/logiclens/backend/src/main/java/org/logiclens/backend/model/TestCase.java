package org.logiclens.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "test_cases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestCase {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @Lob
    @Column(nullable = false)
    private String input;

    @Lob
    @Column(name = "expected_output", nullable = false)
    private String expectedOutput;

    private Boolean isSample = false;

    private Integer orderIndex;
}
