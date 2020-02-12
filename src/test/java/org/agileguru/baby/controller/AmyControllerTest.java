package org.agileguru.baby.controller;

import static org.agileguru.baby.Constants.DAD_NAME;
import static org.agileguru.baby.Constants.MOM_NAME;
import static org.agileguru.baby.Constants.WORK;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.Annotation;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.RestController;

public class AmyControllerTest {

    private AmyController amyController;

    @Before
    public void setUp() throws Exception {
        amyController = new AmyController();
        
    }

    @Test
    public void testNotNull() {
        assertThat(this.amyController).isNotNull();
    }
    
    
    @Test
    public void testGetDad() {
        assertThat(this.amyController.getDad().getBody()).isNotNull().isEqualTo(DAD_NAME);
    }
    
    @Test
    public void testGetMom() {
        assertThat(this.amyController.getMom().getBody()).isNotNull().isEqualTo(MOM_NAME);
    }
    
    @Test
    public void testGetWork() {
        assertThat(this.amyController.getWork().getBody()).isNotNull().isEqualTo(WORK);
    }
    
    @Test
    public void testIfRestController() {
        Annotation[] annotations = this.amyController.getClass().getAnnotations();
        assertThat(annotations).isNotEmpty();
        assertThat(annotations[0]).isInstanceOf(RestController.class);
    }
    
}
