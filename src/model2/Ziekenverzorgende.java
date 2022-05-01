package model2;

import controller2.menuController;
import controller2.profileController;

import java.util.ArrayList;

public class Ziekenverzorgende extends Gebruiker implements IdisplayChoice {
    //todo: of array voor meer wijken?
    private String wijk;
    private String team;
    public static ArrayList<Gebruiker> alleZiekenverzorgende = new ArrayList<>();

    public Ziekenverzorgende(String naam, String email, String wachtwoord, String wijk, String team) {
        super(naam, email, wachtwoord);
        this.wijk = wijk;
        this.team = team;
        alleZiekenverzorgende.add(this);
    }

    public String getWijk() { return wijk; }

    public String getTeam() { return team; }

    public void setWijk(String wijk) {
        this.wijk = wijk;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * Dit is een stukje polymorfisme, want in andere classes kan je dezelfde functie aanroepen maar doet het wat anders
     * Wat dus precies polymorfisme is
     * @return
     */

    @Override
    public void displayChoices() {
        System.out.println("Wat wilt u doen:\n1) Client selecteren\n2) Client toevoegen\n3) Client bewerken\n0) Log uit");
    }

    @Override
    public void selecteerClientOption() throws Exception {
        System.out.println("Welke client wilt u selecteren?");
        Ziekenverzorgende ingelogd = (Ziekenverzorgende) Gebruiker.wieIsIngelogd();
        ArrayList<Client> clientenInWijk = Client.printClienten(ingelogd.getWijk());
        System.out.printf("%d) Terug\n", 0);

        int choice = userInput.getUserInputInt();
        if (choice == 0) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            menuController.menucontroller.startMenu();
        } else {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            profileController.profilecontroller.showProfileFromClient(clientenInWijk.get(choice-1));
        }
    }
}
