package com.projekt;

public class TypD extends Samolot
{
    private int miejsca;
    private int zasieg;

    public TypD(String id, String model)
    {
        super(id,model);
        this.zasieg = 3700;
        this.miejsca = 70;
    }
    public void zdejmijMiejsce() {
        miejsca = miejsca--;
    }
    public void zwolnijMiejsce() {
        if (miejsca < 70) {
            miejsca++;
        }
    }
}
