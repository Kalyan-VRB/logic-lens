package org.logiclens.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tags")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
}
