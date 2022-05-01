import factories2.gerechtFactory;
import model2.Client;
import model2.Gerecht;
import model2.Weekplanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class TestWeekplanner {

    @BeforeEach
    public void init() {
        gerechtFactory.start();
    }

    @Test
    public void test_if_there_is_a_weekplanner_of_this_week() {
        Client Mvr_Zeeuw = new Client("Margrit Zeeuw", "Vrouw", new String[]{"Pasta"}, null, "Holy");

        //expected false
        boolean result = Weekplanner.checkNewestPlanner(Mvr_Zeeuw);
        Weekplanner planner = new Weekplanner(Weekplanner.getCurrentWeeknummer());
        Mvr_Zeeuw.addWeekplanner(planner.generateWeekplanner(Weekplanner.getCurrentWeeknummer()));
        boolean result2 = Weekplanner.checkNewestPlanner(Mvr_Zeeuw);

        Assertions.assertFalse(result);
        Assertions.assertTrue(result2);
    }

    //TODO: veranderen
    @Test
    public void test_if_a_weekplanner_is_being_generated() {
        Weekplanner week = new Weekplanner(Weekplanner.getCurrentWeeknummer());
        Weekplanner result = week.generateWeekplanner(week.getWeeknummer());

        Assertions.assertEquals(result.getWeeknummer(), week.getWeeknummer());
    }

    @Test
    public void test_if_a_weekplanner_dont_contain_duplicate_meals() {
        Weekplanner week = new Weekplanner(Weekplanner.getCurrentWeeknummer());
        ArrayList<Gerecht> gerechten = week.generateWeekplanner(Weekplanner.getCurrentWeeknummer()).getGerechten();

        ArrayList<Gerecht> checkArray = new ArrayList<>();
        checkArray.add(gerechten.get(0));
        boolean result = false;
        boolean result2 = false;

        for (int i = 1; i < gerechten.size(); i++) {
            if (checkArray.contains(gerechten.get(i))) {
                result2 = true;
            } else {
                checkArray.add(gerechten.get(i));
            }
        }

        checkArray.clear();
        checkArray.add(gerechten.get(0));
        gerechten.set(2, gerechten.get(4));

        for (int i = 1; i < gerechten.size(); i++) {
            if (checkArray.contains(gerechten.get(i))) {
                result = true;
            } else {
                checkArray.add(gerechten.get(i));
            }
        }

        Assertions.assertTrue(result);
        Assertions.assertFalse(result2);
    }

    @Test
    public void test_if_a_weekplanner_is_being_added_to_the_client() {
        Client Mvr_Zeeuw = new Client("Margrit Zeeuw", "Vrouw", new String[]{"Pasta"}, null, "Holy");

        Weekplanner week = new Weekplanner(Weekplanner.getCurrentWeeknummer());
        ArrayList<Gerecht> expectedResult = week.getGerechten();

        Mvr_Zeeuw.addWeekplanner(week);
        ArrayList<Gerecht> result = Mvr_Zeeuw.getWeekplanners().get(Mvr_Zeeuw.getWeekplanners().size() - 1).getGerechten();

        Assertions.assertEquals(expectedResult.size(), result.size());
        Assertions.assertEquals(expectedResult, result);
    }
}
