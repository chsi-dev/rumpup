package com.chsitemplate.repository;

import com.chsitemplate.model.Template;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends CrudRepository<Template, Integer> {
   Optional<Template> findTemplateByName(String name);
}
