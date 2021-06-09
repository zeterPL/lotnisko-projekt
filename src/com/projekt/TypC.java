package com.projekt;

public class TypC extends Samolot
{

    public String type;
    public TypC(String id, String model)
    {
        super(id,model);
        this.zasieg = 17370;
        this.miejsca = 550;
        this.type = "TypC";
    }
    public void zdejmijMiejsce() {
        miejsca = miejsca--;
    }
    public void zwolnijMiejsce() {
        if (miejsca < 550) {
            miejsca++;
        }
    }
}
