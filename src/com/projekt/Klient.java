package com.projekt;

import java.util.LinkedList;
import java.util.List;

public class Klient
{
    private List<Rezerwacja> rezerwacje;
    private int id = 0; //tymczasowo
    private String klasa;
    protected String type;

    public Klient() {
        rezerwacje = new LinkedList<>();
    }

    public void addRezerwacja(Rezerwacja rezerwacja) {
        rezerwacje.add(rezerwacja);
    }

    public List<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString()
    {
        return "";
    }
    public void setKlasa(int x) {
        if (x == 1) {
            klasa = "Pierwsza";
        } else if (x == 2) {
            klasa = "Biznesowa";
        } else if (x == 3) {
            klasa = "Ekonomiczna";
        }
    }

    public String getKlasa() {
        return klasa;
    }
}
