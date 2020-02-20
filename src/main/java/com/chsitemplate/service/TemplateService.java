package com.chsitemplate.service;

import com.chsitemplate.model.Template;

public interface TemplateService {
    Template getTemplateByName(String name);

    Template addTemplate(Template template);
}
