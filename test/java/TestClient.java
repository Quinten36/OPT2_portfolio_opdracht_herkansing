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
        Client.addClient("Quinten Kempers", "Man", null, new String[]{"Bananen"}, "Holy");
        int actualTotalClientLength = Client.alleClienten.size();

        //Assert
        Assertions.assertEquals(expectedTotalClientLength, actualTotalClientLength);
        Assertions.assertEquals("Quinten", Client.alleClienten.get(Client.alleClienten.size()-1).getNaam());

        Client.addClient("Lisa de Jager", "Vrouw", null, new String[]{"Bananen"}, "Holy");
        actualTotalClientLength = Client.alleClienten.size();

        //Assert
        Assertions.assertEquals(expectedTotalClientLength2, actualTotalClientLength);
        Assertions.assertEquals("Quinten", Client.alleClienten.get(Client.alleClienten.size()-1).getNaam());
    }
   
//Act
//        userInputOutputHandler.makeUserInput("Thomas");
//        UserInput.askUser("Wat is je naam?\n> ");
//    String actual = userInputOutputHandler.getSystemOutput();


}
