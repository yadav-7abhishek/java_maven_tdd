package org.agileguru.baby.controller;

import static org.agileguru.baby.Constants.DAD_MAPPING;
import static org.agileguru.baby.Constants.DAD_NAME;
import static org.agileguru.baby.Constants.MOM_MAPPING;
import static org.agileguru.baby.Constants.MOM_NAME;
import static org.agileguru.baby.Constants.WORK;
import static org.agileguru.baby.Constants.WORK_MAPPING;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmyController {

    @GetMapping(DAD_MAPPING)
    public ResponseEntity<String> getDad() {
        return new ResponseEntity<>(DAD_NAME, OK);
    }

    @GetMapping(MOM_MAPPING)
    public ResponseEntity<String> getMom() {
        return new ResponseEntity<>(MOM_NAME, OK);
    }

    @GetMapping(WORK_MAPPING)
    public ResponseEntity<String> getWork() {
        return new ResponseEntity<>(WORK, OK);
    }

}
