package com.projekt;

public class Posrednik extends Klient
{
    private String nazwa;

    public Posrednik(String nazwa) {

        this.nazwa = nazwa;
        this.type = "Posrednik";
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
