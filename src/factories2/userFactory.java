package factories2;

import model2.Client;
import model2.Mantelzorger;
import model2.Ziekenverzorgende;

public class userFactory {
    public static void start() {
        new Ziekenverzorgende("Karel", "Karel@zonnehuis.nl", "wachtwoord", "Holy", "Holy");
        new Ziekenverzorgende("Jan", "Jan@zonnehuis.nl", "wachtwoord", "Schiedam", "Schiedam");
        new Ziekenverzorgende("Iona", "Iona@zonnehuis.nl", "wachtwoord", "Holy", "Holy");
        new Mantelzorger("Lisa", "lisa@gmail.com", "wachtwoord", Client.alleClienten.get(2));
        new Mantelzorger("Freek", "freek@gmail.com", "wachtwoord");
    }
}

//strings at main menu broke
//optie 2 and 3 main menu maken
//testen terug zetten
//toon kezues in ziekenverzorgende/mantelzorgen overnemen als overrideable
//in sub menu ook een optie terug maken
//ploymorphisme checken