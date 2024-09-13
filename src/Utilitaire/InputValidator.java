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







    public static LocalDate validateDate(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir une date au format 'yyyy-MM-dd' :");

        while (true) {
            String dateString = scanner.nextLine().trim();
            try {
                LocalDate parsedDate = LocalDate.parse(dateString, DATE_FORMATTER);
                return parsedDate;
            } catch (DateTimeParseException e) {

                System.out.println("Erreur : La date saisie est invalide ou ne respecte pas le format 'yyyy-MM-dd'.");
                System.out.println("Exemple de format valide : 2024-09-13");
                System.out.println("Veuillez réessayer :");
            }
        }
    }



    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }






}






