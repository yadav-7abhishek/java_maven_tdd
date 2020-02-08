package org.agileguru.baby.model;

public class Biriyani {
    private Number spices = 1;
    
    public Biriyani(Number amount) {
        this.spices = amount;
    }

    public Biriyani() {
    }

    public Number getSpiceAmount() {
        return spices;
    }

    /**
     * @param spices the spices to set
     */
    public void setSpices(Number spices) {
        this.spices = spices;
    }

}
