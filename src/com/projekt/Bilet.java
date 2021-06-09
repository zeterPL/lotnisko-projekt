package com.projekt;

public class Bilet {
    private double cena;
    private int nrMiejsca;
    private int id;

    public Bilet(double cena, int nrMiejsca, int id) {
        this.cena = cena;
        this.nrMiejsca = nrMiejsca;
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
