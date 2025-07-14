package org.logiclens.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProblemRequestDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private Long categoryId;

    private Long difficultyId;

    private Set<Long> tagIds;
}
