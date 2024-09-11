package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.Métier.Etudiant;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
            pstmt.setString(4, matricule);

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



    public static List<Etudiant> obtenirTousLesEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "SELECT id, nom, prenom, matricule FROM Etudiant";

        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String matricule = rs.getString("matricule");

                Etudiant etudiant = new Etudiant(id, nom, prenom, matricule);
                 etudiants.add(etudiant);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return etudiants;
    }


    public static void afficherTousLesEtudiants() {
        List<Etudiant> etudiants = obtenirTousLesEtudiants();
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant trouvé.");
        } else {
            for (Etudiant etudiant : etudiants) {
                System.out.println("Détails de l'étudiant:");
                System.out.println("ID: " + etudiant.getId());
                System.out.println("Nom: " + etudiant.getNom());
                System.out.println("Prénom: " + etudiant.getPrenom());
                System.out.println("Matricule: " + etudiant.getMatricule());
                System.out.println();
            }
        }
    }




}
