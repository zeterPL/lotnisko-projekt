package com.projekt;

public class TypB extends Samolot
{

    public TypB(String id, String model)
    {
        super(id,model);
        this.zasieg = 15900;
        this.miejscaPierwszaKl = 80;
        this.miejscaPierwszaKlmax = 80;

        this.miejscaBiznesowa = 90;
        this.miejscaBiznesowaMax = 90;

        this.miejscaEkonomiczna = 210;
        this.miejscaEkonomicznaMax = 210;
        this.type = "TypB";
    }
    public void zarezerwujMiejscePierwszaKl() {
            miejscaPierwszaKl = miejscaPierwszaKl--;
    }

    public void zarezerwujMiejsceBiznesowa() {
            miejscaBiznesowa = miejscaBiznesowa--;
    }

    public void zarezerwujMiejsceEkonomiczna() {
            miejscaEkonomiczna = miejscaEkonomiczna--;
    }

    public void zwolnijMiejscePierwszaKl() {
            miejscaPierwszaKl++;
    }

    public void zwolnijMiejsceBiznesowa() {
            miejscaBiznesowa++;
    }

    public void zwolnijMiejsceEkonomiczna() {
            miejscaEkonomiczna++;
    }
    public int getMiejscaPierwszaKl() {
        return miejscaPierwszaKl;
    }

    public int getMiejscaBiznesowa() {
        return miejscaBiznesowa;
    }

    public int getMiejscaEkonomiczna() {
        return miejscaEkonomiczna;
    }

    public int getMiejscaPierwszaKlMax() { return miejscaPierwszaKlmax; }
    public int getMiejscaBiznesowaMax() { return miejscaBiznesowaMax; }
    public int getMiejscaEkonomicznaMax() { return miejscaEkonomicznaMax; }
}
