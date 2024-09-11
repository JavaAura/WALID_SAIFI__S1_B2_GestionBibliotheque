package src.DAO;

import src.Métier.Professeur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesseurDAO {


    public static void ajouterProfesseur(Professeur professeur) {
        String sql = "INSERT INTO Professeur (nom, prenom, departement) VALUES (?, ?, ?)";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, professeur.getNom());
            pstmt.setString(2, professeur.getPrenom());
            pstmt.setString(3, professeur.getSpecialite());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static Professeur getProfesseurById(int id) {
        Professeur professeur = null;
        String sql = "SELECT * FROM Professeur WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String specialite = rs.getString("specialite");
                professeur = new Professeur(nom, prenom, specialite);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return professeur;
    }


    public static void mettreAJourProfesseur(Professeur professeur,int id) {
        String sql = "UPDATE Professeur SET nom = ?, prenom = ?, departement = ? WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, professeur.getNom());
            pstmt.setString(2, professeur.getPrenom());
            pstmt.setString(3, professeur.getSpecialite());
            pstmt.setInt(4,id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void supprimerProfesseur(int id) {
        String sql = "DELETE FROM Professeur WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Professeur> obtenirTousLesProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        String sql = "SELECT * FROM Professeur";

        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String specialite = rs.getString("departement");

                Professeur professeur = new Professeur(nom, prenom, specialite);
                professeur.setId(id); // Assurez-vous que Professeur a une méthode setId()
                professeurs.add(professeur);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return professeurs;
    }


    public static void afficherTousLesProfesseurs() {
        System.out.println("Détails du professeur:");
        List<Professeur> professeurs = obtenirTousLesProfesseurs();
        if (professeurs.isEmpty()) {
            System.out.println("Aucun professeur trouvé.");
        } else {
            for (Professeur professeur : professeurs) {
                System.out.println("------------------------------");
                System.out.println("ID: " + professeur.getId());
                System.out.println("Nom: " + professeur.getNom());
                System.out.println("Prénom: " + professeur.getPrenom());
                System.out.println("Département: " + professeur.getSpecialite());
                System.out.println();
            }
        }
    }
}
