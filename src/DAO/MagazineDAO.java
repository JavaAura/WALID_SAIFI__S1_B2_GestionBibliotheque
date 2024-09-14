package src.DAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static void modifierMagazine(Magazine magazine, int id) {
        String sql = "UPDATE Magazine SET titre = ?, auteur = ?, date_de_publication = ?, nombre_de_pages = ?, numero = ? WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, magazine.getTitre());
            stmt.setString(2, magazine.getAuteur());
            stmt.setDate(3, Date.valueOf(magazine.getDateDePublication()));  // Conversion de LocalDate en java.sql.Date
            stmt.setInt(4, magazine.getNombreDePages());
            stmt.setInt(5, magazine.getNuméro());
            stmt.setInt(6, id);


            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Aucun magazine trouvé avec l'ID spécifié pour mise à jour.");
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


    public static void afficherTousLesMagazines() {
        System.out.println("----------------------------------------------Liste des Magazines-------------------------------------------------------------");
        String sql = "SELECT * FROM Magazine";

        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String titre = rs.getString("titre");
                String auteur = rs.getString("auteur");
                Date dateDePublication = rs.getDate("date_de_publication");
                int nombreDePages = rs.getInt("nombre_de_pages");
                int numero = rs.getInt("numero");


                System.out.println(String.format("ID: %d, Titre: %s, Auteur: %s, Date de publication: %s, Nombre de pages: %d, Numéro: %d",
                        id, titre, auteur, dateDePublication.toLocalDate(), nombreDePages, numero));
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des magazines : " + e.getMessage());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }





}