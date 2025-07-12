# Logic Lens - Backend Architecture

## Overview

The backend of Logic Lens is designed to be clean, scalable, secure, and maintainable using industry-standard practices. The architecture is built using Spring Boot and follows a modular approach with layered separation of concerns.

---

## 1. What is Database Normalization?

**Normalization** is the process of organizing the columns and tables of a relational database to reduce data redundancy and improve data integrity. The most common normal forms include:

* **1NF (First Normal Form):** Eliminate repeating groups. Ensure atomic columns.
* **2NF (Second Normal Form):** Eliminate partial dependencies (non-prime attributes fully depend on the whole primary key).
* **3NF (Third Normal Form):** Eliminate transitive dependencies (non-prime attributes depend only on the primary key).

Logic Lens schema is normalized to **3NF** to ensure long-term scalability and clean relational mapping.

---

## 2. Core Entities and Relationships

| Entity     | Description                               |
|------------|-------------------------------------------|
| Category   | Problem category (e.g., Arrays, DP)       |
| Tag        | Tags like "binary-search", "recursion"    |
| Difficulty | Easy, Medium, Hard                        |
| Language   | Java, Python, etc. (for code solutions)   |
| Problem    | Core problem data                         |
| Solution   | Code solutions in various languages       |
| TestCase   | Input/output test data                    |
| Visualizer | HTML/JS visualizer references per problem |

---

## 3. Database Schema (Normalized)

### Table: `categories`

```sql
CREATE TABLE categories (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) UNIQUE NOT NULL
);
```

### Table: `tags`

```sql
CREATE TABLE tags (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) UNIQUE NOT NULL
);
```

### Table: `difficulties`

```sql
CREATE TABLE difficulties (
  id SERIAL PRIMARY KEY,
  level VARCHAR(20) UNIQUE NOT NULL  -- Easy, Medium, Hard
);
```

### Table: `languages`

```sql
CREATE TABLE languages (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL UNIQUE
);
```

### Table: `problems`

```sql
CREATE TABLE problems (
  id UUID PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  description TEXT NOT NULL,
  category_id INT REFERENCES categories(id),
  difficulty_id INT REFERENCES difficulties(id),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Table: `problem_tags` (Many-to-Many)

```sql
CREATE TABLE problem_tags (
  problem_id UUID REFERENCES problems(id) ON DELETE CASCADE,
  tag_id INT REFERENCES tags(id) ON DELETE CASCADE,
  PRIMARY KEY (problem_id, tag_id)
);
```

### Table: `solutions`

```sql
CREATE TABLE solutions (
  id UUID PRIMARY KEY,
  problem_id UUID REFERENCES problems(id) ON DELETE CASCADE,
  language_id INT REFERENCES languages(id),
  code TEXT NOT NULL,
  is_optimal BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Table: `test_cases`

```sql
CREATE TABLE test_cases (
  id UUID PRIMARY KEY,
  problem_id UUID REFERENCES problems(id) ON DELETE CASCADE,
  input TEXT NOT NULL,
  expected_output TEXT NOT NULL,
  is_sample BOOLEAN DEFAULT FALSE,
  order_index INT
);
```

### Table: `visualizers`

```sql
CREATE TABLE visualizers (
  id UUID PRIMARY KEY,
  problem_id UUID REFERENCES problems(id) ON DELETE CASCADE,
  file_path TEXT NOT NULL,
  description TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## 4. Spring Boot Project Structure

```
backend/
└── src/main/java/com/logiclens/
    ├── controller/         # Exposes REST APIs
    ├── service/            # Interface layer
    ├── service/impl/       # Business logic implementation
    ├── repository/         # Spring Data JPA interfaces
    ├── model/              # Entity classes
    ├── dto/                # Request/Response DTOs
    ├── mapper/             # MapStruct mappers
    ├── config/             # Configurations (CORS, security)
    └── LogicLensApplication.java
```

---

## 5. Security Best Practices

| Area                  | Implementation Strategy                       |
|-----------------------|-----------------------------------------------|
| Input Validation      | Bean validation annotations                   |
| Authentication        | Placeholder for future JWT auth               |
| Global Error Handling | `@ControllerAdvice` and custom exceptions     |
| CORS Policy           | Restricted to frontend domain                 |
| Logging               | Mask sensitive data, use audit logging        |
| Rate Limiting         | Use Spring Cloud Gateway or Bucket4j (future) |

---

## 6. Backend API Development Workflow

1. **Define DTOs**: Request and response models for each API.
2. **Define Mappers**: Use MapStruct to convert DTO <-> Entity.
3. **Build Services**: Write business logic in service layer.
4. **Create Controllers**: REST endpoints using `@RestController`.
5. **Testing**: Unit test services and integration test endpoints.

---

## 7. Next Steps

* Review schema and structure
* Scaffold Spring Boot entities from schema
* Add Docker support for backend
* Implement base-level API security
* Set up seed data for categories, difficulties, languages

---

## Conclusion

The backend design of Logic Lens ensures a solid foundation using normalized relational schema, clean code structure, and scalable architecture. Every design decision is made to align with enterprise standards and avoid unnecessary complexity or future technical debt.
