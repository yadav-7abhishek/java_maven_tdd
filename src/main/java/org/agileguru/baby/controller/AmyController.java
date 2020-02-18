package org.agileguru.baby.controller;

import static org.agileguru.baby.Constants.DAD_MAPPING;
import static org.agileguru.baby.Constants.DAD_NAME;
import static org.agileguru.baby.Constants.MOM_MAPPING;
import static org.agileguru.baby.Constants.MOM_NAME;
import static org.agileguru.baby.Constants.WORK;
import static org.agileguru.baby.Constants.WORK_MAPPING;
import static org.springframework.http.HttpStatus.OK;

import org.agileguru.baby.Constants;
import org.agileguru.baby.service.NameByTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmyController {

    @Autowired
    private NameByTypeService service;

    @GetMapping(Constants.WILDCARD_MAPPING)
    public ResponseEntity<String> getByName(@PathVariable String type) {
       try {
           return new ResponseEntity<>(this.service.getByType(type),HttpStatus.OK);
       } catch ( NullPointerException e ) {
        return new ResponseEntity<>("Vandy", HttpStatus.BAD_REQUEST);
       }
    }
    

}
