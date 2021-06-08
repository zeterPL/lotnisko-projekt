package com.projekt;

public class TypA extends Samolot
{
    private int miejsca;
    private int zasieg;

    public TypA(String id, String model)
    {
        super(id,model);
        this.zasieg = 9800;
        this.miejsca = 366;
    }

}
