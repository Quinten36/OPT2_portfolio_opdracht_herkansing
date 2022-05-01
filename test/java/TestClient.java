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

        //Arrange
        userInputOutputHandler.makeUserInput("Quinten Kempers");
        userInputOutputHandler.makeUserInput("Man");
        userInputOutputHandler.makeUserInput(null);
        userInputOutputHandler.makeUserInputs(new String[]{"Bananen"});//new ArrayList<>(List.of("Bananen"))
        userInputOutputHandler.makeUserInput("Holy");

        String expectedOutcome = "";//Later in te vullen

        //act
        Client.addClientOption();
        String actualOutcome = userInputOutputHandler.getSystemOutput();

        //Assert
        Assertions.assertEquals(expectedOutcome, actualOutcome);
    }


    @Test
    public void TestAddClient() {
        //Arrange
        //        int expectedTotalClientLength = Client.alleClienten.size()+1;

        //Act
//        int actualTotalClientLength = Client.alleClienten.size();

        //Assert
        //        Assertions.assertEquals(expectedTotalClientLength, actualTotalClientLength);
    }
//Act
//        userInputOutputHandler.makeUserInput("Thomas");
//        UserInput.askUser("Wat is je naam?\n> ");
//    String actual = userInputOutputHandler.getSystemOutput();


}
