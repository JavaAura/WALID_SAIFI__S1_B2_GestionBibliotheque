package src.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import src.Métier.*;

public class MagazineDAO {


    public static void ajouterMagazine(Magazine magazine)  {

        String sql = "INSERT INTO Magazine (titre, auteur, date_de_publication, nombre_de_pages, numero) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, magazine.getTitre());
            stmt.setString(2, magazine.getAuteur());
            stmt.setDate(3, Date.valueOf(magazine.getDateDePublication()));
            stmt.setInt(4, magazine.getNombreDePages());
            stmt.setString(5, String.valueOf(magazine.getNuméro()));
            stmt.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erreur lors de l'ajout du magazine : " + e.getMessage());

        }
    }

    public static void modifierMagazine(Magazine magazine) {

        String sql = "UPDATE Magazine SET titre = ?, auteur = ?, date_de_publication = ?, nombre_de_pages = ?, numero = ? WHERE numero = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, magazine.getTitre());
            stmt.setString(2, magazine.getAuteur());
            stmt.setDate(3, Date.valueOf(magazine.getDateDePublication()));
            stmt.setInt(4, magazine.getNombreDePages());
            stmt.setInt(5, magazine.getNuméro());
            stmt.setInt(6, magazine.getNuméro());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Aucun magazine trouvé avec le numéro spécifié pour mise à jour.");
            } else {
                System.out.println("Magazine mis à jour avec succès.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du magazine : " + e.getMessage());
        }
    }



    public static void supprimerMagazine(int id) {
        String sql = "DELETE FROM Magazine WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Aucun magazine trouvé avec l'ID spécifié.");
            } else {
                System.out.println("Magazine supprimé avec succès.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du magazine : " + e.getMessage());
        }
    }

}