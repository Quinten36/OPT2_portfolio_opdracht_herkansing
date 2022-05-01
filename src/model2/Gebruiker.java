package model2;

public class Gebruiker implements IdisplayChoice {
    private String naam;
    private String email;
    private String wachtwoord;
    private static Gebruiker ingelogdeGebruiker;
    private static boolean ziekenverzorgende = false;


    public Gebruiker(String naam, String email, String wachtwoord) {
        this.naam = naam;
        this.email = email;
        this.wachtwoord = wachtwoord;
    }

    public static void setGebruikerZiekenverzorgde(boolean b) {
        ziekenverzorgende = b;
    }

    public String getNaam() { return naam; }
    public String getEmail() { return email; }
    public String getWachtwoord() { return wachtwoord; }
    public static boolean getIsZiekenverzorgendeIngelogd() { return ziekenverzorgende; }

    public static void setIngelogd(Gebruiker gebruiker) { ingelogdeGebruiker = gebruiker; }
    public static void setIsZiekenverzorgendeIngelogd() { ziekenverzorgende = false; }

    public void logUit() {}

    public static boolean isIngelogd() { return ingelogdeGebruiker == null; }

    public static Gebruiker wieIsIngelogd() { return ingelogdeGebruiker; }

    @Override
    public void displayChoices() {
        System.out.println("Wat wilt u doen:\n1) Client selecteren\n0) Log uit");
    }

    @Override
    public void selecteerClientOption() throws Exception {
        System.out.println("blank");
    }
}
