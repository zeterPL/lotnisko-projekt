package com.projekt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class Lot
{
    private List<Klient> klienci;
    private Samolot samolot;
    private Trasa trasa;
    String gPowrot;

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
    public Klient getKlient(int x) {
        return klienci.get(x);
    }

    public void setTrasa(Trasa trasa) {

        //TUTAJ UŻYTO DODATKOWEJ BIBLIOTEKI
        this.trasa = trasa;
        LocalDateTime teraz = LocalDateTime.now();
        gPodroz = trasa.getDlugosc()/800; //800km/h to PREDKOSC SAMOLOTOW
        LocalDateTime gPowrot = teraz.plusHours((long)gPodroz);

        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatted = gPowrot.format(myFormat);

        this.gPowrot = formatted;
    }

    public Trasa getTrasa() {
        return trasa;
    }

    public float getgPodroz() {
        return gPodroz;
    }

    public String toString()
    {
        return trasa.toString() + " " + samolot.toString() + " " + "\n Czas podróży: " + gPodroz + "h " +
                "Godzina powrotu: " +
                gPowrot;

    }
}
