package org.agileguru.baby.controller;

import java.util.Collections;
import java.util.List;

import org.agileguru.baby.BabyAppLogMetaData;
import org.agileguru.baby.model.Baby;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alacritysys.frameworks.logging.elf.Logger;
import com.alacritysys.frameworks.logging.elf.factory.LogFactory;

@RestController
public class BabyController {
    private static final Logger LOGGER = LogFactory.getLogger(BabyController.class, new BabyAppLogMetaData());

    @GetMapping("/")
    public ResponseEntity<List<Baby>> getAllbabies() {
        Baby baby = new Baby();
        baby.setFirstName("Vandhana");
        baby.setLastName("Gurumoorthy");
        LOGGER.logInfoFormatted("Returning A collection of single object with name and surname as {}, {}",
                baby.getFirstName(), baby.getLastName());
        return new ResponseEntity<>(Collections.singletonList(baby), HttpStatus.OK);
    }
}
