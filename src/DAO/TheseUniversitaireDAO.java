package src.DAO;

import java.sql.*;
import src.Métier.TheseUniversitaire;

public class TheseUniversitaireDAO {


    public static void ajouterTheseUniversitaire(TheseUniversitaire these) {
        String sql = "INSERT INTO TheseUniversitaire (titre, auteur, date_de_publication, nombre_de_pages, universite, domaine) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, these.getTitre());
            stmt.setString(2, these.getAuteur());
            stmt.setDate(3, Date.valueOf(these.getDateDePublication()));
            stmt.setInt(4, these.getNombreDePages());
            stmt.setString(5, these.getUniversite());
            stmt.setString(6, these.getDomaine());

            stmt.executeUpdate();
            System.out.println("Thèse universitaire ajoutée avec succès.");

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la thèse universitaire : " + e.getMessage());
        }
    }


    public static void modifierTheseUniversitaire(int id, TheseUniversitaire these) {
        String sql = "UPDATE TheseUniversitaire SET titre = ?, auteur = ?, date_de_publication = ?, nombre_de_pages = ?, universite = ?, domaine = ? WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, these.getTitre());
            stmt.setString(2, these.getAuteur());
            stmt.setDate(3, Date.valueOf(these.getDateDePublication()));
            stmt.setInt(4, these.getNombreDePages());
            stmt.setString(5, these.getUniversite());
            stmt.setString(6, these.getDomaine());
            stmt.setInt(7, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thèse universitaire mise à jour avec succès.");
            } else {
                System.out.println("Aucune thèse universitaire trouvée avec l'ID spécifié pour mise à jour.");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de la thèse universitaire : " + e.getMessage());
        }
    }


    public static void supprimerTheseUniversitaire(int id) {
        String sql = "DELETE FROM TheseUniversitaire WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thèse universitaire supprimée avec succès.");
            } else {
                System.out.println("Aucune thèse universitaire trouvée avec l'ID spécifié pour suppression.");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la thèse universitaire : " + e.getMessage());
        }
    }

    public static void afficherToutesLesThesesUniversitaires() {
        System.out.println("--------------------------------------------Liste des Thèses Universitaires----------------------------------------- ");
        String sql = "SELECT * FROM TheseUniversitaire";

        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String titre = rs.getString("titre");
                String auteur = rs.getString("auteur");
                Date dateDePublication = rs.getDate("date_de_publication");
                int nombreDePages = rs.getInt("nombre_de_pages");
                String universite = rs.getString("universite");
                String domaine = rs.getString("domaine");
                String etatDocument = rs.getString("etatDocument");
                boolean reserve = rs.getBoolean("reserve");

                System.out.println(String.format("ID: %d, Titre: %s, Auteur: %s, Date de publication: %s, Nombre de pages: %d, Université: %s, Domaine: %s, État: %s, Réservé: %b",
                        id, titre, auteur, dateDePublication.toLocalDate(), nombreDePages, universite, domaine, etatDocument, reserve));
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des Thèses Universitaires : " + e.getMessage());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------- ");
    }
}
