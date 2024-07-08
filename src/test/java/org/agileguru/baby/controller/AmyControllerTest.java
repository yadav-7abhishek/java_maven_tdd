package org.agileguru.baby.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.Annotation;

import org.agileguru.baby.BabyDeemoApplication;
import org.agileguru.baby.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BabyDeemoApplication.class)
public class AmyControllerTest {
    
    @Autowired
    private AmyController amyController;

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
    public void testGetGuru() {
        assertThat(this.amyController.getByName("Guru").getBody()).isNotNull()
        .isEqualTo("Vandy");
        assertThat(this.amyController.getByName("Guru").getStatusCode()).isNotNull()
        .isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testIfRestController() {
        Annotation[] annotations = this.amyController.getClass().getAnnotations();
        assertThat(annotations).isNotEmpty();
        assertThat(annotations[0]).isInstanceOf(RestController.class);
    }

}
