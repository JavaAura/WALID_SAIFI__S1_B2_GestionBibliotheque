package src.Utilitaire;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputValidator {

    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");



    public static int validateInt(int tmp) {

        if (tmp != Integer.MIN_VALUE) {
            return tmp;
        }

        boolean isValid = false;
        int input = tmp;


        while (!isValid) {
            System.out.print("Entrez un nombre entier valide: ");
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





    public static String validateString(String input) {
        Scanner scanner = new Scanner(System.in);


        if (input != null && !input.trim().isEmpty()) {
            return input;
        }


        System.out.println("Veuillez saisir une chaîne non vide :");
        while (true) {
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("La chaîne saisie est vide. Veuillez réessayer :");
        }
    }





    public static LocalDate validateDate(LocalDate input) {

        if (input != null) {
            return input;
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir une date au format 'yyyy-MM-dd' :");

        while (true) {
            String dateString = scanner.nextLine().trim();
            try {
                LocalDate parsedDate = LocalDate.parse(dateString, DATE_FORMATTER);
                return parsedDate;
            } catch (DateTimeParseException e) {
                System.out.println("La date saisie est invalide ou ne respecte pas le format 'yyyy-MM-dd'. Veuillez réessayer.");
                System.out.println("Erreur: " + e.getMessage());
            }
        }
    }





}
