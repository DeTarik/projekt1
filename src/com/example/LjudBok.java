package com.example;

import java.util.ArrayList;

public class LjudBok extends Bok {

    public String ljudsprak;



    // Konstruktor


    public LjudBok(String name, String bokNr, String ljudsprak) {
        super(name, bokNr);
        this.ljudsprak = ljudsprak;
    }


    public String getljudsprak() {
        return ljudsprak;
    }




    public static LjudBok createLjudBok(String name, String bokNr, String ljudsprak) {
        return new LjudBok(name, bokNr, ljudsprak );
    }

}


