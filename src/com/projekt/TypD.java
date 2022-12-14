package com.projekt;

public class TypD extends Samolot
{

    public TypD(String id, String model)
    {
        super(id,model);
        this.zasieg = 3700;
        this.miejscaPierwszaKl = 10;
        this.miejscaPierwszaKlmax = 10;

        this.miejscaBiznesowa = 10;
        this.miejscaBiznesowaMax = 10;

        this.miejscaEkonomiczna = 50;
        this.miejscaEkonomicznaMax = 50;

        this.type = "TypD";
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
