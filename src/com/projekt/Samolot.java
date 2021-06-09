package com.projekt;

public class Samolot
{
    private String model;
    private String id;
    protected String type;

    protected int miejscaPierwszaKl;
    protected int miejscaBiznesowa;
    protected int miejscaEkonomiczna;

    protected int zasieg;

    protected int mnoznikPierwszaKl = 2;
    protected double mnoznikBiznesowa = 0.5;
    protected double mnoznikEkonomiczna = 0.2;

    public Samolot(String id, String model) { this.id = id; this.model = model; }

    public String getId() { return id; }

    public String getModel() { return model; }

    public void zarezerwujMiejscePierwszaKl() { miejscaPierwszaKl = miejscaPierwszaKl--; }

    public void zarezerwujMiejsceBiznesowa() { miejscaBiznesowa = miejscaBiznesowa--; }

    public void zarezerwujMiejsceEkonomiczna() { miejscaEkonomiczna = miejscaEkonomiczna--; }

    public void zwolnijMiejscePierwszaKl() { miejscaPierwszaKl++; }

    public void zwolnijMiejsceBiznesowa() { miejscaBiznesowa++; }

    public void zwolnijMiejsceEkonomiczna() { miejscaEkonomiczna++; }

    public int getMiejscaPierwszaKl() { return miejscaPierwszaKl; }

    public int getMiejscaBiznesowa() { return miejscaBiznesowa; }

    public int getMiejscaEkonomiczna() { return miejscaEkonomiczna; }

    public int getZasieg() { return zasieg; }

    public String toString() { return model + " " + " ID: " + id; }

    public int getMnoznikPierwszaKl() { return mnoznikPierwszaKl; }

    public double getMnoznikBiznesowa() { return mnoznikBiznesowa; }

    public double getMnoznikEkonomiczna() { return mnoznikEkonomiczna; }
}
