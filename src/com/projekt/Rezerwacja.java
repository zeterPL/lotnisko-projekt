package com.projekt;

public class Rezerwacja
{
    private Bilet bilet;
    private Lot lot;

    public Rezerwacja(Bilet bilet, Lot lot) { this.bilet = bilet; this.lot = lot; }

    public void setLot(Lot lot)
    {
        this.lot = lot;
    }

    public void setBilet(Bilet bilet)
    {
        this.bilet = bilet;
    }

    public Bilet getBilet()
    {
        return bilet;
    }

    public Lot getLot()
    {
        return lot;
    }
}
