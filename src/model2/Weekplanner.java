package model2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class Weekplanner {
    private int weeknummer;
    private ArrayList<Gerecht> gerechten = new ArrayList<>();
    private final int dagenInWeek = 7;

    public Weekplanner(int weeknummer) {
        this.weeknummer = weeknummer;
    }

    public Weekplanner(int weeknummer, ArrayList<Gerecht> gerechten) {
        this(weeknummer);
        this.gerechten = gerechten;
    }

    public int getWeeknummer() { return this.weeknummer; }

    public void setGerechten(ArrayList<Gerecht> gerechten) {
        this.gerechten = gerechten;
    }

    public ArrayList<Gerecht> getGerechten() { return gerechten; }

    //om de huidige weeknummer te verkrijgen
    public static int getCurrentWeeknummer() { return Integer.parseInt(new SimpleDateFormat("w").format(new java.util.Date())); }

    /**
     * check of de client al een planner heeft van deze week
     * @param client
     * @return false = nog een planner aanmaken. true = er is al een planner
     */
    public static boolean checkNewestPlanner(Client client) {
        int i = client.getWeekplanners().size()-1;
        if (client.getWeekplanners().size() != 0) {
            if (client.getWeekplanners().get(i).getWeeknummer() == Weekplanner.getCurrentWeeknummer()) {
                return true;
            }
        }
        return false;
//        return client.getWeekplanners().size() == 0 || client.getWeekplanners().get(i).getWeeknummer() != Weekplanner.getCurrentWeeknummer();
    }

    /**
     * generate 7 random getallen, haalt de gerechten op die erbij horen op en stopt het in de weekplanner
     * later moet het nog uitgebreid worden met alleen de resterende dagen vullen
     * @param weeknummer gebruik ik nog niet, maar dat komt in de toekomst nog
     * @return
     */
    public Weekplanner generateWeekplanner(int weeknummer) {
        if (this.gerechten != null) {
            if (this.gerechten.size() == 7) { return this; }
        }

        if (weeknummer != getCurrentWeeknummer())
            this.weeknummer = weeknummer;

        //TODO: opvangen als ziekenverzorgde handigmatig dingen erin zet en dan op gen klik
        //TODO: shuffle alle gerechten en dan eerste 7? preformance is dan wel minder
        Random rand = new Random(); //instance of random class
        rand.nextInt(Gerecht.getAlleGerechten().size());
        int int_random;//
        ArrayList<Integer> selectie = new ArrayList<Integer>();

        //todo: check if weekplanner aanmaken nog steeds goed ga.
        for (int i = 0; i < dagenInWeek; i++) {
            int_random = rand.nextInt(Gerecht.getAlleGerechten().size());
            while (selectie.contains(int_random)) { int_random = rand.nextInt(Gerecht.getAlleGerechten().size()); }
            selectie.add(int_random);
            gerechten.add(Gerecht.getAlleGerechten().get(int_random));
        }
//        System.out.println(this.getGerechten());
        return this;
    }
}
