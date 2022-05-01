package factories2;

import model2.Gerecht;

import java.util.ArrayList;

public class gerechtFactory {
    public static void start() {
        new Gerecht("Hamburger", "Is een vette maar lekkere hap", 6.55, "Brood");
        new Gerecht("Pasta Pesto", "Is een gezonde, makkelijke en scouting vriendelijk gerecht", 4.69, "Pasta");
        new Gerecht("Biefstuk met aardappeltjes", "Is een luxer gerecht", 8.25, "Aardappelen");
        new Gerecht("Hutspot", "Een oeroud nederlands gercht", 6.55, "Brood");
        new Gerecht("Salade", "Voor wanneer voor een gezonde keuze wilt gaan", 4.69, "Sla");
        new Gerecht("Pokebowl", "Een heerlijk aziatich geinspireerd gerecht", 8.25, "Rijst");
        new Gerecht("Tiramisu", "Een lekker grieks desert", 8.25, null);
        new Gerecht("Pannenkoeken", "Gewoon pannenkoeken", 8.25, "Deeg");
        new Gerecht("Poffertjes", "Kleine pannenkoeken", 8.25, "Deeg");
        new Gerecht("Tomatensoep", "Soep van tomaten", 8.25, "Pasta");
    }
}
