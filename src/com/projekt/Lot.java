package com.projekt;

import java.time.LocalDateTime; //może ta może inna ... będzie można ją opisać
import java.util.LinkedList;
import java.util.List;

public class Lot
{
    private List<Klient> klienci;
    private Samolot samolot;
    private Trasa trasa;

    //może będzie inny typ, trzeba zobaczyć czy jest jakiś lepszy
    private LocalDateTime gPowrot;
    private LocalDateTime gPodroz;

    public Lot()
    {
        klienci = new LinkedList<>();
        //TODO generowanie godzin w konstruktorze
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
    }

    public String toString()
    {
        return trasa.toString() + " " + samolot.toString();

    }
}
