package model2;

import java.util.Scanner;

public class userInput {
    public static Scanner scanner = new Scanner(System.in);

    public static String getUserInputString() {
        System.out.print("> ");
        return scanner.nextLine();
    }

    public static int getUserInputInt() throws Exception {
        System.out.print("> ");
        int i = -1;
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
        } else {
            throw new Exception("Vul alstublieft een getal is");
        }
        scanner.nextLine();

        return i;
    }
}
