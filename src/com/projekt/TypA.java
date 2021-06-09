package com.projekt;

public class TypA extends Samolot
{

    public String type;

    public TypA(String id, String model)
    {
        super(id,model);
        this.zasieg = 9800;
        miejscaPierwszaKl = 70;
        miejscaBiznesowa = 100;
        miejscaEkonomiczna = 196;
        this.type = "TypA";
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

}
