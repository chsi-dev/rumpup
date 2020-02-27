package com.chsitemplate.service.imlp;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.chsitemplate.model.Template;
import com.chsitemplate.repository.TemplateRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TemplateServiceImplTest {

    @Mock
    private TemplateRepository templateRepository;

    @InjectMocks
    private TemplateServiceImpl templateService;

    @Test
    void getTemplateByName() {
        when(templateRepository.findTemplateByName(any())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> templateService.getTemplateByName("name"));
    }

    @Test
    void addTemplate() {
        Template template = new Template();
        templateService.addTemplate(template);
        verify(templateRepository, times(1)).save(template);
    }
}