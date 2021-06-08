package com.projekt;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Trasa
{
    private Lotnisko cel; //miejsce przylotu czylo (DO)
    private Lotnisko baza; //miejsce wylotu (czyli OD)
    private float dlugosc;

    private void setDlugosc() throws IOException {
        //TODO wyliczenie i ustawienie dlugosci

        String poczatek  = baza.getMiasto();
        String koniec = cel.getMiasto();
        List<String> miasta = Files.readAllLines(Paths.get("ListaMiast.txt"));
        int indeksPoczatku, indeksKonca;
        for (int i = 0; i < miasta.size(); i++)
        {
            if (miasta.get(i).equals(poczatek)) // RÓWNOSC Z POCZATKIEM MIASTA Z LISTY O INDEKSIE I
            {
                indeksPoczatku = i;
            }
            if (miasta.get(i).equals(koniec)) // CZY ELEMENT LISTY O DANYM INDEKSIE JEST ROWNY,
            {
                indeksKonca = i;
            }
        }
        // tutaj znamy indeksy poczatku i konca
        // dalej po pliku forem


        //tymczasowo
        this.dlugosc = 10000;
        // CZY odleglosc nie moze byc z tego pliku, do ktorego wpisalem tych ponad 50 miast?
//        System.out.println("PODAJ NAZWE PLIKU CSV BEZ ROZSZERZENIA: ");
 //       Scanner czytamZKlawiatury = new Scanner(System.in); //USER MA PODAC NAZWE PLIKU
        String nazwaPliku; 					// NAZWA PLIKU TO CIAG ZNAKOW, WIEC STRING
 //       nazwaPliku = czytamZKlawiatury.nextLine(); //NAZWA PLIKU PODAJE Z KLAWIATURY
        nazwaPliku = "macierzOdleglosci.csv";
       // double odczyt = odczytaj(nazwaPliku);

        int[][] tablicaOdleglosci = new int [miasta.size()][miasta.size()];


    }


    public Trasa(Lotnisko baza, Lotnisko cel) throws IOException {
        this.baza = baza;
        this.cel = cel;

        this.setDlugosc();
    }

    public String toString()
    {
        return "Trasa: " + baza.toString() + " do " + cel.toString() + " " + "Dlugosc: " + dlugosc;
    }

    public float getDlugosc() {
        return dlugosc;
    }
}
