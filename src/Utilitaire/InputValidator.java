package src.Utilitaire;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputValidator {

    private static Scanner scanner = new Scanner(System.in);


    public static String validateString(String input, String prompt) {
        if (input != null && !input.trim().isEmpty()) {
            return input;
        }
        while (input == null || input.trim().isEmpty()) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Entrée invalide. Veuillez entrer une chaîne non vide.");
            }
        }
        return input;
    }


    public static int validateInt(Integer input, String prompt) {
        if (input != null) {
            return input;
        }
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


    public static LocalDate validateDate(LocalDate input, String prompt) {
        if (input != null) {
            return input; 
        }
        boolean isValid = false;
        LocalDate date = null;
        while (!isValid) {
            System.out.print(prompt);
            String dateInput = scanner.nextLine();
            try {
                date = LocalDate.parse(dateInput);
                isValid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Entrée invalide. Veuillez entrer une date au format (yyyy-mm-dd).");
            }
        }
        return date;
    }

}
