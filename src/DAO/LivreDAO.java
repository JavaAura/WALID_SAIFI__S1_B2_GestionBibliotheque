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

}
