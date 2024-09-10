package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Métier.Livre;

import Métier.Livre;
import Métier.Magazine;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DocumentDAO {



        public static void ajouterLivre(Livre livre) throws SQLException {
            String sql = "INSERT INTO Livre (titre, auteur, date_de_publication, nombre_de_pages, etat, isbn) VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection conn = dbConnection.connect();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                // Ajouter les champs du livre
                stmt.setString(1, livre.getTitre());
                stmt.setString(2, livre.getAuteur());
                stmt.setDate(3, Date.valueOf(livre.getDateDePublication()));
                stmt.setInt(4, livre.getNombreDePages());
                stmt.setString(5, livre.getEtat());

                // Vérifier la longueur de l'ISBN
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

    public static void ajouterMagazine(Magazine magazine) throws SQLException {
        String sql = "INSERT INTO Magazine (titre, auteur, date_de_publication, nombre_de_pages, etat, numero) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, magazine.getTitre());
            stmt.setString(2, magazine.getAuteur());
            stmt.setDate(3, Date.valueOf(magazine.getDateDePublication()));
            stmt.setInt(4, magazine.getNombreDePages());
            stmt.setString(5, magazine.getEtat());
            stmt.setInt(6, magazine.getNuméro());

            stmt.executeUpdate();
        }
    }

    public static Magazine getMagazineById(int id) throws SQLException {
        String sql = "SELECT * FROM Magazine WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Magazine(
                            rs.getString("titre"),
                            rs.getString("auteur"),
                            rs.getDate("date_de_publication").toLocalDate(),
                            rs.getInt("nombre_de_pages"),
                            rs.getInt("numero"),
                            rs.getString("etat")
                    );
                }
            }
        }
        return null;
    }


    public static List<Magazine> getAllMagazines() throws SQLException {
        List<Magazine> magazines = new ArrayList<>();
        String sql = "SELECT * FROM Magazine";
        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                magazines.add(new Magazine(
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getDate("date_de_publication").toLocalDate(),
                        rs.getInt("nombre_de_pages"),
                        rs.getInt("numero"),
                        rs.getString("etat")
                ));
            }
        }
        return magazines;
    }


    public static void modifierMagazine(int id, Magazine magazine) throws SQLException {
        String sql = "UPDATE Magazine SET titre = ?, auteur = ?, date_de_publication = ?, nombre_de_pages = ?, etat = ?, numero = ? WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, magazine.getTitre());
            stmt.setString(2, magazine.getAuteur());
            stmt.setDate(3, Date.valueOf(magazine.getDateDePublication()));
            stmt.setInt(4, magazine.getNombreDePages());
            stmt.setString(5, magazine.getEtat());
            stmt.setInt(6, magazine.getNuméro());
            stmt.setInt(7, id);

            stmt.executeUpdate();
        }
    }



    public static void supprimerMagazine(int id) throws SQLException {
        String sql = "DELETE FROM Magazine WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


}



