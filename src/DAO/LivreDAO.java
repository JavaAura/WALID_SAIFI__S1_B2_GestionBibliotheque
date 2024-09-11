package src.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import src.Métier.*;

public class LivreDAO {


    public static void ajouterLivre(Livre livre) throws SQLException {
        String sql = "INSERT INTO Livre (titre, auteur, date_de_publication, nombre_de_pages, etat, isbn) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setDate(3, Date.valueOf(livre.getDateDePublication()));
            stmt.setInt(4, livre.getNombreDePages());
            stmt.setString(5, livre.getEtat());


            String isbn = livre.getIsbn();
            if (isbn.length() > 13) {
                throw new IllegalArgumentException("L'ISBN dépasse la longueur maximale autorisée.");
            }
            stmt.setString(6, isbn);

            stmt.executeUpdate();
        }
    }

    public static void modifierLivre(int id, Livre livre) throws SQLException {
        String sql = "UPDATE Livre SET titre = ?, auteur = ?, date_de_publication = ?, nombre_de_pages = ?, etat = ?, isbn = ? WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setDate(3, Date.valueOf(livre.getDateDePublication()));
            stmt.setInt(4, livre.getNombreDePages());
            stmt.setString(5, livre.getEtat());
            stmt.setString(6, livre.getIsbn());
            stmt.setInt(7, id);

            stmt.executeUpdate();
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


    public static List<Livre> obtenirTousLesLivres() {
        List<Livre> livres = new ArrayList<>();
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
                String etat = rs.getString("etat");
                String isbn = rs.getString("isbn");

                Livre livre = new Livre(titre, auteur, dateDePublication.toLocalDate(), nombreDePages, etat, isbn);
                livre.setId(id);
                livres.add(livre);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return livres;
    }


    public static void afficherTousLesLivres() {
        System.out.println("Détails du livre:");
        List<Livre> livres = obtenirTousLesLivres();
        if (livres.isEmpty()) {
            System.out.println("Aucun livre trouvé.");
        } else {
            for (Livre livre : livres) {
                System.out.println("---------------------------");
                System.out.println("ID: " + livre.getId());
                System.out.println("Titre: " + livre.getTitre());
                System.out.println("Auteur: " + livre.getAuteur());
                System.out.println("Date de publication: " + livre.getDateDePublication());
                System.out.println("Nombre de pages: " + livre.getNombreDePages());
                System.out.println("État: " + livre.getEtat());
                System.out.println("ISBN: " + livre.getIsbn());
                System.out.println();
            }
        }
    }

}
