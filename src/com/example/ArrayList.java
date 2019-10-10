package com.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;


/**
 * Programmet handlar om att lägga till böcker , uppdatera och ta bort böcker samt ljudböcker
 * i programmet kan man även lägga till favorit och även visa böcker samt ljudböcker
 * samt om det är favorit .
 * @author  Tarik Freih
 * @version 1.0
 * @since   2019-10-10
 */

public class ArrayList {

    private static  Scanner scanner = new Scanner(System.in);
    private static Biblotek biblotek = new Biblotek();




    public static void main(String[] args) {



        boolean quit = false;
        hyrBok();
        printActions();
        while (!quit) {
            System.out.println("\nVälj: 8 för att visa val");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nStänger ner. . . ");
                    quit = true;
                    break;

                 case 1:
                    biblotek.printBokLista();
                    break;


                case 2:
                    addNewBok();
                    break;

                case 3:
                   addNewLjudBok();
                   break;

                case 4:
                    uppdateraBok();
                    break;

                case 5:
                    uppdateraLjudBok();
                    break;


                case 6:
                    removeBok();
                    break;

                case 7:
                    removeLjudBok();
                    break;



                case 8:
                    printActions();
                    break;



            }

        }


        
    }
    /**
     * Lägger till bok samt kontrollerar att den inte finns.
     */
    private static void addNewBok() {
        System.out.println("Skriv in namnet på din bok: ");
        String name = scanner.nextLine();
        System.out.println("Skriv in boknummer: ");
        String boknr = scanner.nextLine();

        Bok newBok = Bok.createBok(name, boknr);
        if (biblotek.addNewBok(newBok)) {
            System.out.println("Ny bok har lagts till: Namn: " + name + ",\n Boknummer: " + boknr);
        } else {
            System.out.println("Kan inte lägga till, " + name + " finns redan. ");
        }


    }


    /**
     * Lägger till ljudbok samt kontrollerar att den inte finns.
     */



    private static void addNewLjudBok() {
        System.out.println("Skriv in namnet på din Ljud bok: ");
        String name = scanner.nextLine();
        System.out.println("Skriv in boknummer: ");
        String boknr = scanner.nextLine();
        System.out.println("Skriv in ljudsprak: ");
        String ljudsprak = scanner.nextLine();

        LjudBok newLjudBok = LjudBok.createLjudBok(name, boknr, ljudsprak);
        if (biblotek.addNewLjudBok(newLjudBok)) {
            System.out.println("Ny bok har lagts till, Namn: " + name + "\n Boknummer: " + boknr + "\nLjudspråk: " + ljudsprak);
        } else {
            System.out.println("Kan inte lägga till, " + name + " finns redan. ");
        }

    }

    /**
     * Hämtar tillagd bok för att uppdatera den samt här lägger man till som favorit
     */

    private static void uppdateraBok(){
        System.out.println("Skriv in namnet på boken som skall uppdateras:");
        String name = scanner.nextLine();
        Bok existingBokRecord = biblotek.queryBok(name);
        if(existingBokRecord == null) {
            System.out.println("Kan inte hitta bok.");
            return;
        }

        System.out.println("Skriv in nytt namn för boken: ");
        String newName = scanner.nextLine();
        System.out.println("Skriv in nytt boknummer");
        String newNr = scanner.nextLine();
        Bok newBok = Bok.createBok(newName, newNr);
        if (biblotek.updateBok(existingBokRecord, newBok)) {
            System.out.println("Boken är uppdaterad!");
        } else {
            System.out.println("Gick inte att uppdatera");
        }

    }


    /**
     * Hämtar tillagd ljudbok för att uppdatera.
     */


    private static void uppdateraLjudBok(){
        System.out.println("Skriv in namnet på boken som skall uppdateras:");
        String name = scanner.nextLine();
        LjudBok existingLjudBokRecord = biblotek.queryLjudBok(name);
        if(existingLjudBokRecord == null) {
            System.out.println("Kan inte hitta Ljudbok.");
            return;
        }

        System.out.println("Skriv in nytt namn för boken: ");
        String newName = scanner.nextLine();
        System.out.println("Skriv in nytt boknummer");
        String newNr = scanner.nextLine();
        System.out.println("Skriv in nytt språk");
        String newljudsprak = scanner.nextLine();
        LjudBok newLjudBok = LjudBok.createLjudBok(newName, newNr, newljudsprak);
        if (biblotek.uppdateraLjudBok(existingLjudBokRecord, newLjudBok)) {
            System.out.println("Boken är uppdaterad!");
        } else {
            System.out.println("Gick inte att uppdatera");
        }

    }

    /**
     * Letar efter bok som är tillagd för att radera bok.
     */



    private static void removeBok () {
        System.out.println("Skriv in namnet på boken som skall tas bort:");
        String name = scanner.nextLine();
        Bok existingBokRecord = biblotek.queryBok(name);
        if (existingBokRecord == null) {
            System.out.println("Kan inte hitta boken");
            return;
        }


        if (biblotek.removeBok(existingBokRecord)) {
            System.out.println("Boken har tagits bort!");
        }else {
            System.out.println("Kan inte ta bort boken.");
        }
    }

    /**
     * letar efter ljudbok för att radera ljudbok
     */



    private static void removeLjudBok () {
        System.out.println("Skriv in namnet på ljudboken som skall tas bort:");
        String name = scanner.nextLine();
        LjudBok existingLjudBokRecord = biblotek.queryLjudBok(name);
        if (existingLjudBokRecord == null) {
            System.out.println("Kan inte hitta ljudboken");
            return;
        }


        if (biblotek.removeLjudBok(existingLjudBokRecord)) {
            System.out.println("Boken har tagits bort!");
        }else {
            System.out.println("Kan inte ta bort boken.");
        }
    }





   /*  private static void printBokLista() {
         System.out.println();
     }*/


    /**
     *  Lista med val för olika alternativ
     */

    private static void hyrBok() {System.out.println("Hyrbok. . .");}

    private static void printActions() {
        System.out.println("\nVälj: \n");
        System.out.println("0   - Stäng av\n" +
                "1   - Visa böcker\n" +
                "2   - Lägg till ny bok\n" +
                "3   - Lägg till ny ljudbok\n" +
                "4   - Uppdatera bok\n" +
                "5   - Uppdatera ljudbok\n" +
                "6   - Ta bort bok\n" +
                "7   - Ta bort ljudbok\n" +
                "8   - Visa lista över alla val");

        //  "8   - Visa favorit\n" +
    }


}