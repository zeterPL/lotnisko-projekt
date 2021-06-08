package com.projekt;

public class TypB extends Samolot
{
    private int miejsca;
    private int zasieg;

    public TypB(String id, String model)
    {
        super(id,model);
        this.zasieg = 15900;
        this.miejsca = 380;
    }
    public void zdejmijMiejsce() {
        miejsca = miejsca--;
    }
    public void zwolnijMiejsce() {
        if (miejsca < 380) {
            miejsca++;
        }
    }
}
