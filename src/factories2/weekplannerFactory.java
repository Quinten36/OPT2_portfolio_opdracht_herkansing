package factories2;

import model2.Client;
import model2.Weekplanner;

public class weekplannerFactory {
    public static void start() {
        int weeknummer = Weekplanner.getCurrentWeeknummer();
        Client.alleClienten.get(0).addWeekplanner(new Weekplanner(weeknummer).generateWeekplanner(weeknummer));
        Client.alleClienten.get(1).addWeekplanner(new Weekplanner(weeknummer-1).generateWeekplanner(weeknummer-1));
        Client.alleClienten.get(3).addWeekplanner(new Weekplanner(weeknummer).generateWeekplanner(weeknummer));
        Client.alleClienten.get(3).addWeekplanner(new Weekplanner(weeknummer-1).generateWeekplanner(weeknummer-1));
    }
}
