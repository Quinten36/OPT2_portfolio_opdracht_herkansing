package model2;

import controller2.profileController;

import java.util.ArrayList;

public class Client {
    private final String naam;
    private final String geslacht;
    //todo: kan dit niet gewoon normale arrays zijn?
    private ArrayList<String> dieetwensen;
    private ArrayList<String> allergien;
    private final String wijk;
    private ArrayList<Weekplanner> weekplanners = new ArrayList<Weekplanner>();
    public static ArrayList<Client> alleClienten = new ArrayList<Client>();

    public Client(String naam, String geslacht, ArrayList<String> dieetwensen, ArrayList<String> allergien, String wijk) {
        this.naam = naam;
        this.geslacht = geslacht;
        this.dieetwensen = dieetwensen;
        this.allergien = allergien;
        this.wijk = wijk;
        alleClienten.add(this);
    }

    public static ArrayList<Client> printClienten(String wijk) {
        ArrayList<Client> weerTeGevenClienten = new ArrayList<Client>();
        for (Client client : alleClienten) {
            if (client.wijk.equalsIgnoreCase(wijk)) {
                weerTeGevenClienten.add(client);
            }
        }
        try {
            if (weerTeGevenClienten.size() == 0)
                throw new Exception("Geen clienten binnen je opgegeven zoekresultaat"+wijk);
            System.out.printf("Wijk: %s\n", wijk);
            for (int i = 1; i <= weerTeGevenClienten.size(); i++) {
                System.out.printf("%d) %s\n", i, weerTeGevenClienten.get(i-1).getNaam());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return weerTeGevenClienten;
        }
    }

    //todo: veel dezelfde code, opschonen?
    public static void printDieetwensen(Client client) {
        if (client.getDieetwensen() == null) {
            System.out.print("Client heeft geen dieetwensen\n");
            return;
        }
        if (client.getDieetwensen().size() == 0) {
            System.out.print("Client heeft geen dieetwensen\n");
            return;
        }
        StringBuilder output = new StringBuilder();
        output.append("Dieetwensen: ");
        for (String dieetwens : client.getDieetwensen()) {
            output.append(dieetwens).append(", ");
        }
        System.out.print(output.substring(0, output.length()-2)+"\n");
    }

    public static void printAllergien(Client client) {
        if (client.getAllergien() == null) {
            System.out.print("Client heeft geen allergien\n");
            return;
        }
        if (client.getAllergien().size() == 0) {
            System.out.print("Client heeft geen allergien\n");
            return;
        }
        StringBuilder output = new StringBuilder();
        output.append("Allergien: ");
        for (String allergie : client.getAllergien()) {
            output.append(allergie).append(", ");
        }
        System.out.print(output.substring(0, output.length()-2)+"\n");
    }

    public static void printProfielWeekplanner(Client client) {
        if (client.getWeekplanners() == null || client.getWeekplanners().size() == 0) {
            System.out.print("De client heeft nog geen weekplanners\n");
            return;
        }
        if (Weekplanner.checkNewestPlanner(client)) {
            System.out.println("De client heeft een weekplanner voor de week. Kies 1 om hem te bekijken");
            return;
        }
        System.out.print("De client heeft nog geen weekplanner van deze week. Kies 2 om er één aan te maken\n");
    }

    public ArrayList<Weekplanner> getWeekplanners() {
        return weekplanners;
    }
    public String getGeslacht() {
        return geslacht;
    }
    public String getNaam() { return naam; }
    public ArrayList<String> getDieetwensen() { return dieetwensen; }
    public ArrayList<String> getAllergien() { return allergien; }
    public String getWijk() { return wijk; }

    /**
     * voegt de weekplanner toe aan het obejct met alle afgelopen weekplanners
     * @param planner
     */
    public void addWeekplanner(Weekplanner planner) {
        this.weekplanners.add(planner);
    }

    public void printWeekplanner(int currentWeeknummer) {
        //show weekplanner met gerechten
        StringBuilder sb = new StringBuilder();
        Weekplanner week = weekplanners.get(weekplanners.size() - 1);
        for (Weekplanner week1 : weekplanners) {
            if (week1.getWeeknummer() == currentWeeknummer)
                week = week1;
        }

        sb.append("Eetplanner voor week: " + week.getWeeknummer() + "\n");
        String[] days = {"Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag", "Zaterdag", "Zondag"};
        for (int i = 0; i < 7; i++) {
            ArrayList<Gerecht> gerechten = week.getGerechten();
            Gerecht gerecht = gerechten.get(i);
            sb.append(String.format("%10s | %s\n", days[i], gerecht.getNaam()));
        }
        System.out.print(sb);
        System.out.print("(Press ENTER to continu)\n");
        userInput.getUserInputString();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        profileController.profilecontroller.showProfileFromClient(this);
    }
}