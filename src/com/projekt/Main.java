package com.projekt;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*
    OPCJA1
    OPCJA2  ZROBIONE
    OPCJA3
    OPCJA3
    OPCJA5
     */


    //maksymalna liczba opcji programu
    public static int liczbaOpcji = 6;

    //czy byl juz samolot z takim samym id
    public static boolean idCheck(String id, List<Samolot> samoloty)
    {
        for(int i=0;i<samoloty.size();i++)
        {
            if(samoloty.get(i).getId().equals(id)) return true;
        }
        return false;
    }

    public static void drawMenu()
    {
        System.out.println("Wybierz opcje:");
        System.out.println("1. Zarezerwuj Lot");
        System.out.println("2. Zarzadzaj samolotami");
        System.out.println("3. Zarzadzaj trasami");
        System.out.println("4. Generuj lot na wybranej trasie");
        System.out.println("5. Zapisz lub otworz stan systemu");
        System.out.println("6. Wyjdz");
    }


    public static void main(String[] args)
    {
	    List<Trasa> trasy = new LinkedList<>();
	    List<Lotnisko> lotniska = new LinkedList<>();

	    List<Samolot> samoloty = new LinkedList<>();
	    List<Klient> klienci = new LinkedList<>();

        List<Lot> loty = new LinkedList<>();



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

                    int w;
                    do
                    {
                        System.out.println("Smolotow w bazie: " + samoloty.size());
                        System.out.println("1. Dodaj samolot");
                        System.out.println("2. Usun samolot");
                        System.out.println("3. Wyswietl liste samolotow");
                        System.out.println("4. Wstecz");
                        System.out.println("Opcja: ");
                        w = scanner.nextInt();

                        switch (w)
                        {
                            case 1:

                                String model = "";
                                String id = "";
                                String typ;


                               while(model.equals(""))
                               {
                                    System.out.print("Podaj model: ");
                                    model = scanner.next();
                               }

                               do
                               {
                                   System.out.print("Podaj id: ");
                                   id = scanner.next();

                               }while (idCheck(id, samoloty));


                                do
                                {
                                    System.out.print("Podaj typ (TypA, TypB, TypC, TypD): ");
                                    typ = scanner.next();

                                    if(typ.equals("TypA") || typ.equals("TypB") || typ.equals("TypC") || typ.equals("TypD"))
                                        break;

                                }while (true);

                                if(typ.equals("TypA")) { samoloty.add(new TypA(id,model)); }
                                if(typ.equals("TypB")) { samoloty.add(new TypB(id,model)); }
                                if(typ.equals("TypC")) { samoloty.add(new TypC(id,model)); }
                                if(typ.equals("TypD")) { samoloty.add(new TypD(id,model)); }

                                break;

                            case 2:
                                //String toRemove;
                                System.out.print("Podaj Id samolotu do usuniecia: ");
                                String toRemove = scanner.next();
                                for(int i=0;i< samoloty.size();i++){
                                    if(samoloty.get(i).getId().equals(toRemove)){
                                        samoloty.remove(samoloty.get(i));
                                    }
                                }
                                break;

                            case 3:
                                for(int i=0;i<samoloty.size();i++) System.out.println(samoloty.get(i).toString());
                                break;

                            case 4:
                                break;
                        }


                    }while (w!=4);
                    break;
                case 3:
                    int w1;

                    do
                    {
                        System.out.println("Dostepnych tras: " + trasy.size());
                        System.out.println("Lotniska w bazie: " + lotniska.size());
                        System.out.println("1. Dodaj nowa trase");
                        System.out.println("2. Dodaj nowe lotnisko");
                        System.out.println("3. Dodaj lotnisko do trasy");
                        System.out.println("4. Wyswietl wszystkie trasy");
                        System.out.println("5. Wyswietl wszystkie lotniska");
                        System.out.println("6. Wstecz");
                        System.out.println("Opcja: ");
                        w1 = scanner.nextInt();

                    }while (w1!=6);

                    break;
                case 4:
                    //
                    break;

                case 5:
                    //zapis danych do pliku tekstowego w taki sposób zeby było potem można łatwo wczytac dane do programu
                    break;

                case 6:
                    //
                    break;
            }

        }while (e!=liczbaOpcji);

    }
}
