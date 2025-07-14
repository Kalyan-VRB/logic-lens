package org.logiclens.backend.mapper;

import org.logiclens.backend.dto.ProblemRequestDTO;
import org.logiclens.backend.dto.ProblemResponseDTO;
import org.logiclens.backend.model.Problem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProblemMapper {

    @Mapping(source = "category.name", target = "category")
    @Mapping(source = "difficulty.level", target = "difficulty")
    @Mapping(source = "tags", target = "tags")
    ProblemResponseDTO toDto(Problem problem);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "difficultyId", target = "difficulty.id")
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    Problem toEntity(ProblemRequestDTO dto);
}

