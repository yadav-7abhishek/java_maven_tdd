package org.agileguru.baby.controller;

import org.agileguru.baby.BiriyaniAppLogMetaData;
import org.agileguru.baby.exceptions.YouWillHaveABadTummyException;
import org.agileguru.baby.model.Biriyani;

import com.alacritysys.frameworks.logging.elf.Logger;
import com.alacritysys.frameworks.logging.elf.factory.LogFactory;

public class BiriyaniController {
    private static final Logger LOGGER = LogFactory.getLogger(BiriyaniController.class, new BiriyaniAppLogMetaData());
    
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
        LOGGER.logDebugFormatted("Returning a Biriyani with {} spoons of spices", biriyani.getSpiceAmount());
    }
}
