package org.agileguru.baby.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    private static final String HELLO_WORLD = "Hello World develop";

    @GetMapping("/")
    public ResponseEntity<String> sayHello() {

        ResponseEntity<String> responseEntity = new ResponseEntity<>(HELLO_WORLD, OK);
        return responseEntity;
    }
}
