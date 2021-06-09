package com.projekt;

import java.util.LinkedList;
import java.util.List;

public class Klient
{
    private List<Rezerwacja> rezerwacje;
    private int id = 0; //tymczasowo

    public Klient() { rezerwacje = new LinkedList<>(); }

    public void addRezerwacja(Rezerwacja rezerwacja) { rezerwacje.add(rezerwacja); }
    public List<Rezerwacja> getRezerwacje() { return rezerwacje; }

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

}
