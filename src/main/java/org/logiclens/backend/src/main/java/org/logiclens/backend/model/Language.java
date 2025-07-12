package org.logiclens.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "languages")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
}
