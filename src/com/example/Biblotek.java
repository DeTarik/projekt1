package com.example;



import java.util.ArrayList;

/**
 * Programmet handlar om att lägga till böcker , uppdatera och ta bort böcker samt ljudböcker
 * i programmet kan man även lägga till favorit och även visa böcker samt ljudböcker
 * samt om det är favorit .
 * @author  Tarik Freih
 * @version 1.0
 * @since   2019-10-10
 */



public class Biblotek {


    private ArrayList<Bok> minaBocker;
    private ArrayList<LjudBok> minaLjudBocker;



    public Biblotek() {
        this.minaBocker = new ArrayList<Bok>();
        this.minaLjudBocker = new ArrayList<LjudBok>();


    }

    /**
     *  Letar efter bok så att det inte finns dubbletter, Lägger till bok
     * @param bok
     * @return true or false
     */


    public boolean addNewBok(Bok bok) {
        if (findBok(bok.getName()) >= 0) {
            System.out.println("Boken är redan sparad.");
            return false;
        }

        minaBocker.add(bok);
        return true;

    }


    /**
     * Letar att det inte finns dubbletter, Lägger till ljudbok
     * @param ljudBok
     * @return true or false
     */


    public boolean addNewLjudBok(LjudBok ljudBok) {
        if (findLjudBok(ljudBok.getName()) >= 0) {
            System.out.println("Ljudboken är redan sparad.");
            return false;
        }

        minaLjudBocker.add(ljudBok);
        return true;

    }

    /**
     *  Hämtar en inlagd bok för att uppdatera info.
     * @param gammalBok
     * @param newBok
     * @return true or false
     */

    public boolean updateBok(Bok gammalBok, Bok newBok) {
        int foundPosition = findBok(gammalBok);
        if (foundPosition < 0) {
            System.out.println(gammalBok.getName() + ", gick inte att hitta");
            return false;
        }
        this.minaBocker.set(foundPosition, newBok);
        System.out.println(gammalBok.getName() + ", har uppdateras med " + newBok.getName());
        return true;
    }

    /**
     * Hämtar en inlagd ljudbok för att uppdatera info
     * @param gammalLjudBok
     * @param newLjudBok
     * @return true or false
     */


    public boolean uppdateraLjudBok(LjudBok gammalLjudBok, LjudBok newLjudBok) {
        int foundPosition = findLjudBok(gammalLjudBok);
        if (foundPosition < 0) {
            System.out.println(gammalLjudBok.getName() + ", gick inte att hitta");
            return false;
        }
        this.minaLjudBocker.set(foundPosition, newLjudBok);
        System.out.println(gammalLjudBok.getName() + ", har uppdateras med " + newLjudBok.getName());
        return true;
    }

    public boolean removeBok(Bok bok) {
        int foundPosition = findBok(bok);
        if (foundPosition < 0) {
            System.out.println(bok.getName() + ", gick inte att hitta.");
            return false;
        }
        this.minaBocker.remove(foundPosition);
        System.out.println(bok.getName() + ", har tagits bort.");
        return true;
    }

    /**
     * Letar efter existerande Ljudbok och raderar om de hittar.
     * @param ljudBok
     * @return true or false
     */


    public boolean removeLjudBok(LjudBok ljudBok) {
        int foundPosition = findLjudBok(ljudBok);
        if (foundPosition < 0) {
            System.out.println(ljudBok.getName() + ", gick inte att hitta.");
            return false;
        }
        this.minaLjudBocker.remove(foundPosition);
        System.out.println(ljudBok.getName() + ", har tagits bort.");
        return true;
    }

    /**
     * Metod för att hitta inlagd ljudbok
     * @param bok
     * @return true or false
     */


    private int findBok(Bok bok) {
        return this.minaBocker.indexOf(bok);
    }




    private int findBok(String bokName) {
        for (int i = 0; i < this.minaBocker.size(); i++) {
            Bok bok = this.minaBocker.get(i);
            if (bok.getName().equals(bokName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Metod som skriver ut en lista över alla alternativ.
     */

    public void printBokLista() {
        System.out.println("Bok/Ljudbok lista: ");
        for (int i = 0; i < this.minaBocker.size(); i++) {
            System.out.println((i + 1) + ".Namn: " +
                    this.minaBocker.get(i).getName() + "\n  Nummer: " +
                    this.minaBocker.get(i).getBokNr());
        }


        for (int i = 0; i < this.minaLjudBocker.size(); i++) {
            System.out.println((i + 1) + ".Ljudboknamn: " +
                    this.minaLjudBocker.get(i).getName() + "\n  Nummer: " +
                    this.minaLjudBocker.get(i).getBokNr() + " \n  Ljudspråk: " +
                    this.minaLjudBocker.get(i).getljudsprak());
        }
    }


    private int findLjudBok(LjudBok ljudBok) {
        return this.minaLjudBocker.indexOf(ljudBok);
    }


    private int findLjudBok(String bokName) {
        for (int i = 0; i < this.minaLjudBocker.size(); i++) {
            LjudBok ljudBok = this.minaLjudBocker.get(i);
            if (ljudBok.getName().equals(bokName)) {
                return i;
            }
        }
        return -1;
    }


    public LjudBok queryLjudBok(String name) { // (Vi returnerar LjudBok (ett objekt))
        int position = findLjudBok(name);
        if (position >= 0) {
            return this.minaLjudBocker.get(position);
        }

        return null;
    }

    public Bok queryBok(String name) { // (Vi returnerar Bok (ett objekt))
        int position = findBok(name);
        if (position >= 0) {
            return this.minaBocker.get(position);
        }

        return null;
    }



    }
