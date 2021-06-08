package com.projekt;


import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;
import java.util.*;
import java.io.*;

public class Main {

    //TODO UWAGA: W implementacji programu należy OBOWIĄZKOWO wykorzystać i opisać przynajmniej
    // jedną bibliotekę użytego języka programowania opisaną w jego dokumentacji technicznej
    // w języku angielskim (EU5).


    //maksymalna liczba opcji programu
    public static int liczbaOpcji = 8;

    //czy byl juz samolot z takim samym id
    public static boolean idCheck(String id, List<Samolot> samoloty) {
        for (int i = 0; i < samoloty.size(); i++) {
            if (samoloty.get(i).getId().equals(id)) return true;
        }
        return false;
    }

    //wypisuje główne menu
    public static void drawMenu() {
        System.out.println("Wybierz opcje:");
        System.out.println("1. Zarządzaj klientami"); //done
        System.out.println("2. Zarzadzaj samolotami"); //done
        System.out.println("3. Zarzadzaj lotniskami"); //done
        System.out.println("4. Zarządzaj lotami"); //TODO
        System.out.println("5. Zarządzaj trasami"); //done
        System.out.println("6. Zarządzaj rezerwacjami"); //TODO
        System.out.println("7. Zapisz lub otworz stan systemu"); //TODO
        System.out.println("8. Wyjdz");
    }


    public static void main(String[] args) throws IOException {
        List<Trasa> trasy = new LinkedList<>();
        List<Lotnisko> lotniska = new LinkedList<>();
        List<Samolot> samoloty = new LinkedList<>();
        List<Klient> klienci = new LinkedList<>();
        List<Lot> loty = new LinkedList<>();
        List<Rezerwacja> rezerwacje = new LinkedList<>();
        List <String> listaMiast = new ArrayList<>();
        LinkedList numeryBiletow = new LinkedList();                               
        Random generator = new Random();                                           

        String nazwaPliku = "ListaMiast.txt";
    //    File plik = new File("ListaMiast.txt");
      //  List<String> miasto = Files.readAllLines(Paths.get("ListaMiast.txt"));


        //numer wybranej opcji
        int e;

        //petla główna
        do {
            System.out.println("\n-------------------------------------");
            System.out.println("AKTUALNY STAN SYSTEMU");
            System.out.println("Liczba klientow: " + klienci.size());
            System.out.println("Liczba samolotow: " + samoloty.size());
            System.out.println("Liczba lotnisk: " + lotniska.size());
            System.out.println("Liczba tras: " + trasy.size());
            System.out.println("Liczba dostepnych lotow: " + loty.size());
            System.out.println("-------------------------------------\n");
            drawMenu();
            System.out.println("Opcja: ");
            Scanner scanner = new Scanner(System.in);
            e = scanner.nextInt();

            switch (e) {
                case 1:                                     //klienci

                    int w2;
                    do {
                        System.out.println("Liczba klientow: " + klienci.size());
                        System.out.println("--------Lista klientów: ---------"); //zrobione

                        for (int i = 0; i < klienci.size(); i++) {
                            System.out.println(i + 1 + ". " + klienci.get(i).toString());
                        }
                        System.out.println("---------------------------------");
                        System.out.println("1. Dodaj klienta."); //zrobione
                        System.out.println("2. Usuń klienta.");
                        System.out.println("3. Wstecz.");
                        System.out.println("Opcja: ");

                        w2 = scanner.nextInt();

                        switch (w2) {

                            case 1: //                        dodaj klienta
                                int w3;
                                do {
                                    System.out.println("1. Firma");
                                    System.out.println("2. Osoba prywatna");
                                    System.out.println("3. Wstecz");
                                    System.out.println("Opcja: ");
                                    w3 = scanner.nextInt();

                                    if (w3 == 1) {
                                        int w4;

                                        do {
                                            System.out.println("1. Posrednik");
                                            System.out.println("2. Korporacja");
                                            System.out.print("Opcja: ");
                                            w4 = scanner.nextInt();
                                        } while (w4 != 1 && w4 != 2);

                                        System.out.print("Nazwa: ");
                                        String nazwa = scanner.next();

                                        if (w4 == 1) {
                                            klienci.add(new Posrednik(nazwa));
                                        }
                                        if (w4 == 2) {
                                            klienci.add(new Korpo(nazwa));
                                        }
                                    } else if (w3 == 2) {
                                        int w4;
                                        do {
                                            System.out.println("1. Zwykla osoba");
                                            System.out.println("2. VIP");
                                            System.out.print("Opcja: ");
                                            w4 = scanner.nextInt();
                                        } while (w4 != 1 && w4 != 2);

                                        System.out.print("Imie: ");
                                        String imie = scanner.next();

                                        System.out.print("Nazwisko: ");
                                        String nazwisko = scanner.next();

                                        if (w4 == 1) {
                                            klienci.add(new Osoba(imie, nazwisko));
                                        }
                                        if (w4 == 2) {
                                            klienci.add(new OsobaVip(imie, nazwisko));
                                        }

                                    } else if (w3 == 3) break;

                                } while (w3 != 3);
                                break;
                            case 2: //                          usuń klienta
                                System.out.println("Podaj indeks klienta którego chciałbyś usunąć");
                                int x = scanner.nextInt();
                                klienci.remove(x-1);
                                break;
                            case 3:
                                break;
                        }

                    } while (w2 != 3);
                    break;
                case 2:                                     //samoloty

                    int w;
                    do {
                        System.out.println("Smolotow w bazie: " + samoloty.size());

                        System.out.println("------ Lista samolotów: ------");
                        for (int i = 0; i < samoloty.size(); i++)
                            System.out.println(i + 1 + ". " + samoloty.get(i).toString());
                        System.out.println("------------------------------");

                        System.out.println("1. Dodaj samolot");
                        System.out.println("2. Usun samolot");
                        System.out.println("3. Wstecz");
                        System.out.println("Opcja: ");
                        w = scanner.nextInt();

                        switch (w) {
                            case 1://                               dodawanie samolotu

                                String model = "";
                                String id = "";
                                String typ;


                                while (model.equals("")) {
                                    System.out.print("Podaj model: ");
                                    model = scanner.next();
                                }
                                do {
                                    System.out.print("Podaj id: ");
                                    id = scanner.next();

                                } while (idCheck(id, samoloty));

                                do {
                                    System.out.print("Podaj typ (TypA, TypB, TypC, TypD): ");
                                    typ = scanner.next();

                                    if (typ.equals("TypA") || typ.equals("TypB") || typ.equals("TypC") || typ.equals("TypD")) {
                                        break;
                                    } else {
                                        System.out.println("Podaj właściwy typ samolotu!");
                                    }

                                } while (true);

                                if (typ.equals("TypA")) {
                                    samoloty.add(new TypA(id, model));
                                }
                                if (typ.equals("TypB")) {
                                    samoloty.add(new TypB(id, model));
                                }
                                if (typ.equals("TypC")) {
                                    samoloty.add(new TypC(id, model));
                                }
                                if (typ.equals("TypD")) {
                                    samoloty.add(new TypD(id, model));
                                }

                                break;

                            case 2://                       usuwanie samolotu

                                System.out.print("Podaj numer samolotu do usuniecia: ");
                                int toRemove = scanner.nextInt();
                                samoloty.remove(toRemove - 1);
                                break;

                            case 3://                       exit
                                break;
                        }


                    } while (w != 3);
                    break;

                case 3:                                    //lotniska
                    int w1;

                    do {
                        System.out.println("Ilość lotnisk w bazie: " + lotniska.size());

                        System.out.println("------ Lista wszystkich lotnisk dostępnych w bazie: ------");
                        for (int i = 0; i < lotniska.size(); i++) {
                            System.out.println(i + 1 + ". " + lotniska.get(i).toString());
                        }
                        System.out.println("----------------------------------------------------------");

                        System.out.println("1. Dodaj nowe lotnisko");
                        System.out.println("2. Usuń lotnisko");
                        System.out.println("3. Wstecz");
                        System.out.println("Opcja: ");
                        w1 = scanner.nextInt();

                        switch (w1) {

                            case 1:
                                System.out.print("Podaj kraj: ");
                                String kraj = scanner.next();
                                System.out.print("Podaj miasto: ");
                                String m = scanner.next();

                                lotniska.add(new Lotnisko(kraj, m));

                                break;

                            case 2:
                                System.out.println("Podaj numer indeksu lotniska które chcesz usunąć");
                                int c = scanner.nextInt();
                                lotniska.remove(c-1);
                                break;

                            case 3:
                                break;
                        }

                    } while (w1 != 3);

                    break;
                case 4:
                    int x;                               //loty
                    do {
                        System.out.println("Liczba dostepnych lotow: " + loty.size());

                        System.out.println("------ Lista wszystkich dostępnych lotów: ------"); //zrobione

                        for (int i = 0; i < loty.size(); i++) {
                            System.out.println(i + 1 + ". " + loty.get(i).toString());
                        }
                        System.out.println("------------------------------------------------");

                        System.out.println("1. Dodaj lot na trasie.");
                        System.out.println("2. Anuluj lot.");
                        System.out.println("3. Wstecz.");
                        System.out.println("Wybór: ");
                         x = scanner.nextInt();

                        switch(x) {
                            case 1: //dodaj lot
                                if (trasy.size() < 1) {
                                    System.out.println("Niewystarczająca ilość tras.");
                                    break;
                                }

                                System.out.println("Wybierz trasę na której chcesz dodać lot: ");
                                System.out.println("------ Lista dostępnych tras: ------");
                                for (int i = 0; i < trasy.size(); i++) {
                                    System.out.println(i + 1 + ". " + trasy.get(i).toString());
                                }
                                System.out.println("------------------------------------");

                                System.out.println("Wybór: ");
                                int g = scanner.nextInt();

                                if(g > trasy.size())
                                {
                                    System.out.println("\nBłąd indeksu! Spróbuj ponownie.\n");
                                }
                                else
                                {
                                    Trasa t = trasy.get(g-1);
                                    float odl = t.getDlugosc();

                                    int j =0;
                                    System.out.println("------ Lista samolotow obsugujacych ten dystans: ------");
                                    for (int i = 0; i < samoloty.size(); i++)
                                    {

                                        if(odl <= samoloty.get(i).getZasieg())
                                        {
                                            System.out.println(j + 1 + ". " + samoloty.get(i).toString());
                                            j++;
                                        }

                                    }

                                     if(j==0)
                                     {
                                        System.out.println("\nBrak dostepnych samolotow\n");
                                        break;
                                     }

                                    System.out.println("------------------------------------");

                                     System.out.println("Wybierz numer samolotu: ");
                                     System.out.print("Wybor:  ");
                                     int in = scanner.nextInt();

                                     Lot lot = new Lot();
                                     lot.setTrasa(t);
                                     lot.setSamolot(samoloty.get(in-1));
                                     loty.add(lot);

                                }


                            case 2:   //anuluj lot
                                System.out.println("------ Lista wszystkich dostępnych lotów: ------"); //zrobione

                                for (int i = 0; i < loty.size(); i++) {
                                    System.out.println(i + 1 + ". " + loty.get(i).toString());
                                }
                                System.out.println("------------------------------------------------");
                                System.out.print("Nr lotu do usuniecia: ");
                                int nr = scanner.nextInt();

                                if(nr > loty.size())
                                {
                                    System.out.println("\nBłąd indeksu! Spróbuj ponownie.\n");
                                }
                                else
                                { loty.remove(nr-1);}


                                break;
                            case 3:
                                break;
                        }
                    } while(x!=3);

                case 5:
                    int z;                                  //trasy
                    do
                    {
                    System.out.println("Ilość dostępnych tras: " + trasy.size());
                    System.out.println("------ Lista dostępnych tras: ------");
                    for (int i = 0; i < trasy.size(); i++) {
                        System.out.println(i + 1 + ". " + trasy.get(i).toString());
                    }
                    System.out.println("------------------------------------");


                        System.out.println("1. Dodaj nowe połączenie.");
                        System.out.println("2. Wycofaj połączenie pomiędzy lotniskami.");
                        System.out.println("3. Wstecz.");
                        System.out.println("Wybór: ");
                        z = scanner.nextInt();

                        switch(z) {
                            case 1:
                                if (lotniska.size() == 0) {
                                    System.out.println("Brak dostępnych lotnisk.");
                                    break;
                                }
                                for (int i = 0; i < lotniska.size(); i++) {
                                    System.out.println(i + 1 + ". " + lotniska.get(i).toString());
                                }

                                System.out.print("Wybierz nr lotniska wylotu: ");
                                int wylot = scanner.nextInt();
                                System.out.print("Wybierz nr lotniska przylotu: ");
                                int cel = scanner.nextInt();

                                if (wylot > lotniska.size() || cel > lotniska.size()) {
                                    System.out.println("\nBłąd indeksu! Spróbuj ponownie.\n");
                                } else {
                                    trasy.add(new Trasa(lotniska.get(wylot - 1), lotniska.get(cel - 1)));
                                    break;
                                }

                            case 2:
                                for (int i = 0; i < trasy.size(); i++) {
                                    System.out.println(i + 1 + ". " + trasy.get(i).toString());
                                }

                                System.out.print("Wybierz nr trasy do usuniecia: ");
                                int nr = scanner.nextInt();

                                if(nr > trasy.size()){
                                    System.out.println("\nBłąd indeksu! Spróbuj ponownie.\n");
                                }
                                else {
                                    trasy.remove(nr-1);
                                }

                                break;

                            case 3:
                                break;
                        }

                    }while (z!=3);

                    break;

                case 6:                                    //rezerwacje
                    System.out.println("1. Dodaj nową rezerwację. ");
                    System.out.println("2. Sprawdź ilość rezerwacji na danym locie. ");
                    System.out.println("3. Usuń rezerwację. ");

                    int a = scanner.nextInt();

                    switch(a) {
                        case 1:
                            if(klienci.size() < 1) {System.out.println("Brak klientow"); break; }
                            System.out.println("Wybierz klienta rezerwującego lot: ");
                            System.out.println("-------------------------------------");
                             for (int i = 0; i < klienci.size(); i++) {
                                 System.out.println(i + 1 + ". " + klienci.get(i).toString());
                             }
                            System.out.println("-------------------------------------");
                            System.out.println("Wybór: ");
                            int q = scanner.nextInt(); //todo klient musi miec rezerwacje a lot klienta

                            if(loty.size() < 1) {System.out.println("Brak lotow"); break; }
                            System.out.println("Wybierz numer lotu na którym chcesz dokonać rezerwacji. ");
                            System.out.println("-------------------------------------");
                            for (Lot lot : loty) {
                                System.out.println(1 + 1 + ". " + lot.toString());
                            }
                            System.out.println("-------------------------------------");
                             int f = scanner.nextInt();

                             int numerBiletu = generator.nextInt(41000);

                            Iterator it = numeryBiletow.iterator();
                            boolean istniejeNumer = true;
                            while(istniejeNumer) {
                                for (Object o : numeryBiletow) {
                                    if (o.equals(numerBiletu)) {
                                        istniejeNumer = true;
                                        numerBiletu = generator.nextInt(41000);
                                    } else {
                                        istniejeNumer = false;
                                    }
                                }
                            }
                            System.out.println("Twój numer biletu: " + numerBiletu);
                            System.out.println(numerBiletu);
                            System.out.println("Liczba dostępnych miejsc: ");
                            System.out.println(loty.get(f-1).getSamolot().getMiejsca());
                            
                            rezerwacje.add(new Rezerwacja(new Bilet(5, numerBiletu), loty.get(f-1)));
                    }                                               //dałem byle co żeby sie kompilowało
                    //                                              //TODO cena biletu
                    break;

                case 7: //                               zapisz lub otwórz stan systemu
                    //
                    break;

                case 8:
                    break;//exit
            }

        } while (e != liczbaOpcji);

    }
}
