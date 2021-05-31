package com.projekt;

public class Lotnisko
{
    private String kraj;
    private String miasto;

    public String getKraj() {
        return kraj;
    }

    public String getMiasto() {
        return miasto;
    }

    public Lotnisko(String kraj, String miasto)
    {
        this.kraj = kraj;
        this.miasto = miasto;
    }

    public String toSting()
    {
        return "Lotnisko " + miasto + " " + kraj;
    }
}
