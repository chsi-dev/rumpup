package com.chsitemplate.repository;

import java.util.Optional;

import com.chsitemplate.model.Template;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends CrudRepository<Template, Integer> {
    Optional<Template> findTemplateByName(String name);
}
