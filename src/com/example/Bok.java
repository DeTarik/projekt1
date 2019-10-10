package com.example;

  public class Bok {

    private String name;
    private String bokNr;



    // Konstruktor


    public Bok(String name, String bokNr) {
        this.name = name;
        this.bokNr = bokNr;

    }


    public String getName() {
        return name;
    }

    public String getBokNr() {
        return bokNr;
    }

    public static Bok createBok(String name, String bokNr) {
        return new Bok(name, bokNr);
    }



  }

