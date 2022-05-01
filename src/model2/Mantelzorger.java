package model2;

import controller2.profileController;

import java.util.ArrayList;

public class Mantelzorger extends Gebruiker implements IdisplayChoice {
    private Client client;
    public static ArrayList<Gebruiker> alleMantelzorgers = new ArrayList<>();

    public Mantelzorger(String naam, String email, String wachtwoord) {
        super(naam, email, wachtwoord);
        alleMantelzorgers.add(this);
    }

    public Mantelzorger(String naam, String email, String wachtwoord, Client client) {
        super(naam, email, wachtwoord);
        this.client = client;
        alleMantelzorgers.add(this);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Dit is een stukje polymorfisme. Want ik de ziekenverzorgende class staat dezelfde functie die hetzelfde doet alleen met een andere inhoud binnen de functie
     * Wat dus precies polymorfisme is
     * @return specified client
     */
    public Client getClient() {
        //todo /* verkrijg alle clienten op basis van dezelfde wijk */
        return client;
    }

    @Override
    public void displayChoices() {
        System.out.println("Wat wilt u doen:\n1) Client selecteren\n0) Log uit");
    }

    @Override
    public void selecteerClientOption() {
        //todo: mantelzorger zijn voor meerdere clienten?
        Mantelzorger ingelogd = (Mantelzorger) Gebruiker.wieIsIngelogd();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        profileController.profilecontroller.showProfileFromClient(ingelogd.getClient());
    }
}
