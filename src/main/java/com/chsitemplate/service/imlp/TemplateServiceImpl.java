package com.chsitemplate.service.imlp;

import com.chsitemplate.model.Template;
import com.chsitemplate.repository.TemplateRepository;
import com.chsitemplate.service.TemplateService;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository templateRepository;

    public TemplateServiceImpl(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    @Override
    public Template getTemplateByName(String name) {

        return templateRepository.findTemplateByName(name)
                .orElseThrow(() -> new RuntimeException("Template not found"));
    }

    @Override
    public Template addTemplate(Template template) {
        return templateRepository.save(template);
    }
}
