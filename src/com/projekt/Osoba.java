package com.projekt;

public class Osoba extends Klient
{
    private String imie;
    private String nazwisko;

    public Osoba(String imie, String nazwisko)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString()
    {
        return imie + " " + nazwisko + " liczba rezerwacji: " + getRezerwacje().size();
    }
}
