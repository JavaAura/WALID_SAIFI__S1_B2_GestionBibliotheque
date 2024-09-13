package src.Utilitaire;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate parseDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Erreur de format de date. Utilisez le format 'jj/MM/aaaa'.");
            return null;
        }
    }

    public static String formatDate(LocalDate date) {
        return date.format(formatter);
    }
}
