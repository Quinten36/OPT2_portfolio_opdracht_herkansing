package factories2;

import model2.Client;

import java.util.ArrayList;
import java.util.List;

public class clientFactory {
    public static void start() {
        new Client("Jantienne van Zeeuw", "Vrouw", new ArrayList<>(List.of("Brood")), null, "Holy");
        new Client("Lieke van Zeeuw", "Vrouw", null, null, "Holy");
        new Client("Joris van Zeeuw", "Man", new ArrayList<>(List.of("Vegataries")), new ArrayList<>(List.of("Noten")), "Schiedam");
        new Client("Sofie van Zeeuw", "Vrouw", new ArrayList<>(List.of("Suikervrij")), new ArrayList<>(List.of("Pollen")), "Holy");
        new Client("Danté van Zeeuw", "Man", new ArrayList<>(List.of("koolhydraatarm")), new ArrayList<>(List.of("Gluten")), "Schiedam");
        new Client("Roos van Zeeuw", "Onbekend", null, new ArrayList<>(List.of("Wespen")), "Holy");
    }
}

