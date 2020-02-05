package org.agileguru.baby.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BabyControllerTest {

    private BabyController babyController;

    @Before
    public void setUp() throws Exception {
        babyController = new BabyController();
    }

    @Test
    public void canGetData() {
        assertThat(babyController).isNotNull();
        assertThat(babyController.getAllbabies().getBody()).isNotNull().isNotEmpty().hasSize(1);
    }

}
