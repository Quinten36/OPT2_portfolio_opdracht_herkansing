package controller2;

import model2.*;

public class profileController {
    public static profileController profilecontroller;

    public void showProfileFromClient(Client client) {
        try {
            System.out.printf("Profile van %s %s\n", client.getGeslacht().equalsIgnoreCase("Man") ? "Dhr." : "Mevr.", client.getNaam().split(" ", 2)[1]);

            System.out.printf("Naam: %s\n", client.getNaam());

            //dieetwensen
            Client.printDieetwensen(client);

            //allergien
            Client.printAllergien(client);

            //weekplanner voor deze week
            //todo fix?
            Client.printProfielWeekplanner(client);

            //keuze menu
            printKeuzeMenuProfile(new String[]{"weekplanner bekijken", "weekplanner aanmaken", "terug naar overzicht"});
            int choice = userInput.getUserInputInt();

            if (choice < 0 || choice > 2)
                throw new Exception("Kies alstublieft een geldige menu optie");

            switch (Integer.toString(choice)) {
                case "1": //1 = weekplanner bekijken
                    if (Weekplanner.checkNewestPlanner(client))
                        client.printWeekplanner(Weekplanner.getCurrentWeeknummer());
                    else {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("Deze cliënt heeft nog geen weekplanners voor deze week. Kies 2 om er één te maken\n");
                        showProfileFromClient(client);
                    }
                    break;
                case "2": //2 = weekplanner aanmaken
                    //todo: na het aanmaken gelijk planning bekijken?

                    String output = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
                    if (Gebruiker.getIsZiekenverzorgendeIngelogd()) {
                        if (!Weekplanner.checkNewestPlanner(client)) {
                            Weekplanner weekplanner = new Weekplanner(Weekplanner.getCurrentWeeknummer());
                            weekplanner.generateWeekplanner(Weekplanner.getCurrentWeeknummer());
                            client.addWeekplanner(weekplanner);
                        } else {
                            output += "Er is al een weekplanner voor deze week. Kies 1 om hem te bekijken\n";
                        }
                    }
                    System.out.println(output);
                    showProfileFromClient(client);
                    break;
                case "0": //0 = terug naar overzicht
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    menuController.menucontroller.startMenu();
                    break;
                default:
                    throw new Exception("Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo: make more dynamic
    private void printKeuzeMenuProfile(String[] keuzes) {
        System.out.print("\nKeuzes: ");
        if (Gebruiker.getIsZiekenverzorgendeIngelogd()) {
            for (int i = 1; i <= 3; i++) {
                System.out.printf("%d) %s   ", i == 3 ? 0 : i, keuzes[i-1]);
            }
        } else {
            for (int i = 1; i <= 3; i++) {
                if (i == 2)
                    i++;
                System.out.printf("%d) %s   ", i == 3 ? 0 : i, keuzes[i-1]);
            }
        }
        System.out.print("\n");
    }
}
