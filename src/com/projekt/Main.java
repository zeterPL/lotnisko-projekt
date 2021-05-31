package com.projekt;

import org.ietf.jgss.GSSName;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //maksymalna liczba opcji programu
    public static int liczbaOpcji = 4;

    public static void drawMenu()
    {
        System.out.println("Wybierz opcje:");
        System.out.println("1. Zarezerwuj Lot");
        System.out.println("2. Dodaj nową trase");
        System.out.println("3. Generuj lot na wybranej trasie");
        System.out.println("4. Wyjdz");
    }


    public static void main(String[] args)
    {
	    List<Trasa> trasy = new LinkedList<>();
	    List<Lot> loty = new LinkedList<>();
	    List<Samolot> samoloty = new LinkedList<>();
	    List<Klient> klienci = new LinkedList<>();


        //TESTOWE NIEISTOTNE
/*



	    Lot a,b;
	    a=new Lot();
	    b=new Lot();

	    Trasa t1, t2;

	    t1 = new Trasa(new Lotnisko("Wlochy", "Wenecja"), new Lotnisko("Polska", "Bialystok"));
	    t2 = new Trasa(new Lotnisko("Chorwacja", "Split"), new Lotnisko("Niemcy", "Berlin"));

	    a.setSamolot(new Samolot("234GDNS98PL", "Airbus"));
        a.setTrasa(t1);
	    b.setSamolot(new Samolot("GDSM9460ANG", "Boeing"));
	    b.setTrasa(t2);

	    loty.add(a);
	    loty.add(b);


*/

        //numer wybranej opcji
        int e;

	    do
	    {
	        drawMenu();
	        System.out.println("Opcja: ");
            Scanner scanner = new Scanner(System.in);
            e = scanner.nextInt();

            switch (e)
            {
                case 1:

                    Lot lot;
                    Klient klient;

                    //



                    break;
                case 2:
                    //
                    break;
                case 3:
                    //
                    break;
                case 4:
                    //
                    break;
            }

        }while (e!=liczbaOpcji);

    }
}
