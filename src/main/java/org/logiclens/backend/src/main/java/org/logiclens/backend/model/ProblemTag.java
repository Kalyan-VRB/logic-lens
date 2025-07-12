package org.logiclens.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "problem_tags")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@IdClass(ProblemTagId.class)
public class ProblemTag {
    @Id
    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
