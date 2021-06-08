package com.projekt;

public class TypC extends Samolot
{
    private int miejsca;
    private int zasieg;

    public TypC(String id, String model)
    {
        super(id,model);
        this.zasieg = 17370;
        this.miejsca = 550;
    }
}
