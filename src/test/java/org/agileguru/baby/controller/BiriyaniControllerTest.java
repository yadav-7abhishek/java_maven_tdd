package org.agileguru.baby.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.agileguru.baby.exceptions.YouWillHaveABadTummyException;
import org.agileguru.baby.model.Biriyani;
import org.junit.Before;
import org.junit.Test;

public class BiriyaniControllerTest {

    private BiriyaniController biriyaniController;

    @Before
    public void setUp() {
        biriyaniController = new BiriyaniController();
    }

    @Test
    public void returnsBiriyani() {
        assertThat(this.biriyaniController).isNotNull();
    }
    @Test
    public void returnsMildBiriyani() {
        Biriyani mild = this.biriyaniController.getMild();
        assertThat(mild).isNotNull();
        assertThat(mild.getSpiceAmount()).isNotNull().isEqualTo(1);
    }
    
    @Test (expected = YouWillHaveABadTummyException.class)
    public void settingTooMuchSpice() {
        this.biriyaniController.getExtraHot();
    }
    
    @Test
    public void returnsHotBiriyani() {
        assertThat(this.biriyaniController.getHot()).isNotNull() ;
        assertThat(this.biriyaniController.getHot().getSpiceAmount()).isNotNull() ;
    }
    
    @Test
    public void compareBiriyani() {
        Biriyani mild = this.biriyaniController.getMild();
        Biriyani hot = this.biriyaniController.getHot();
        assertThat(hot.getSpiceAmount()).isNotEqualTo(mild.getSpiceAmount());
    }

}
