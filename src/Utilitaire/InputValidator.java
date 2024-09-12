package src.Utilitaire;

import java.util.Scanner;

public class InputValidator {

    private static Scanner scanner = new Scanner(System.in);


    public static String validateString(String prompt) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Entrée invalide. Veuillez entrer une chaîne non vide.");
            }
        }
        return input;
    }


    public static int validateInt(String prompt) {
        int input = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                isValid = true;
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                scanner.next();
            }
        }
        return input;
    }
}
