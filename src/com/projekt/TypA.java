package com.projekt;

public class TypA extends Samolot
{



    public TypA(String id, String model)
    {
        super(id,model);
        this.zasieg = 9800;

        miejscaPierwszaKl = 70;
        miejscaPierwszaKlmax = 70;

        miejscaBiznesowa = 100;
        miejscaBiznesowaMax = 100;

        miejscaEkonomiczna = 196;
        miejscaEkonomicznaMax = 196;
        this.type = "TypA";
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
