package com.projekt;

import java.util.LinkedList;
import java.util.List;

public class Lot
{
    private List<Klient> klienci;
    private Samolot samolot;
    private Trasa trasa;

    protected String type;


    private float gPodroz; //czas podróży

    public Lot()
    {
        klienci = new LinkedList<>();
        this.type="";
    }

    public Samolot getSamolot() {
        return samolot;
    }

    public List<Klient> getKlienci() {
        return klienci;
    }

    public void addKlient(Klient klient) { klienci.add(klient); }

    public void setSamolot(Samolot samolot) {
        this.samolot = samolot;
    }

    public void setTrasa(Trasa trasa) {
        this.trasa = trasa;
        gPodroz = trasa.getDlugosc()/800; //800km/h prędkość
    }

    public Trasa getTrasa() {
        return trasa;
    }

    public float getgPodroz() {
        return gPodroz;
    }

    public String toString()
    {
        return trasa.toString() + " " + samolot.toString() + " " + " Czas podróży: " + gPodroz + "h";

    }
}
