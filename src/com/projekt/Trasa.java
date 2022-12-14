package com.projekt;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
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

        List<String> miasta = new LinkedList<>(); //inicjalizacja listy
        try
        {
            miasta = Files.readAllLines(Paths.get("ListaMiast.txt"));
        }
        catch (NoSuchFileException exception) //jak nie ma pliku to łapie wyjątek
        {
            System.out.println("\nBlad bazy danych!!\n");
        }

        int indeksPoczatku=0, indeksKonca=0; //domyslna wartosc 0 zeby sie kompilowało
        for (int i = 0; i < miasta.size(); i++)
        {
            if (miasta.get(i).equals(poczatek)) // RÓWNOSC Z POCZATKIEM MIASTA Z LISTY O INDEKSIE I
            {
                indeksPoczatku = i;
            }
            else
            if (miasta.get(i).equals(koniec)) // CZY ELEMENT LISTY O DANYM INDEKSIE JEST ROWNY,
            {
                indeksKonca = i;
            }
        }
        // tutaj znamy indeksy poczatku i konca
        // dalej po pliku forem


        //tymczasowo
        this.dlugosc = 10000;
        String nazwaPliku;
        nazwaPliku = "macierzOdleglosci.csv";

        int[][] tablicaOdleglosci = new int [miasta.size()][miasta.size()];

        Scanner sc = new Scanner(new BufferedReader(new FileReader("macierzOdleglosci.csv")));
        while(sc.hasNextLine())
        {
            for (int i=0; i<miasta.size(); i++)
            {
                String[] line = sc.nextLine().trim().split(";");    // TRIM - bez spacji na poczatku i koncu
                for (int j=0; j<miasta.size(); j++)
                {
                    tablicaOdleglosci[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
    //    System.out.println(Arrays.deepToString(tablicaOdleglosci)); // PRINTOWANIE MOZE SIE PRZYDAC
        this.dlugosc = tablicaOdleglosci[indeksPoczatku][indeksKonca];     // DLUGOSC TRASY TO EL. TABLICY
    }


    public Trasa(Lotnisko baza, Lotnisko cel) throws IOException
    {
        this.baza = baza;
        this.cel = cel;

        this.setDlugosc();
    }

    public String toString()
    {
        return  baza.toString() + " do " + cel.toString() + " " + "Dlugosc: " + dlugosc;
    }

    public float getDlugosc() {
        return dlugosc;
    }

    public Lotnisko getBaza() {
        return baza;
    }

    public Lotnisko getCel() {
        return cel;
    }
}
