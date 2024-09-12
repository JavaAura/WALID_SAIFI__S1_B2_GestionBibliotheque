package src.Utilitaire;

public class InputValidator {

    public static boolean validateString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean validateInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
