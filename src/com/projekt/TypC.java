package com.projekt;

public class TypC extends Samolot
{


    public TypC(String id, String model)
    {
        super(id,model);
        this.zasieg = 17370;
        this.miejscaPierwszaKl = 100;
        this.miejscaBiznesowa = 130;
        this.miejscaEkonomiczna = 220;
        this.type = "TypC";
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
}
