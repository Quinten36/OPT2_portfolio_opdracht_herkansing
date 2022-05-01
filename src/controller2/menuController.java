package controller2;

import model2.*;

import java.util.ArrayList;

public class menuController {
    public static menuController menucontroller;

    public void startMenu() {
        Gebruiker.wieIsIngelogd().displayChoices();
        menu();
    }

    public void menu() {
        try {
            //todo: zorgen dat mantelzorgers geen andere keuze kunnen maken
            //todo: logout optie?
            int choice = userInput.getUserInputInt();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            if (choice < 0 || choice > 3) {
                System.out.println("Kies alstublieft een goede optie");
                startMenu();
            }
            if (!Gebruiker.getIsZiekenverzorgendeIngelogd()) {
                if (choice < 0 || choice > 1) {
                    System.out.println("Kies alstublieft een goede optie");
                    startMenu();
                }
            }

            switch (Integer.toString(choice)) {
                case "1":
                    //select client
                    Gebruiker.wieIsIngelogd().selecteerClientOption();
                    break;
                case "2":
                    //add client
                    break;
                case "3":
                    //change client data
                    break;
                case "0":
                    //log uit
                    Gebruiker.setIngelogd(null);
                    Gebruiker.setIsZiekenverzorgendeIngelogd();
                    break;
                default:
                    throw new Exception("Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
