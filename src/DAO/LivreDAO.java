package src.DAO;

import java.sql.*;

import src.Métier.*;

public class LivreDAO {




    public static void ajouterLivre(Livre livre) {

        String sql = "INSERT INTO Livre (titre, auteur, date_de_publication, nombre_de_pages, isbn) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setDate(3, Date.valueOf(livre.getDateDePublication()));
            stmt.setInt(4, livre.getNombreDePages());

            String isbn = livre.getIsbn();

            if (isbn.length() > 13) {
                throw new IllegalArgumentException("L'ISBN dépasse la longueur maximale autorisée.");
            }
            stmt.setString(5, isbn);


            stmt.executeUpdate();
        } catch (SQLException e) {

            System.err.println("Erreur lors de l'ajout du livre : " + e.getMessage());

        }


    }



    public static void modifierLivre(int id, Livre livre) {
        String sql = "UPDATE Livre SET titre = ?, auteur = ?, date_de_publication = ?, nombre_de_pages = ?, isbn = ? WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setDate(3, Date.valueOf(livre.getDateDePublication()));
            stmt.setInt(4, livre.getNombreDePages());
            stmt.setString(5, livre.getIsbn());
            stmt.setInt(6, id);

            // Exécution de la mise à jour
            stmt.executeUpdate();
            System.out.println("Livre mis à jour avec succès.");

        } catch (SQLException e) {

            System.err.println("Erreur lors de la modification du livre : " + e.getMessage());

        }
    }


    public static void supprimerLivre(int id) throws SQLException {
        String sql = "DELETE FROM Livre WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


    public static void afficherTousLesLivres() {
        System.out.println("---------------------------------------------------Liste des Livre:----------------------------------------------------------------------");
        String sql = "SELECT * FROM Livre";

        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String titre = rs.getString("titre");
                String auteur = rs.getString("auteur");
                Date dateDePublication = rs.getDate("date_de_publication");
                int nombreDePages = rs.getInt("nombre_de_pages");
                String isbn = rs.getString("isbn");

                System.out.println(String.format("ID: %d, Titre: %s, Auteur: %s, Date de publication: %s, Nombre de pages: %d, ISBN: %s",
                        id, titre, auteur, dateDePublication.toLocalDate(), nombreDePages, isbn));
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des livres : " + e.getMessage());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    }





}
