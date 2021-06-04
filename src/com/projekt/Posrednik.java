package com.projekt;

public class Posrednik extends Klient
{
    private String nazwa;

    public Posrednik(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Firma " + nazwa + " liczba rezerwacji: " + getRezerwacje().size();
    }
}
