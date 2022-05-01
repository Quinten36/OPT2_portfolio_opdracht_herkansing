package model2;

import java.util.ArrayList;

public class Gerecht {
    private final String naam;
    private final String beschrijving;
    private final double prijs;
    //todo: hoofdingredienten naar een array?
    private String hoofd_ingredienten;
    private static ArrayList<Gerecht> alleGerechten = new ArrayList<Gerecht>();

    public Gerecht(String naam, String beschrijving, double prijs, String hoofd_ingredienten) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.hoofd_ingredienten = hoofd_ingredienten;
        alleGerechten.add(this);
    }

    public String getNaam() { return naam; }

    public String getBeschrijving() { return beschrijving; }

    public double getPrijs() { return prijs; }

    public String getHoofd_ingredienten() { return hoofd_ingredienten; }

    public void setHoofd_ingredienten(String hoofd_ingredienten) {
        this.hoofd_ingredienten = hoofd_ingredienten;
    }

    public static ArrayList<Gerecht> getAlleGerechten() { return alleGerechten; }
}
