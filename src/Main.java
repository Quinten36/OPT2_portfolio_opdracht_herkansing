import java.util.Scanner;

public class Main {
    public static boolean state = true;


    public static void main(String[] args) {
	// write your code here
        app.mainApp = new app();

        app.mainApp.init();

        while (state) {
            app.mainApp.start();
        }
    }


}
