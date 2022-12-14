package com.projekt;

import java.io.IOException;

import java.util.*;
import java.io.*;

public class Main {

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
        System.out.println("4. Zarządzaj lotami"); //done
        System.out.println("5. Zarządzaj trasami"); //done
        System.out.println("6. Zarządzaj rezerwacjami"); //TODO
        System.out.println("7. Zapisz lub otworz stan systemu"); //TODO
        System.out.println("8. Wyjdz");
    }


    public static void main(String[] args) throws IOException {
        List<Trasa> trasy = new LinkedList<>();         // W TYM MIEJSCU PRZYGOTOWUJEMY LISTY NA DANE ROZNEGO TYPU
        List<Lotnisko> lotniska = new LinkedList<>();
        List<Samolot> samoloty = new LinkedList<>();
        List<Klient> klienci = new LinkedList<>();
        List<Lot> loty = new LinkedList<>();
        List<Rezerwacja> rezerwacje = new LinkedList<>();
        //List <String> listaMiast = new ArrayList<>();
        LinkedList numeryBiletow = new LinkedList();
        Random generator = new Random(); 
        List <Bilet> bilety = new LinkedList<>();                                          

        String nazwaPliku = "ListaMiast.txt";    // LISTA MIAST JEST POTRZEBNA, ABY MOZNA BYLO ZNAC ODLEGLOSCI

        //numer wybranej opcji
        int e=0;

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
            try
            {
                e = scanner.nextInt();
            }
            catch (InputMismatchException a)        // WYJATEK
            {
                System.out.println("\nPodaj numer opcji do wykonania!\n");
            }

              switch (e) {
                  case 1:                                     //klienci

                      int w2=0;
                      do {
                          System.out.println("Liczba klientow: " + klienci.size());
                          System.out.println("--------Lista klientów: ---------"); //zrobione

                          for (int i = 0; i < klienci.size(); i++) {
                              System.out.println(i + 1 + ". " + klienci.get(i).type+ " " + klienci.get(i).toString()
                              + " liczba rezerwacji: "+klienci.get(i).getRezerwacje().size());
                          }
                          System.out.println("---------------------------------");  // DRZEWO DECYZYJNE
                          System.out.println("1. Dodaj klienta."); //zrobione
                          System.out.println("2. Usuń klienta.");
                          System.out.println("3. Wstecz.");
                          System.out.println("Opcja: ");

                          try
                          {
                              w2 = scanner.nextInt();
                          }
                          catch (InputMismatchException a)      // WYJATEK
                          {
                              System.out.println("\nPodaj numer opcji do wykonania!\n");
                          }

                          switch (w2) {

                              case 1: //                        dodaj klienta
                                  int w3=0;
                                  do {
                                      System.out.println("1. Firma");     // CIAG DALSZY DRZEWKA DECYZYJNEGO
                                      System.out.println("2. Osoba prywatna");
                                      System.out.println("3. Wstecz");
                                      System.out.println("Opcja: ");
                                      try
                                      {
                                          w3 = scanner.nextInt();
                                      }
                                      catch (InputMismatchException a)
                                      {
                                          System.out.println("\nPodaj numer opcji do wykonania!\n");
                                      }

                                      if (w3 == 1) {
                                          int w4=0;

                                          do {
                                              System.out.println("1. Posrednik");       // WYBRANE ZOSTALY FIRMY
                                              System.out.println("2. Korporacja");
                                              System.out.print("Opcja: ");
                                              try
                                              {
                                                  w4 = scanner.nextInt();
                                              }
                                              catch (InputMismatchException a)
                                              {
                                                  System.out.println("\nPodaj numer opcji do wykonania!\n");
                                              }
                                          } while (w4 != 1 && w4 != 2);

                                          System.out.print("Nazwa: ");
                                          String nazwa = scanner.next();        // NAZWA PRZEDSIEBIORSTWA

                                          if (w4 == 1) {
                                              klienci.add(new Posrednik(nazwa));    // DODANIE FIRMY O DANEJ NAZWIE
                                          }
                                          if (w4 == 2) {
                                              klienci.add(new Korpo(nazwa));
                                          }
                                      } else if (w3 == 2) {
                                          int w4=0;
                                          do {
                                              System.out.println("1. Zwykla osoba");    // WYBRANO LUDZI (KLIENTOW)
                                              System.out.println("2. VIP");
                                              System.out.print("Opcja: ");
                                              try
                                              {
                                                  w4 = scanner.nextInt();
                                              }
                                              catch (InputMismatchException a)
                                              {
                                                  System.out.println("\nPodaj numer opcji do wykonania!\n");
                                              }
                                          } while (w4 != 1 && w4 != 2);

                                          System.out.print("Imie: ");
                                          String imie = scanner.next();         // PERSONALIA OSOBY

                                          System.out.print("Nazwisko: ");
                                          String nazwisko = scanner.next();

                                          if (w4 == 1) {
                                              klienci.add(new Osoba(imie, nazwisko));       // DODANIE
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
                                  klienci.remove(x-1);  // NA POZYCJI [x-1] LISTY USUWAMY KLIENTA
                                  break;
                              case 3:
                                  break;    // POWROC POZIOM WYZEJ
                          }

                      } while (w2 != 3);
                      break;
                  case 2:                                     //samoloty

                      int w=0;
                      do {
                          System.out.println("Smolotow w bazie: " + samoloty.size());   // AKTUALNY STAN FLOTY

                          System.out.println("------ Lista samolotów: ------");
                          for (int i = 0; i < samoloty.size(); i++)
                              System.out.println(i + 1 + ". " + samoloty.get(i).toString());    // AKTUALNY STAN FLOTY (WYSZCZEGOL.)
                          System.out.println("------------------------------");

                          System.out.println("1. Dodaj samolot");   // DRZEWKO DECYZYJNE
                          System.out.println("2. Usun samolot");
                          System.out.println("3. Wstecz");
                          System.out.println("Opcja: ");
                          try
                          {
                              w = scanner.nextInt();
                          }
                          catch (InputMismatchException a)  // WYJATEK
                          {
                              System.out.println("\nPodaj numer opcji do wykonania!\n");
                          }

                          switch (w) {
                              case 1://                               dodawanie samolotu

                                  String model = "";        // PODSTAWOWE PARAMETRY SAMOLOTU
                                  String id = "";           // AIRBUSY NP. ZACZYNAJA SIE NA "A", WYMUSZA TO STRING
                                  String typ;           // ARBITRALNIE NARZUCONE PARAMETRY A, B, C, D


                                  while (model.equals("")) {
                                      System.out.print("Podaj model: ");    // DODAWANIE MODELU
                                      model = scanner.next();
                                  }
                                  do {
                                      System.out.print("Podaj id: ");   // DODAWANIE ID
                                      id = scanner.next();

                                  } while (idCheck(id, samoloty));

                                  do {
                                      System.out.print("Podaj typ (TypA, TypB, TypC, TypD): ");
                                      typ = scanner.next();
                                                                    // DODAWANIE TYPU
                                      if (typ.equals("TypA") || typ.equals("TypB") || typ.equals("TypC") || typ.equals("TypD")) {
                                          break;
                                      } else {
                                          System.out.println("Podaj właściwy typ samolotu!"); // USER PODAL ZLY
                                      }

                                  } while (true);
                                            // PRZESZLISMY PRZEZ ETAP WERYFIKUJACY POPRAWNOSC (typy: A, B, C, D)
                                  if (typ.equals("TypA")) {     // GDY DANY TYP - DODAJ NOWY SAMOLOT TYP odpowiednio: A, B, C, D
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
                                  int toRemove = scanner.nextInt();     // NUMER INDEKSU, OST EL. LISTY [MAX-1]
                                  samoloty.remove(toRemove - 1);
                                  break;

                              case 3://                       exit - POZIOM WYZEJ
                                  break;
                          }


                      } while (w != 3);             // PONOWNIE POWROT PIETRO WYZEJ
                      break;

                  case 3:                                    //lotniska
                      int w1=0;

                      do {
                          System.out.println("Ilość lotnisk w bazie: " + lotniska.size()); // STAN AKTUALNY
                                    // WYSZCZEGOLNIENIE
                          System.out.println("------ Lista wszystkich lotnisk dostępnych w bazie: ------");
                          for (int i = 0; i < lotniska.size(); i++) {
                              System.out.println(i + 1 + ". " + lotniska.get(i).toString());
                          }
                          System.out.println("----------------------------------------------------------");

                          System.out.println("1. Dodaj nowe lotnisko"); // DRZEWKO DECYZYJNE
                          System.out.println("2. Usuń lotnisko");
                          System.out.println("3. Wstecz");
                          System.out.println("Opcja: ");
                          try
                          {
                              w1 = scanner.nextInt();
                          }
                          catch (InputMismatchException a)  // WYJATEK
                          {
                              System.out.println("\nPodaj numer opcji do wykonania!\n");
                          }

                          switch (w1) {

                              case 1:
                                  System.out.print("Podaj kraj: "); // DODAJEMY LOTNISKO W KRAJU, MIESCIE
                                  String kraj = scanner.next();
                                  System.out.print("Podaj miasto: ");
                                  String m = scanner.next();
                                            // W PRZYSZLOSCI ROZSZERZENIE O KOORDY. GEOGRAFICZNE DO AUTOMATYCZNYCH ODLEGLOSCI
                                  lotniska.add(new Lotnisko(kraj, m));

                                  break;

                              case 2:
                                  System.out.println("Podaj numer indeksu lotniska które chcesz usunąć");
                                  int c = scanner.nextInt();
                                  lotniska.remove(c-1);     // [MAX-1] TO OSTATNI NUMER
                                  break;

                              case 3:
                                  break;            // PIETRO WYZEJ
                          }

                      } while (w1 != 3);            // PIETRO WYZEJ

                      break;
                  case 4:
                      int x=0;                               //loty
                      do {
                          System.out.println("Liczba dostepnych lotow: " + loty.size());    // AKTUALNY STAN POLACZEN

                          System.out.println("------ Lista wszystkich dostępnych lotów: ------"); //zrobione


                      for (int i = 0; i < loty.size(); i++) {
                              System.out.println(i + 1 + ". " + loty.get(i).toString());    // WYSTWIETLANIE AKTUALNYCH
                          }
                          System.out.println("------------------------------------------------");

                          System.out.println("1. Dodaj lot na trasie.");    // DRZEWKO DECYZYJNE
                          System.out.println("2. Anuluj lot.");
                          System.out.println("3. Wstecz.");
                          System.out.println("Wybór: ");
                          try
                          {
                              x = scanner.nextInt();
                          }
                          catch (InputMismatchException a)      // WYJATEK
                          {
                              System.out.println("\nPodaj numer opcji do wykonania!\n");
                          }

                          switch(x) {
                              case 1: //dodaj lot
                                  if (trasy.size() < 1) {
                                      System.out.println("Niewystarczająca ilość tras.");   // ZA MALO TRAS
                                      break;
                                  }

                                  System.out.println("Wybierz trasę na której chcesz dodać lot: ");
                                  System.out.println("------ Lista dostępnych tras: ------");
                                  for (int i = 0; i < trasy.size(); i++) {      // WYSWIETL AKTUALNA LISTE TRAS
                                      System.out.println(i + 1 + ". " + trasy.get(i).toString());
                                  }
                                  System.out.println("------------------------------------");

                                  System.out.println("Wybór: ");    // USER WYBIERA NUMER Z TRASA OD-DO
                                  int g = scanner.nextInt();

                                  if(g > trasy.size())          // ZLY NUMER
                                  {
                                      System.out.println("\nBłąd indeksu! Spróbuj ponownie.\n");
                                  }
                                  else
                                  {
                                      Trasa t = trasy.get(g-1);
                                      float odl = t.getDlugosc();   // NIE KAZDY SAMOLOT MOZE PODROZOWAC PO TRASIE

                                      int j =0;
                                      System.out.println("------ Lista samolotow obsugujacych ten dystans: ------");
                                      for (int i = 0; i < samoloty.size(); i++)
                                      {

                                          if(odl <= samoloty.get(i).getZasieg())        // MOZNA LATAC, GDY DYSTANS POZWALA
                                          {
                                              System.out.println(j + 1 + ". " + samoloty.get(i).toString());
                                              j++;
                                          }

                                      }

                                      if(j==0)          // GDY NIE MA STATKOW POWIETRZNYCH UCIEKAMY
                                      {
                                          System.out.println("\nBrak dostepnych samolotow\n");
                                          break;
                                      }

                                      System.out.println("------------------------------------");

                                      System.out.println("Wybierz numer samolotu: ");       // PODAJ PARAMETRY
                                      System.out.print("Wybor:  ");
                                      int in = scanner.nextInt();

                                      int rodzaj;

                                      do {
                                          System.out.println("1. Zwykly lot ");         // DODATKOWE INFORMACJE
                                          System.out.println("2. Cotygodniowy lot");
                                          System.out.println("3. Codzienny lot");
                                          System.out.print("Wybor:  ");
                                          rodzaj = scanner.nextInt();
                                      }while (rodzaj!=1 && rodzaj!=2 && rodzaj!=3);



                                      if(rodzaj!=1 && rodzaj!=2 && rodzaj!=3) { System.out.println("\nBłAD\n"); break; }
                                      else if(rodzaj == 1)
                                      {
                                          Lot lot = new Lot();
                                          lot.setTrasa(t);
                                          lot.setSamolot(samoloty.get(in-1));
                                          loty.add(lot);            // DODAJEMY LOTY NA WYBRANEJ TRASIE
                                          break;
                                      }
                                      else if(rodzaj==2)
                                      {
                                          LotCotygodniowy lot = new LotCotygodniowy();
                                          lot.setTrasa(t);
                                          lot.setSamolot(samoloty.get(in-1));
                                          loty.add(lot);
                                          break;
                                      }
                                      else if(rodzaj == 3)
                                      {
                                          LotCodzienny lot = new LotCodzienny();
                                          lot.setTrasa(t);
                                          lot.setSamolot(samoloty.get(in-1));
                                          loty.add(lot);
                                          break;
                                      }


                                  }
                                    break;

                              case 2:   //anuluj lot
                                  System.out.println("------ Lista wszystkich dostępnych lotów: ------"); //zrobione

                                  for (int i = 0; i < loty.size(); i++) {   // STAN AKTUALNY
                                      System.out.println(i + 1 + ". " + loty.get(i).toString());
                                  }
                                  System.out.println("------------------------------------------------");
                                  System.out.print("Nr lotu do usuniecia: ");
                                  int nr = scanner.nextInt();       // PODAJ INDEKS DO USUNIECIA [MAX-1] OSTATNI

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
                      break;

                  case 5:
                      int z=0;                                  //trasy
                      do
                      {
                          System.out.println("Ilość dostępnych tras: " + trasy.size());
                          System.out.println("------ Lista dostępnych tras: ------");   // AKTUALNA SIATKA POLACZEN
                          for (int i = 0; i < trasy.size(); i++) {
                              System.out.println(i + 1 + ". " + trasy.get(i).toString());
                          }
                          System.out.println("------------------------------------");


                          System.out.println("1. Dodaj nowe połączenie.");                  // DRZEWKO DECYZYJNE
                          System.out.println("2. Wycofaj połączenie pomiędzy lotniskami.");
                          System.out.println("3. Wstecz.");
                          System.out.println("Wybór: ");
                          try
                          {
                              z = scanner.nextInt();
                          }
                          catch (InputMismatchException a)  // WYJATEK
                          {
                              System.out.println("\nPodaj numer opcji do wykonania!\n");
                          }

                          switch(z) {
                              case 1:
                                  if (lotniska.size() == 0) {       // BRAK LOTNISK
                                      System.out.println("Brak dostępnych lotnisk.");
                                      break;
                                  }
                                  for (int i = 0; i < lotniska.size(); i++) {
                                      System.out.println(i + 1 + ". " + lotniska.get(i).toString());
                                  }

                                  System.out.print("Wybierz nr lotniska wylotu: ");         // PODAWANIE TRASY OD-DO
                                  int wylot = scanner.nextInt();
                                  System.out.print("Wybierz nr lotniska przylotu: ");       // PODAWANIE TRASY OD-DO
                                  int cel = scanner.nextInt();

                                  if (wylot > lotniska.size() || cel > lotniska.size()) {
                                      System.out.println("\nBłąd indeksu! Spróbuj ponownie.\n");        // BLEDNE DANE
                                  } else {
                                      trasy.add(new Trasa(lotniska.get(wylot - 1), lotniska.get(cel - 1)));
                                      break;
                                  }

                              case 2:
                                  for (int i = 0; i < trasy.size(); i++) {  // KASOWANIE
                                      System.out.println(i + 1 + ". " + trasy.get(i).toString());
                                  }

                                  System.out.print("Wybierz nr trasy do usuniecia: ");
                                  int nr = scanner.nextInt();       // OSTATNI NR TO [MAX-1]

                                  if(nr > trasy.size()){
                                      System.out.println("\nBłąd indeksu! Spróbuj ponownie.\n"); // TUTAJ ZLY NUMER
                                  }
                                  else {
                                      trasy.remove(nr-1);       // USUWAM
                                  }

                                  break;            // UCIECZKA Z PETLI

                              case 3:
                                  break;    // UCIECZKA Z PETLI NA POPRZEDNI POZIOM
                          }

                      }while (z!=3);

                      break;        // UCIECZKA DO GLOWNEGO MENU

                  case 6:     ////////////////////////REZERWACJE////////////////////////////
                    int a = 0;
                    do {
                        System.out.println("1. Dodaj nową rezerwację. ");         // DRZEWKO DECYZYJNE
                        System.out.println("2. Sprawdź ilość rezerwacji na danym locie. ");
                        System.out.println("3. Usuń rezerwację. ");
                        System.out.println("4. Wstecz.");
                        System.out.println("Wybor: ");

                        try
                        {
                            a = scanner.nextInt();
                        }
                        catch (InputMismatchException ex)       // WYJATEK
                        {
                            System.out.println("\nPodaj właściwy numer opcji do wykonania!\n");
                        }


                        switch(a) {
                            case 1:                 //dadawanie rezerwacji
                                if(klienci.size() < 1) {System.out.println("Brak klientow"); break; } // SYT. SZCZEGOLNA, BRAK KLIENTOW

                                System.out.println("Wybierz klienta rezerwującego lot: ");  //WYSWIETLANIE LISTY KLIENTOW
                                System.out.println("-------------------------------------");
                                for (int i = 0; i < klienci.size(); i++) {
                                    System.out.println(i + 1 + ". " + klienci.get(i).toString());
                                }
                                System.out.println("-------------------------------------");
                                System.out.println("Wybór: ");
                                int q = scanner.nextInt(); //numer klienta

                                if(loty.size() < 1) {System.out.println("Brak lotow"); break; } // BLAD DOT. LOTOW
                                System.out.println("Wybierz numer lotu na którym chcesz dokonać rezerwacji. "); // PODAJ NUMER LOTU
                                System.out.println("-------------------------------------");

                                int k=0;

                                for(int i=0;i< loty.size();i++)
                                {
                                    System.out.println(i + 1 + ". " + loty.get(i).toString());
                                }
                                /*
                                for (Lot lot : loty) {

                                    System.out.println(k + 1 + ". " + lot.toString());
                                    k++;
                                }

                                 */
                                System.out.println("-------------------------------------");
                                int f = scanner.nextInt(); //numer lotu

                                int numerBiletu = generator.nextInt(41000);     // NUMER PSEUDOLOSOWY

                               // Iterator it = numeryBiletow.iterator();
                                boolean istniejeNumer = true;

                                if(bilety.size()!=0)
                                {
                                    for(int i=0;i<=bilety.size();i++)
                                    {
                                        if(bilety.get(i).getId()==numerBiletu)
                                        {
                                            numerBiletu = generator.nextInt(41000);
                                        }
                                        else
                                        {
                                            istniejeNumer=false;
                                        }
                                    }

                                }



/*
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

 */
                                System.out.println("Twój numer biletu: " + numerBiletu); // INFO O BILECIE
                                //System.out.println(numerBiletu);

                                int wyborKlasy = 0;
                                boolean wyborKlasyOk = false;
                                while (!wyborKlasyOk) {
                                    System.out.println("Wybierz klasę: ");      // WYBOR KLASY (OGRANICZONA LICZBA MIEJSC DLA KAZDEJ Z NICH)
                                    System.out.println("1. Pierwsza Klasa: " + loty.get(f-1).getSamolot().getMiejscaPierwszaKl() + " wolnych miejsc");
                                    System.out.println("2. Biznesowa: " + loty.get(f-1).getSamolot().getMiejscaBiznesowa() + " wolnych miejsc");
                                    System.out.println("3. Ekonomiczna: " + loty.get(f-1).getSamolot().getMiejscaEkonomiczna() + " wolnych miejsc");
                                    System.out.println("Wybór: ");
                                    wyborKlasy = scanner.nextInt(); // USER PODAJE NUMER KLASY
                                    if (wyborKlasy == 1 || wyborKlasy == 2 || wyborKlasy == 3) {
                                        wyborKlasyOk = true;
                                    } else {
                                        System.out.println("Wybierz poprawny numer klasy!");
                                    }
                                }
                                klienci.get(q - 1).setKlasa(wyborKlasy); // dodałem klasy do klienta żeby potem było wiadomo
                                int nrMiejsca;                           // z jakiej klasy zwolnić miejsce przy usuwaniu
                                double cenaBiletu;                       // rezerwacji

                                switch (wyborKlasy) {   // GDY WYBOR KLASY TO 1, 2, NASTEPUJE WYLICZENIA NP. CENY BILOETU
                                    case 1:
                                        if (loty.get(f-1).getSamolot().getMiejscaPierwszaKl() == 0) {
                                            System.out.println("Brak wolnych miejsc w pierwszej klasie! Wybierz inną klasę.");
                                        }
                                        nrMiejsca = loty.get(f-1).getSamolot().getMiejscaPierwszaKl();
                                        loty.get(f-1).getSamolot().zarezerwujMiejscePierwszaKl(); // liczba miejsc w samolocie -1
                                        cenaBiletu = loty.get(f-1).getSamolot().getMnoznikPierwszaKl() * loty.get(f-1).getTrasa().getDlugosc();
                                        // wyliczona cena (mnoznik klasy * długość trasy)
                                        break;
                                    case 2:
                                        if (loty.get(f-1).getSamolot().getMiejscaBiznesowa() == 0) {
                                            System.out.println("Brak wolnych miejsc w klasie biznesowej! Wybierz inną klasę.");
                                        }
                                        nrMiejsca = loty.get(f-1).getSamolot().getMiejscaBiznesowa();
                                        loty.get(f-1).getSamolot().zarezerwujMiejsceBiznesowa();
                                        cenaBiletu = loty.get(f-1).getSamolot().getMnoznikBiznesowa() * loty.get(f-1).getTrasa().getDlugosc();
                                        break;
                                    case 3:
                                        if (loty.get(f-1).getSamolot().getMiejscaEkonomiczna() == 0) {
                                            System.out.println("Brak wolnych miejsc w klasie ekonomicznej! Wybierz inną klasę.");
                                        }
                                        nrMiejsca = loty.get(f-1).getSamolot().getMiejscaEkonomiczna();
                                        loty.get(f-1).getSamolot().zarezerwujMiejsceEkonomiczna();
                                        cenaBiletu = loty.get(f-1).getSamolot().getMnoznikEkonomiczna() * loty.get(f-1).getTrasa().getDlugosc();
                                        break;
                                    default:
                                        cenaBiletu = 0;
                                        nrMiejsca = 0;
                                        break;
                                }

                                System.out.println("Cena biletu wynosi " + cenaBiletu + "zł");
                                loty.get(f-1).addKlient(klienci.get(q-1)); //dodany klient do lotu
                                bilety.add(new Bilet(cenaBiletu, nrMiejsca, numerBiletu)); //dodany nowy bilet do listy
                                rezerwacje.add(new Rezerwacja(bilety.get(bilety.size()-1), loty.get(f-1))); //dodana nowa rezerwacja do listy
                                klienci.get(q - 1).addRezerwacja(new Rezerwacja(bilety.get(bilety.size()-1), loty.get(f-1))); //dodana rezerwacja do klienta
                                break;
                            case 2:         // CZESC DLA WYSWIETLANIA REZERWACJI
                                System.out.println("------ Wybierz lot z listy: ------");
                                for (int i = 0; i < loty.size(); i++) {
                                    System.out.println(i + 1 + ". " + loty.get(i).toString());  // WYBIERANIE LOTU
                                }
                                System.out.println("----------------------------------");
                                int d = scanner.nextInt();

                                if(loty.get(d-1).getKlienci().size()==0)
                                {
                                    System.out.println("Brak rezerwacji na ten lot");   // GDY PUSTO
                                    break;
                                }
                                else {System.out.println(loty.get(d - 1).getKlienci().toString()); }

                                break;
                            case 3:         // KASOWANIE REZERWACJI
                                System.out.println("Wybierz numer lotu na którym chcesz usunąć rezerwację: ");

                                for (int i = 0; i < loty.size(); i++) { // WYSWIETL LISTE
                                    System.out.println(i + 1 + ". " + loty.get(i).toString());
                                }
                                System.out.println("Wybór: ");
                                int nrlotu = scanner.nextInt(); //numer lotu

                                System.out.println("Wybierz numer klienta: ");


                                for (int i = 0; i < loty.get(nrlotu - 1).getKlienci().size(); i++) {
                                    System.out.println(i + 1 + ". " + loty.get(nrlotu - 1).getKlienci().get(i).toString());
                                }
                                int nrklienta = scanner.nextInt(); //numer klienta z lotu(ale nie id)

                                switch (loty.get(nrlotu - 1).getKlient(nrklienta - 1).getKlasa()) {
                                    case "Biznesowa" -> {
                                        if (loty.get(nrlotu - 1).getSamolot().getMiejscaBiznesowa() <
                                                loty.get(nrlotu - 1).getSamolot().getMiejscaBiznesowaMax()) {
                                            loty.get(nrlotu - 1).getSamolot().zwolnijMiejsceBiznesowa();
                                        } else {
                                            System.out.println("Maksymalna ilosc miejsc");
                                        }
                                    }
                                    case "Ekonomiczna" -> {
                                        if (loty.get(nrlotu - 1).getSamolot().getMiejscaEkonomiczna() <
                                                loty.get(nrlotu - 1).getSamolot().getMiejscaEkonomicznaMax()) {
                                            loty.get(nrlotu - 1).getSamolot().zwolnijMiejsceEkonomiczna();
                                        } else {
                                            System.out.println("Maksymalna ilosc miejsc");
                                        }
                                    }
                                    case "Pierwsza" -> {
                                        if (loty.get(nrlotu - 1).getSamolot().getMiejscaPierwszaKl() <
                                                loty.get(nrlotu - 1).getSamolot().getMiejscaPierwszaKlMax()) {
                                            loty.get(nrlotu - 1).getSamolot().zwolnijMiejscePierwszaKl();
                                        } else {
                                            System.out.println("Maksymalna ilosc miejsc");
                                        }
                                    }
                                }    //zwalnianie miejsca w odpowiedniej klasie
                                List<Rezerwacja> r = loty.get(nrlotu - 1).getKlient(nrklienta - 1).getRezerwacje();



                                int bilet=0;

                                for(int i=0;i<r.size();i++)
                                {
                                    bilet = r.get(i).getBilet().getId();
                                }

                                for(int i=0;i<bilety.size();i++)
                                {
                                    if(bilety.get(i).getId() == bilet)
                                    {
                                        bilety.remove(i);
                                        for(int j=0;j<rezerwacje.size();j++)
                                        {
                                            if(rezerwacje.get(i).getBilet().getId()==bilet)
                                            {
                                                rezerwacje.remove(j);
                                            }
                                        }
                                    }
                                }

                                loty.get(nrlotu - 1).getKlient(nrklienta - 1).deleteRezerwacja(); //usuwanie rezerwacji u klienta
                                loty.get(nrlotu - 1).getKlienci().remove(nrklienta - 1); //usuwanie klienta z lotu

/*
                                for (int i = 0; i < bilety.size(); i++) {
                                    for (int j = 0; j < rezerwacje.size(); j++) {
                                        if (bilety.get(i).getId() == rezerwacje.get(j).getBilet().getId()) {
                                            bilety.remove(i); //usuwanie biletu z listy biletow
                                            rezerwacje.remove(j); //usuwanie rezerwacji z listy rezerwacji
                                        }
                                    }
                                }

 */
                                break;
                        }

                    } while (a != 4);

                    break;


                  case 7: //                               zapisz lub otwórz stan systemu

                      int wybor=0;

                      do
                      {

                          System.out.println("1. Zapisz dane do pliku txt");
                          System.out.println("2. Otwórz dane z pliku txt");
                          System.out.println("3. Wstecz");
                          System.out.print("Opcja: ");
                          try
                          {
                              wybor = scanner.nextInt();
                          }
                          catch (InputMismatchException aa) //WYJATEK
                          {
                              System.out.println("\nPodaj numer opcji do wykonania!\n");
                          }

                          switch (wybor)
                          {
                              case 1: //zapisz



                                  if(trasy.size() == 0 && loty.size() == 0 && lotniska.size() == 0
                                          && samoloty.size() == 0 && klienci.size() == 0 )
                                  {
                                      System.out.println("\nBrak danych w systemie!\n"); // GDY NIE MA NIC
                                      break;
                                  }
                                  else
                                  {
                                      System.out.print("Podaj nazwe i sciezke do pliku : ");
                                      String sciezkaPlik = scanner.next();


                                      PrintWriter zapis = new PrintWriter(sciezkaPlik);

                                      //lotniska
                                      zapis.println("LOTNISKA");

                                      for(int i=0; i< lotniska.size(); i++)
                                      {
                                          zapis.println(lotniska.get(i).toString());
                                      }

                                      //trasy
                                      zapis.println("TRASY");

                                      for(int i=0; i< trasy.size(); i++)
                                      {
                                          zapis.println(trasy.get(i).getBaza().toString() +
                                                ";" + trasy.get(i).getCel().toString());

                                      }


                                      //samoloty
                                      zapis.println("SAMOLOTY");

                                      for(int i=0; i< samoloty.size(); i++)
                                      {
                                          Samolot obecny = samoloty.get(i);
                                         zapis.println(obecny.type + " " + obecny.getModel() + ";" +
                                                  obecny.getId());

                                      }

                                      //klienci
                                      zapis.println("KLIENCI");

                                      for(int i=0; i< klienci.size(); i++)
                                      {
                                            zapis.println(klienci.get(i).type+";"+klienci.get(i).toString());

                                      }

                                      //loty
                                      zapis.println("LOTY");
                                      for(int i=0; i< loty.size(); i++)
                                      {
                                          zapis.println(loty.get(i).type+"!"+loty.get(i).getTrasa().getBaza().toString()
                                          + ";" + loty.get(i).getTrasa().getCel().toString()+"#"+loty.get(i).getSamolot().type
                                          +" "+loty.get(i).getSamolot().getModel()+";"+loty.get(i).getSamolot().getId());

                                      }


                                      //koniec EOF
                                      zapis.println("KONIEC");
                                      zapis.close();

                                      System.out.println("-------------------------------------");
                                      System.out.println("DANE ZAPISANE W " + sciezkaPlik);
                                      System.out.println("-------------------------------------");

                                  }

                                  break;


                            //zalożenie jest takie, że wszystkie dane zostały wprowadzone w programie i nie ma
                              // potrzeby sprawdzenia ich poprawności
                              case 2: //otwórz

                                  String plik;
                                  List<String> linia = new LinkedList<>();
                                  String nazwa = "";
                                  String slowo = "";
                                  String tmp="";

                                  System.out.print("Nazwa sciezka do pliku z danymi: ");
                                  plik = scanner.next();



                                  System.out.println("-------------------------------------");
                                  System.out.println("Wczytywanie danych z  " + plik);
                                  System.out.println("-------------------------------------");

                                  /*  Wczytywanie  */
                                  Scanner s;

                                  try
                                  {
                                       s = new Scanner(new FileInputStream(plik));
                                  }
                                  catch (FileNotFoundException ef)
                                  {
                                      System.out.println("\nBlad! Brak takiego pliku!\n");
                                      break;
                                  }



                                      while (s.hasNextLine()) {
                                          nazwa = s.nextLine();




                                          if (nazwa.equals("LOTNISKA")) {
                                              while (!nazwa.equals("TRASY")) {
                                                  nazwa = s.nextLine();
                                                  if (nazwa.equals("TRASY")) {
                                                      break;
                                                  }
                                                  String[] line = nazwa.split(" ");
                                                  String miasto = line[0];
                                                  String kraj = line[1];
                                                  lotniska.add(new Lotnisko(kraj, miasto));


                                              }

                                          }
                                          if (nazwa.equals("LOTNISKA")) {
                                              while (!nazwa.equals("TRASY")) {
                                                  nazwa = s.nextLine();
                                                  if (nazwa.equals("TRASY")) {
                                                      break;
                                                  }
                                                  String[] line = nazwa.split(" ");
                                                  String miasto = line[0];
                                                  String kraj = line[1];
                                                  lotniska.add(new Lotnisko(kraj, miasto));


                                              }

                                          }
                                          if (nazwa.equals("TRASY")) {
                                              while (!nazwa.equals("SAMOLOTY")) {
                                                  nazwa = s.nextLine();
                                                  if (nazwa.equals("SAMOLOTY")) {
                                                      break;
                                                  }
                                                  String[] line = nazwa.split(";");

                                                  String[] pierwsze = line[0].split(" ");
                                                  String[] drugie = line[1].split(" ");

                                                  Lotnisko baza = null;
                                                  Lotnisko cel = null;


                                                  for (int i = 0; i < lotniska.size(); i++) {
                                                      Lotnisko obecne = lotniska.get(i);

                                                      if (obecne.getMiasto().equals(pierwsze[0])) {
                                                          baza = lotniska.get(i);
                                                      } else if (obecne.getMiasto().equals(drugie[0])) {
                                                          cel = lotniska.get(i);
                                                      }
                                                  }

                                                  if (baza != null && cel != null) {
                                                      trasy.add(new Trasa(baza, cel));
                                                  }
                                              }


                                          }
                                          if (nazwa.equals("SAMOLOTY")) {
                                              while (!nazwa.equals("KLIENCI")) {
                                                  nazwa = s.nextLine();
                                                  if (nazwa.equals("KLIENCI") || !s.hasNextLine()) {
                                                      break;
                                                  }
                                                  String[] line = nazwa.split(" ");

                                                  String typ = line[0];
                                                  String[] dane = line[1].split(";");
                                                  String model = dane[0];
                                                  String id = dane[1];

                                                  if (typ.equals("TypA")) {
                                                      TypA samolot = new TypA(id, model);
                                                      samoloty.add(samolot);
                                                  }
                                                  if (typ.equals("TypB")) {
                                                      TypB samolot = new TypB(id, model);
                                                      samoloty.add(samolot);
                                                  }
                                                  if (typ.equals("TypC")) {
                                                      TypC samolot = new TypC(id, model);
                                                      samoloty.add(samolot);
                                                  }
                                                  if (typ.equals("TypD")) {
                                                      TypD samolot = new TypD(id, model);
                                                      samoloty.add(samolot);
                                                  }

                                              }

                                          }
                                          if (nazwa.equals("KLIENCI")) {
                                              while (!nazwa.equals("LOTY")) {
                                                  nazwa = s.nextLine();
                                                  if (nazwa.equals("LOTY") || !s.hasNextLine()) {
                                                      break;
                                                  }
                                                  String[] line = nazwa.split(";");
                                                  String typ = line[0];
                                                  if(typ.equals("Osoba") || typ.equals("OsobaVip"))
                                                  {
                                                      String[] dane = line[1].split(" ");
                                                      String imie = dane[0];
                                                      String nazwisko = dane[1];
                                                      if(typ.equals("Osoba")) { klienci.add(new Osoba(imie,nazwisko)); }
                                                      if(typ.equals("OsobaVip")) { klienci.add(new OsobaVip(imie,nazwisko)); }

                                                  }
                                                  else if(typ.equals("Posrednik") || typ.equals("Korporacja"))
                                                  {
                                                      String nazwaFirmy = line[1];
                                                      if(typ.equals("Posrednik")) { klienci.add(new Posrednik(nazwaFirmy)); }
                                                      if(typ.equals("Korporacja")) { klienci.add(new Korpo(nazwaFirmy)); }
                                                  }


                                              }

                                          }
                                          if (nazwa.equals("LOTY")) {
                                              while (!nazwa.equals("KONIEC")) {
                                                  nazwa = s.nextLine();
                                                  if (nazwa.equals("KONIEC")) {
                                                      break;
                                                  }
                                                  String[] line = nazwa.split("#");
                                                  String trasa = line[0];

                                                  String[] trasaDane = trasa.split(";");
                                                  String[] trasaDane2 = trasaDane[0].split("!");
                                                  String typ = trasaDane2[0];

                                                  String[] lotniskoOD = trasaDane2[1].split(" ");
                                                  String[] lotniskDO = trasaDane[1].split(" ");

                                                  String miastoOD = lotniskoOD[0];
                                                  String miastoDO = lotniskDO[0];

                                                  String[] samolotDane = line[1].split(";");
                                                  String samolotID = samolotDane[1];
                                                  Samolot samolot =null;
                                                  Trasa trasa1=null;

                                                  for(int i=0;i< samoloty.size(); i++)
                                                  {
                                                      if(samoloty.get(i).getId().equals(samolotID))
                                                      {
                                                          samolot = samoloty.get(i);
                                                      }
                                                  }
                                                  for(int i=0;i< trasy.size(); i++)
                                                  {
                                                      if(trasy.get(i).getBaza().getMiasto().equals(miastoOD) &&
                                                              trasy.get(i).getCel().getMiasto().equals(miastoDO))
                                                      {
                                                         trasa1 = trasy.get(i);
                                                      }
                                                  }
                                                  if(typ.equals("CT"))
                                                  {
                                                      LotCotygodniowy lct = new LotCotygodniowy();
                                                      lct.setSamolot(samolot);
                                                      lct.setTrasa(trasa1);
                                                      loty.add(lct);
                                                  }
                                                  else if(typ.equals("CD"))
                                                  {
                                                      LotCodzienny lcd = new LotCodzienny();
                                                      lcd.setSamolot(samolot);
                                                      lcd.setTrasa(trasa1);
                                                      loty.add(lcd);
                                                  }
                                                  else
                                                  {
                                                      Lot lot = new Lot();
                                                      lot.setSamolot(samolot);
                                                      lot.setTrasa(trasa1);
                                                      loty.add(lot);
                                                  }

                                              }
                                          }

                                      }

                                  System.out.println("-------------------------------------");
                                  System.out.println("Wczytano dane z  " + plik);
                                  System.out.println("-------------------------------------");


                                  break;

                              case 3: //wstecz
                                  break;
                          }


                      }while(wybor!=3);

                      break;

                  case 8:
                      break;//exit
              }

        } while (e != liczbaOpcji);

    }
}
