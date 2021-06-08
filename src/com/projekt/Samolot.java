package com.projekt;

public class Samolot
{
    private String model;
    private String id;

    protected int miejsca;
    protected int zasieg;

    public Samolot(String id, String model) { this.id = id; this.model = model; }

    public String getId() {
        return id;
    }

    public int getMiejsca() {
        return miejsca;
    }


    public int getZasieg() {
        return zasieg;
    }

    public String toString()
    {
        return "Samolot: " + model + " " + " ID: " + id;
    }
}
