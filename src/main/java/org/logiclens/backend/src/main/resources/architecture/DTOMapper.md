# Logic Lens Backend: Repository, DTO, and Mapper Layer (Detailed Guide)

This document covers the three foundational components of the Logic Lens backend layer after entity creation:

* Repository Layer
* DTO Layer
* Mapper Layer

Each section explains the structure, design rationale, and how annotations or design choices map to SQL or practical behavior.

---

## 1. Repository Layer

### What It Is:

The Repository layer provides CRUD operations on entity classes by extending Spring Data JPA’s `JpaRepository`. It abstracts SQL interaction through method names or custom queries.

### Folder: `repository`

### Structure:

```java
public interface CategoryRepository extends JpaRepository<Category, Long> {}
public interface DifficultyRepository extends JpaRepository<Difficulty, Long> {}
public interface LanguageRepository extends JpaRepository<Language, Long> {}
public interface TagRepository extends JpaRepository<Tag, Long> {}
public interface ProblemRepository extends JpaRepository<Problem, UUID> {
    List<Problem> findByCategory_Id(Long categoryId);
    List<Problem> findByDifficulty_Id(Long difficultyId);
}
public interface SolutionRepository extends JpaRepository<Solution, UUID> {
    List<Solution> findByProblem_Id(UUID problemId);
}
public interface TestCaseRepository extends JpaRepository<TestCase, UUID> {
    List<TestCase> findByProblem_Id(UUID problemId);
}
public interface VisualizerRepository extends JpaRepository<Visualizer, UUID> {
    List<Visualizer> findByProblem_Id(UUID problemId);
}
public interface ProblemTagRepository extends JpaRepository<ProblemTag, ProblemTagId> {}
```

### Why We Use It:

* Clean abstraction from database queries
* Allows derived query methods (e.g., `findByCategory_Id`)
* Can add `@Query` for complex joins later

---

## 2. DTO Layer (Data Transfer Objects)

### Purpose:

DTOs help:

* Separate API-level models from database entities
* Reduce payload size
* Allow validation and transformation
* Prevent exposing internal fields (e.g., IDs of joins)

### Folder: `dto`

### Example: `ProblemRequestDTO`

```java
@Getter
@Setter
@NoArgsConstructor
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
```

### Example: `ProblemResponseDTO`

```java
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
```

### Why We Do This:

* Frontend does not need full `Category` or `Tag` objects — just names or IDs
* Allows versioning of APIs (request/response flexibility)
* Clean separation for security and flexibility

---

## 3. Mapper Layer (Using MapStruct)

### Why MapStruct?

* Avoids repetitive manual mapping
* Generates code at compile time (no reflection)
* Supports nested mappings
* Maintains separation between layers

### Setup:

Create a folder: `mapper`

Add to `pom.xml`:

```xml

<dependencies>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
    </dependency>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

Add compiler plugin:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.10.1</version>
    <configuration>
        <source>17</source>
        <target>17</target>
        <annotationProcessorPaths>
            <path>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct-processor</artifactId>
                <version>1.5.5.Final</version>
            </path>
        </annotationProcessorPaths>
    </configuration>
</plugin>
```

### ProblemMapper.java

```java
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
```

### Annotation Explanation:

#### `@Mapper(componentModel = "spring")`

* MapStruct generates implementation as a Spring bean (`@Component`)
* Allows injecting via `@Autowired`

#### `@Mapping(source = "category.name", target = "category")`

* Maps `problem.getCategory().getName()` → `dto.setCategory(String)`
* Flattens nested object fields

#### `@Mapping(source = "difficulty.level", target = "difficulty")`

* Same pattern: nested to flat

#### `@Mapping(source = "tags", target = "tags")`

* Assumes custom mapper or conversion from `Set<Tag>` to `Set<String>`

#### `@Mapping(target = "id", ignore = true)`

* Entity `id` is autogenerated; no need to set from DTO

#### `@Mapping(source = "categoryId", target = "category.id")`

* Creates a `Category` object with just ID and assigns it to the `Problem`

#### `@Mapping(source = "difficultyId", target = "difficulty.id")`

* Same logic as above

#### `@Mapping(target = "tags", ignore = true)`

* Tags are many-to-many and must be fetched from DB — set manually

#### `@Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")`

* Sets timestamps manually during mapping

### Benefits of MapStruct:

* Reduces boilerplate mapping logic
* Maintains separation of DTOs and Entities
* Ensures clean and safe conversions between layers

---

This architecture ensures a clean domain model, efficient mapping, and scalable layering as the application grows. The next layer is the **Service + Controller**, where the business logic and API endpoints are implemented.
