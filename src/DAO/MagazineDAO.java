package src.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import src.Métier.*;

public class MagazineDAO {


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