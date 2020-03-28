package org.agileguru.baby.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class DefaultControllerTest {
    private DefaultController defaultController;

    @Before
    public void setUp() {
        defaultController = new DefaultController();
    }

    @Test
    public void testDefaultController() {
        ResponseEntity<String> resp = defaultController.sayHello();
        assertThat(resp).isNotNull();
        assertThat(resp.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
        assertThat(resp.getBody()).isNotNull().isEqualTo("Hello World develop");
    }

    @Test
    public void testDefaultControllerAnnotations() throws NoSuchMethodException {

        assertThat(defaultController.getClass().getAnnotations()[0]).isInstanceOf(RestController.class);
        Method sayHello = this.defaultController.getClass().getMethod("sayHello");
        Annotation annotation = sayHello.getAnnotations()[0];
        assertThat(annotation).isInstanceOf(GetMapping.class);
        GetMapping mapping = (GetMapping) annotation;
        assertThat(mapping.value()[0]).isNotNull().isEqualTo("/");
    }
}
