package org.agileguru.baby.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.annotation.Annotation;

import org.agileguru.baby.Constants;
import org.agileguru.baby.service.NameByTypeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.RestController;

@RunWith(MockitoJUnitRunner.class)
public class AmyControllerMockTest {
    
    @Mock
    private NameByTypeService service; 
    @InjectMocks
    private AmyController amyController  = new AmyController();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(service.getByType(Constants.DAD_MAPPING)).thenReturn(Constants.DAD_NAME);
        when(service.getByType(Constants.WORK_MAPPING)).thenReturn(Constants.WORK);
    }
    
    @Test
    public void testNotNull() {
        assertThat(this.amyController).isNotNull();
    }

    @Test
    public void testGetDad() {
        assertThat(this.amyController.getByName(Constants.DAD_MAPPING).getBody()).isNotNull()
                .isEqualTo(Constants.DAD_NAME);
    }
    @Test
    public void testGetWork() {
        assertThat(this.amyController.getByName(Constants.WORK_MAPPING).getBody()).isNotNull()
        .isEqualTo(Constants.WORK);
        verify(this.service).getByType(Constants.WORK_MAPPING);
    }

    @Test
    public void testIfRestController() {
        Annotation[] annotations = this.amyController.getClass().getAnnotations();
        assertThat(annotations).isNotEmpty();
        assertThat(annotations[0]).isInstanceOf(RestController.class);
    }

}
