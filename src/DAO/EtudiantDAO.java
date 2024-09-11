package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.Métier.Etudiant;


public class EtudiantDAO {

    public static void ajouterEtudiant(Etudiant etudiant) {
        String sql = "INSERT INTO Etudiant (nom, prenom, matricule) VALUES (?, ?, ?)";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, etudiant.getNom());
            pstmt.setString(2, etudiant.getPrenom());
            pstmt.setString(3, etudiant.getMatricule());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public  static  Etudiant obtenirEtudiant(String matricule) {
        String sql = "SELECT id, nom, prenom, matricule FROM Etudiant WHERE matricule = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, matricule);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String mat = rs.getString("matricule");

                return new Etudiant(nom, prenom, mat);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void mettreAJourEtudiant(Etudiant etudiant, String matricule) {
        String sql = "UPDATE Etudiant SET nom = ?, prenom = ?, matricule = ? WHERE matricule = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, etudiant.getNom());
            pstmt.setString(2, etudiant.getPrenom());
            pstmt.setString(3, etudiant.getMatricule());
            pstmt.setString(4, matricule);  // Utilisation du matricule pour la clause WHERE

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public  static  void supprimerEtudiant(String matricule) {
        String sql = "DELETE FROM Etudiant WHERE matricule = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, matricule);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
