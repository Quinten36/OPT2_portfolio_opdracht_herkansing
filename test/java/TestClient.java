import factories2.clientFactory;
import model2.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.lang.model.element.VariableElement;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class TestClient {
    private UserInputMethodsForTesting userInputOutputHandler;

    @BeforeEach
    public void init() {
        userInputOutputHandler = new UserInputMethodsForTesting();
        clientFactory.start();
    }

    @Test
    public void TestAddClientMenuOption() {
        //first i check if the process of aksing the input is correct. After that i check if the client is correctly added

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Quinten Kempers\nMan\nniks\nBananen\nHoly".getBytes());
        System.setIn(byteArrayInputStream);

        String expectedOutcome = "Inschrijven Cliënt:\n" +
                "\n" +
                "Wat is de naam van de cliënt?> \n" +
                "Wat is het geslacht van de cliënt? (Man/Vrouw)> \n" +
                "In welke wijk woont de cliënt?> \n" +
                "Heeft de cliënt allergien?\n" +
                " Zo nee typ \"niks\", Zo ja typ de allergien en typ een komma om ze te scheiden> \n" +
                "Heeft de cliënt dieetwensen?\n" +
                " Zo nee typ \"niks\", Zo ja typ de dieetwens en typ een komma om ze te scheiden> ";//Later in te vullen

        //act
        Client.addClientOption();
        String actualOutcome = userInputOutputHandler.getfullSystemOutput().toString();

        //Assert
        Assertions.assertEquals(expectedOutcome, actualOutcome);

    }

    @Test
    public void TestAddClient() {
        //Arrange
        int expectedTotalClientLength = Client.alleClienten.size()+1;
        int expectedTotalClientLength2 = Client.alleClienten.size()+2;

        //Act
        boolean state = Client.addClient("Quinten Kempers", "Man", new String[]{"niks"}, new String[]{"Bananen"}, "Holy");
        int actualTotalClientLength = Client.alleClienten.size();

        //Assert
        Assertions.assertTrue(state);
        Assertions.assertEquals(expectedTotalClientLength, actualTotalClientLength);
        Assertions.assertEquals("Quinten Kempers", Client.alleClienten.get(Client.alleClienten.size()-1).getNaam());

        state = Client.addClient("Lisa de Jager", "Vrouw", new String[]{"niks"}, new String[]{"Bananen"}, "Holy");
        actualTotalClientLength = Client.alleClienten.size();

        //Assert
        Assertions.assertTrue(state);
        Assertions.assertEquals(expectedTotalClientLength2, actualTotalClientLength);
        Assertions.assertEquals("Lisa de Jager", Client.alleClienten.get(Client.alleClienten.size()-1).getNaam());
    }

    @Test
    public void TestAddClientMCDC() {
        //a = alle gegevens bekend
        //b = wijk
        //c = nog niet bestaan

        //Act
        boolean state011 = Client.addClient("Quinten Kempers", "Onbekend", new String[]{"niks"}, new String[]{"Bananen"}, "Holy");

        boolean state101 = Client.addClient("Quinten Kempers", "Man", new String[]{"niks"}, new String[]{"Bananen"}, "Kethel");

        boolean state110 = Client.addClient("Jantienne van Zeeuw", "Man", new String[]{"niks"}, new String[]{"Bananen"}, "Holy");

        boolean state111 = Client.addClient("Lisa de Jager", "Vrouw", new String[]{"niks"}, new String[]{"Bananen"}, "Holy");

        //Assert
        Assertions.assertFalse(state011);
        Assertions.assertFalse(state101);
        Assertions.assertFalse(state110);
        Assertions.assertTrue(state111);
    }
   
//Act
//        userInputOutputHandler.makeUserInput("Thomas");
//        UserInput.askUser("Wat is je naam?\n> ");
//    String actual = userInputOutputHandler.getSystemOutput();


}
