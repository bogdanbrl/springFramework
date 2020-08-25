package com.criptex.util.thymeleaf;
// used for decoupled template. Section 09.12 spring tim b.

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

@Slf4j
@Component
public class DecoupledLogicSetup {
    private final SpringResourceTemplateResolver templateResolver;

    public DecoupledLogicSetup(SpringResourceTemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
    }

    // == init ==
    public void init(){
        templateResolver.setUseDecoupledLogic(true);
        log.info("Decoupled template logic enabled.");
    }
}
