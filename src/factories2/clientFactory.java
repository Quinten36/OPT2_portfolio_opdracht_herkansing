package factories2;

import model2.Client;

import java.util.ArrayList;
import java.util.List;

public class clientFactory {
    public static void start() {
        new Client("Jantienne van Zeeuw", "Vrouw", new String[]{"Brood"}, null, "Holy");
        new Client("Lieke van Zeeuw", "Vrouw", null, null, "Holy");
        new Client("Joris van Zeeuw", "Man", new String[]{"Vegataries"}, new String[]{"Noten"}, "Schiedam");
        new Client("Sofie van Zeeuw", "Vrouw", new String[]{"Suikervrij"}, new String[]{"Pollen"}, "Holy");
        new Client("Danté van Zeeuw", "Man", new String[]{"koolhydraatarm"}, new String[]{"Gluten"}, "Schiedam");
        new Client("Roos van Zeeuw", "Onbekend", null, new String[]{"Wespen"}, "Holy");
    }
}

