package com.projekt;

public class Trasa
{
    private Lotnisko cel;
    private Lotnisko baza; //miejsce wylotu
    private float dlugosc;

    private void setDlugosc()
    {
        //TODO wyliczenie i ustawienie dlugosci

        String poczatek  = baza.getMiasto();
        String koniec = baza.getMiasto();

        // dalej po pliku forem

        //tymczasowo
        this.dlugosc = 10000;
    }

    public Trasa(Lotnisko baza, Lotnisko cel)
    {
        this.baza = baza;
        this.cel = cel;

        this.setDlugosc();
    }

    public String toString()
    {
        return "Trasa: " + baza.toString() + " do " + cel.toString() + " " + "Dlugosc: " + dlugosc;
    }

    public float getDlugosc() {
        return dlugosc;
    }
}
