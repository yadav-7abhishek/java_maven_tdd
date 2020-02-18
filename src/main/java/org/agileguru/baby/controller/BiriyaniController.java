package org.agileguru.baby.controller;

import org.agileguru.baby.exceptions.YouWillHaveABadTummyException;
import org.agileguru.baby.model.Biriyani;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BiriyaniController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BiriyaniController.class);
    
    public Biriyani getMild() {
        return createBiriyaniWithSprice(1);
    }
    
    private Biriyani createBiriyaniWithSprice(Number amount) {
        Biriyani biriyani = new Biriyani(amount);
        debugSpiceContent(biriyani);
        if ( amount.intValue() > 3 ) {
            throw new YouWillHaveABadTummyException();
        }
        return biriyani;
    }

    public Biriyani getExtraHot() {
        return createBiriyaniWithSprice(20);
    }
    
    public Biriyani getHot() {
        return createBiriyaniWithSprice(2);
    }

    public void debugSpiceContent(Biriyani biriyani) {
        LOGGER.debug("Returning a Biriyani with {} spoons of spices", biriyani.getSpiceAmount());
    }
}
