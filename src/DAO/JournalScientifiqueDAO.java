package src.DAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

import src.Métier.JournalScientifique;

public class JournalScientifiqueDAO {


    public static void ajouterJournalScientifique(JournalScientifique journal) {
        String sql = "INSERT INTO JournalScientifique (titre, auteur, date_de_publication, nombre_de_pages, domaine_recherche) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, journal.getTitre());
            stmt.setString(2, journal.getAuteur());
            stmt.setDate(3, Date.valueOf(journal.getDateDePublication()));
            stmt.setInt(4, journal.getNombreDePages());
            stmt.setString(5, journal.getDomaineRecherche());
            stmt.executeUpdate();
            System.out.println("Journal Scientifique ajouté avec succès.");

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du Journal Scientifique : " + e.getMessage());
        }
    }


    public static void modifierJournalScientifique(int id, JournalScientifique journal) {
        String sql = "UPDATE JournalScientifique SET titre = ?, auteur = ?, date_de_publication = ?, nombre_de_pages = ?, domaine_recherche = ? WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, journal.getTitre());
            stmt.setString(2, journal.getAuteur());
            stmt.setDate(3, Date.valueOf(journal.getDateDePublication()));
            stmt.setInt(4, journal.getNombreDePages());
            stmt.setString(5, journal.getDomaineRecherche());
            stmt.setInt(6, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Journal Scientifique mis à jour avec succès.");
            } else {
                System.out.println("Aucun Journal Scientifique trouvé avec l'ID spécifié.");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du Journal Scientifique : " + e.getMessage());
        }
    }


    public static void supprimerJournalScientifique(int id) {
        String sql = "DELETE FROM JournalScientifique WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Journal Scientifique supprimé avec succès.");
            } else {
                System.out.println("Aucun Journal Scientifique trouvé avec l'ID spécifié.");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du Journal Scientifique : " + e.getMessage());
        }
    }


    public static void afficherTousLesJournauxScientifiques() {
        System.out.println("--------------------------------------------Liste des JournauxScientifiques----------------------------------------- ");
        String sql = "SELECT * FROM JournalScientifique";

        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String titre = rs.getString("titre");
                String auteur = rs.getString("auteur");
                Date dateDePublication = rs.getDate("date_de_publication");
                int nombreDePages = rs.getInt("nombre_de_pages");
                String domaineRecherche = rs.getString("domaine_recherche");


                System.out.println(String.format("ID: %d, Titre: %s, Auteur: %s, Date de publication: %s, Nombre de pages: %d, Domaine de recherche: %s",
                        id, titre, auteur, dateDePublication.toLocalDate(), nombreDePages, domaineRecherche));
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des Journaux Scientifiques : " + e.getMessage());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------- ");
    }



}
