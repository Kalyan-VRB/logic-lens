package org.logiclens.backend.repository;

import org.logiclens.backend.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
