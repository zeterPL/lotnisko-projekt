package com.projekt;

public class TypA extends Samolot
{

    public TypA(String id, String model)
    {
        super(id,model);
        this.zasieg = 9800;
        this.miejsca = 366;
    }
    public void zdejmijMiejsce() {
        miejsca = miejsca--;
    }
    public void zwolnijMiejsce() {
        if (miejsca < 366) {
            miejsca++;
        }
    }


}
