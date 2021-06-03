package com.projekt;

public class Samolot
{
    private String model;
    private String id;

    public Samolot(String id, String model) { this.id = id; this.model = model; }

    public String getId() {
        return id;
    }

    public String toString()
    {
        return "Samolot: " + model + " " + " ID: " + id;
    }
}
