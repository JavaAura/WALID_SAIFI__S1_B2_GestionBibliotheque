package src.DAO;

import src.Métier.Professeur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesseurDAO {

    // Méthode pour ajouter un professeur
    public static void ajouterProfesseur(Professeur professeur) throws SQLException {
        String sql = "INSERT INTO Professeur (nom, email, type_utilisateur, departement) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, professeur.getNom());
            stmt.setString(2, professeur.getEmail());
            stmt.setString(3, professeur.getTypeUtilisateur());
            stmt.setString(4, professeur.getDepartement());

            stmt.executeUpdate();
            System.out.println("Professeur ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du professeur: " + e.getMessage());
        }
    }

    // Méthode pour récupérer un professeur par ID
    public static Professeur getProfesseurById(int id) throws SQLException {
        String sql = "SELECT * FROM Professeur WHERE id = ?";
        Professeur professeur = null;
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                professeur = new Professeur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        rs.getString("type_utilisateur"),
                        rs.getString("departement")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération du professeur: " + e.getMessage());
        }
        return professeur;
    }

    // Méthode pour mettre à jour un professeur par ID
    public static void mettreAJourProfesseur(Professeur professeur) throws SQLException {
        String sql = "UPDATE Professeur SET nom = ?, email = ?, type_utilisateur = ?, departement = ? WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, professeur.getNom());
            stmt.setString(2, professeur.getEmail());
            stmt.setString(3, professeur.getTypeUtilisateur());
            stmt.setString(4, professeur.getDepartement());
            stmt.setInt(5, professeur.getId());

            stmt.executeUpdate();
            System.out.println("Professeur mis à jour avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du professeur: " + e.getMessage());
        }
    }

    // Méthode pour supprimer un professeur par ID
    public static void supprimerProfesseur(int id) throws SQLException {
        String sql = "DELETE FROM Professeur WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Professeur supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du professeur: " + e.getMessage());
        }
    }

    // Méthode pour récupérer tous les professeurs
    public static List<Professeur> getTousLesProfesseurs() throws SQLException {
        String sql = "SELECT * FROM Professeur";
        List<Professeur> professeurs = new ArrayList<>();
        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Professeur professeur = new Professeur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        rs.getString("type_utilisateur"),
                        rs.getString("departement")
                );
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des professeurs: " + e.getMessage());
        }
        return professeurs;
    }
}
