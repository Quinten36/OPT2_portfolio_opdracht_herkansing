import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class UserInputMethodsForTesting {
    private ByteArrayOutputStream byteArrayOutputStream;

    public UserInputMethodsForTesting() {
        setupSystemOutput();
    }

    /**
     * This method is used to initiate an instance of UserInputMethodsForTesting
     */
    private void setupSystemOutput() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
    }

    /**
     * This method puts a String value (userInput) in the System.In to simulate a Scanner(System.in)
     *
     * @param userInput
     */
    public void makeUserInput(String userInput) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputStream);
    }

    //TODO: checken hoe de uitkomst is
    public void makeUserInputs(String[] userInput) {
//        for (String s : userInput) {
//
//        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(userInput.toString().getBytes());
        System.setIn(byteArrayInputStream);
    }

    /**
     * This method returns the System.out in a string value.
     *
     * @return String
     */
    public String getSystemOutput() {
        String[] lines = byteArrayOutputStream.toString().split(System.lineSeparator());
        return lines[lines.length-1];
    }
}
