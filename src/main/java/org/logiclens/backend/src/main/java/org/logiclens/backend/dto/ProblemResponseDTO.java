package org.logiclens.backend.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProblemResponseDTO {

    private UUID id;

    private String title;

    private String description;

    private String category;

    private String difficulty;

    private Set<String> tags;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
