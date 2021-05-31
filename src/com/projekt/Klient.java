package com.projekt;

import java.util.LinkedList;
import java.util.List;

public class Klient
{
    public List<Rezerwacja> rezerwacje;

    public Klient() { rezerwacje = new LinkedList<>(); }

    public void addRezerwacja(Rezerwacja rezerwacja) { rezerwacje.add(rezerwacja); }
    public List<Rezerwacja> getRezerwacje() { return rezerwacje; }

}
