package com.projekt;

public class TypD extends Samolot
{
    public String type;
    public TypD(String id, String model)
    {
        super(id,model);
        this.zasieg = 3700;
        this.miejsca = 70;
        this.type = "TypD";
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
