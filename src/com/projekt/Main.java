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
        System.out.println("4. Zarządzaj lotami"); //done
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
        //List <String> listaMiast = new ArrayList<>();
        LinkedList numeryBiletow = new LinkedList();                               
        Random generator = new Random();                                           



        String nazwaPliku = "ListaMiast.txt";
     //    File plik = new File("ListaMiast.txt");
      //  List<String> miasto = Files.readAllLines(Paths.get("ListaMiast.txt"));


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
            catch (InputMismatchException a)
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
                              System.out.println(i + 1 + ". " + klienci.get(i).toString());
                          }
                          System.out.println("---------------------------------");
                          System.out.println("1. Dodaj klienta."); //zrobione
                          System.out.println("2. Usuń klienta.");
                          System.out.println("3. Wstecz.");
                          System.out.println("Opcja: ");

                          try
                          {
                              w2 = scanner.nextInt();
                          }
                          catch (InputMismatchException a)
                          {
                              System.out.println("\nPodaj numer opcji do wykonania!\n");
                          }

                          switch (w2) {

                              case 1: //                        dodaj klienta
                                  int w3=0;
                                  do {
                                      System.out.println("1. Firma");
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
                                              System.out.println("1. Posrednik");
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
                                          String nazwa = scanner.next();

                                          if (w4 == 1) {
                                              klienci.add(new Posrednik(nazwa));
                                          }
                                          if (w4 == 2) {
                                              klienci.add(new Korpo(nazwa));
                                          }
                                      } else if (w3 == 2) {
                                          int w4=0;
                                          do {
                                              System.out.println("1. Zwykla osoba");
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

                      int w=0;
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
                          try
                          {
                              w = scanner.nextInt();
                          }
                          catch (InputMismatchException a)
                          {
                              System.out.println("\nPodaj numer opcji do wykonania!\n");
                          }

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
                      int w1=0;

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
                          try
                          {
                              w1 = scanner.nextInt();
                          }
                          catch (InputMismatchException a)
                          {
                              System.out.println("\nPodaj numer opcji do wykonania!\n");
                          }

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
                      int x=0;                               //loty
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
                          try
                          {
                              x = scanner.nextInt();
                          }
                          catch (InputMismatchException a)
                          {
                              System.out.println("\nPodaj numer opcji do wykonania!\n");
                          }

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
                      int z=0;                                  //trasy
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
                          try
                          {
                              z = scanner.nextInt();
                          }
                          catch (InputMismatchException a)
                          {
                              System.out.println("\nPodaj numer opcji do wykonania!\n");
                          }

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
                      int a =0;

                      do
                      {
                          System.out.println("1. Dodaj nową rezerwację. ");
                          System.out.println("2. Sprawdź ilość rezerwacji na danym locie. ");
                          System.out.println("3. Usuń rezerwację. ");
                          System.out.println("4. Wstecz ");
                          System.out.println("Wybor: ");

                          try
                          {
                              a = scanner.nextInt();
                          }
                          catch (InputMismatchException ex)
                          {
                              System.out.println("\nPodaj numer opcji do wykonania!\n");
                          }

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
                                  //dałem byle co żeby sie kompilowało
                                  //TODO cena biletu
                                  break;

                              case 2:
                                  break;

                              case 3: //out
                                  break;
                          }

                      }while(a!=4);

                      break;

                  case 7: //                               zapisz lub otwórz stan systemu

                     /*
                                ZAPIS
                                klienci
                                rezerwacje
                                trasy //done
                                loty
                                lotniska  //done


                                ODCZYT //TODO
                       */


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
                          catch (InputMismatchException aa)
                          {
                              System.out.println("\nPodaj numer opcji do wykonania!\n");
                          }

                          switch (wybor)
                          {
                              case 1: //zapisz



                                  if(trasy.size() == 0 && loty.size() == 0 && lotniska.size() == 0
                                          && samoloty.size() == 0 && klienci.size() == 0 && rezerwacje.size() == 0)
                                  {
                                      System.out.println("\nBrak danych w systemie!\n");
                                      break;
                                  }
                                  else
                                  {
                                      System.out.print("Podaj nazwe i sciezke do pliku : ");
                                      String sciezkaPlik = scanner.next();

                                      PrintWriter zapis = new PrintWriter(sciezkaPlik);

                                      //klienci
                                      zapis.println("KLIENCI");



                                      //rezerwacje
                                      zapis.println("REZERWACJE");

                                      //trasy
                                      zapis.println("TRASY");
                                      for (int i=0; i< trasy.size(); i++)
                                      {
                                          zapis.println(trasy.get(i).toString());
                                      }

                                      //loty
                                      zapis.println("LOTY");
                                      for (int i=0; i< loty.size(); i++)
                                      {
                                          Lot obecny = loty.get(i);
                                          List<Klient> k =obecny.getKlienci();
                                          zapis.println(obecny.getTrasa().toString() + " " + obecny.getSamolot().toString() + " "
                                                  + obecny.getgPodroz());

                                          for(int j=0;j<k.size();j++)
                                          {
                                              System.out.println(k.get(i).getId() + k.get(i).toString());
                                          }

                                      }

                                      //lotniska
                                      zapis.println("LOTNISKA");
                                      for(int i=0; i< lotniska.size(); i++)
                                      {
                                          zapis.println(lotniska.get(i).toString());
                                      }

                                      zapis.close();

                                      System.out.println("-------------------------------------");
                                      System.out.println("DANE ZAPISANE W " + sciezkaPlik);
                                      System.out.println("-------------------------------------");

                                  }

                                  break;

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

                                  Scanner s = new Scanner(new FileInputStream(plik));


                                      while (s.hasNextLine()){
                                          nazwa = s.nextLine();

                                            //TODO DOKONCZYC WARUNEK i IFY

                                              if(nazwa.equals("LOTNISKA"))
                                              {
                                                  while (!nazwa.equals("TRASY"))
                                                  {
                                                      nazwa = s.nextLine();
                                                      if(nazwa.equals("TRASY")) {break;}
                                                    String[] line = nazwa.split(" ");
                                                    String miasto = line[0];
                                                    String kraj = line[1];
                                                   lotniska.add(new Lotnisko(kraj,miasto));


                                                  }

                                              }
                                              if(nazwa.equals("TRASY"))
                                              {
                                                  nazwa = s.nextLine();
                                                  if(nazwa.equals("LOTNISKA")) {break;}
                                                  String[] line = nazwa.split(";");

                                                  String[] pierwsze = line[0].split(" ");
                                                  String[] drugie = line[1].split(" ");

                                                  Lotnisko baza=null;
                                                  Lotnisko cel=null;


                                                  for(int i=0;i<lotniska.size();i++)
                                                  {
                                                      Lotnisko obecne = lotniska.get(i);

                                                      if(obecne.getMiasto().equals(pierwsze[0]))
                                                      {
                                                          baza = lotniska.get(i);
                                                      }
                                                      else
                                                      if(obecne.getMiasto().equals(drugie[0]))
                                                      {
                                                          cel = lotniska.get(i);
                                                      }
                                                  }

                                                  if(baza!=null && cel!=null)
                                                  {
                                                      trasy.add(new Trasa(baza,cel));
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
