package com.chsitemplate.controller;

import com.chsitemplate.model.Template;
import com.chsitemplate.service.TemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping("/template")
    public ResponseEntity<Template> getTemplateByName(@RequestParam(value = "name") String name) {
        Template template = templateService.getTemplateByName(name);
        return ResponseEntity.ok(template);
    }

    @PostMapping("/template")
    public ResponseEntity<Template> addTemplate(@RequestBody Template template) {
        Template savedTemplate = templateService.addTemplate(template);
        return ResponseEntity.ok(savedTemplate);
    }
}