package controller2;

import model2.Gebruiker;
import model2.Mantelzorger;
import model2.Ziekenverzorgende;
import model2.userInput;

import java.util.ArrayList;

public class loginController {
    public static loginController logincontroller;

    public void start() {
        Gebruiker.setIngelogd(null);
        Gebruiker.setIsZiekenverzorgendeIngelogd();
        try {
            if (Ziekenverzorgende.alleZiekenverzorgende == null)
                throw new Exception("No users");
            printMenu();
            int choice = userInput.getUserInputInt();
            //todo validate dat alleen int ingevoerd kan worden
            if (choice < 1 || choice > 2)
                throw new Exception("Please choose an option");
            if (authenticate(choice)) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("U bent ingelogd\n\n");
                menuController.menucontroller.startMenu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        start();
    }

    private boolean authenticate(int choice) {
        ArrayList<Gebruiker> gebruikers = choice == 1 ? Ziekenverzorgende.alleZiekenverzorgende : Mantelzorger.alleMantelzorgers;

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Please enter your email: ");
        String email = userInput.getUserInputString();
        //todo: zorgen dat je pas verder ga als je erin staat.
        System.out.println("\nPlease enter your password: ");
        String password = userInput.getUserInputString();

        //todo: afhandelen dat als je email goed is dat je daarvan een bericht krijg
        for (Gebruiker g : gebruikers) {
            if (g.getEmail().equalsIgnoreCase(email) && g.getWachtwoord().equals(password)) {
                Gebruiker.setIngelogd(g);
                if (choice == 1)
                    Gebruiker.setGebruikerZiekenverzorgde(true);
                return true;
            }
        }
        System.out.print("\n\n\n\n\n\n\n\n\n");
        System.out.println("Login poging helaas mislukt");
        return false;
    }

    private void printMenu() {
        System.out.println("\n\n");
        System.out.println("Hoe zou je willen inloggen?\n1) Ziekenverzorgende\n2) Mantelzorger");
    }
}
