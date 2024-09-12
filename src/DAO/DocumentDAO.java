package src.DAO;

import java.sql.*;

public class DocumentDAO {

    public  static void afficherToutDocument(){
        LivreDAO.afficherTousLesLivres();
        MagazineDAO.afficherTousLesMagazines();
        JournalScientifiqueDAO.afficherTousLesJournauxScientifiques();
        TheseUniversitaireDAO.afficherToutesLesThesesUniversitaires();
    }


    public static void emprunterDocument(int id) {
        String sql = "UPDATE Document SET etatDocument = 'emprunte' WHERE id = ? AND etatDocument = 'disponible'";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Document emprunté avec succès.");
            } else {
                System.out.println("Le document est soit déjà emprunté, soit inexistant.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'emprunt du document : " + e.getMessage());
        }
    }


    public static void reserverDocument(int id) {
        String sql = "UPDATE Document SET reserve = TRUE WHERE id = ? AND etatDocument = 'emprunte' AND reserve = FALSE";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Document réservé avec succès.");
            } else {
                System.out.println("Le document ne peut pas être réservé ou est déjà réservé.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la réservation du document : " + e.getMessage());
        }
    }
}
