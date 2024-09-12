package src.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import src.Métier.*;

public class MagazineDAO {


    public static void ajouterMagazine(Magazine magazine) throws SQLException {
        // SQL sans inclure 'etat' puisque la valeur par défaut est utilisée
        String sql = "INSERT INTO Magazine (titre, auteur, date_de_publication, nombre_de_pages, numero) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Paramétrage des valeurs dans la requête SQL
            stmt.setString(1, magazine.getTitre());
            stmt.setString(2, magazine.getAuteur());
            stmt.setDate(3, Date.valueOf(magazine.getDateDePublication()));
            stmt.setInt(4, magazine.getNombreDePages());
            stmt.setString(5, String.valueOf(magazine.getNuméro())); // Conversion de l'entier en chaîne de caractères si nécessaire

            // Exécution de la mise à jour
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Gestion des erreurs SQL
            System.err.println("Erreur lors de l'ajout du magazine : " + e.getMessage());
            throw e; // Relancer l'exception après log
        }
    }






    public static void supprimerMagazine(int id) throws SQLException {
        String sql = "DELETE FROM Magazine WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}