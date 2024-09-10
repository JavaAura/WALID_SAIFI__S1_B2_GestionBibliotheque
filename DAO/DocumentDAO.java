package DAO;

import Métier.Document;

import java.sql.Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Métier.*;

public class DocumentDAO {


    public void ajouterDocument(Document document) {
        String sqlDocument = "INSERT INTO document (titre, auteur, date_de_publication, nombre_de_pages, etat) VALUES (?, ?, ?, ?, ?) RETURNING id";
        String sqlLivre = "INSERT INTO livre (id, isbn) VALUES (?, ?)";
        String sqlMagazine = "INSERT INTO magazine (id, numero) VALUES (?, ?)";

        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmtDocument = conn.prepareStatement(sqlDocument);
             PreparedStatement pstmtLivre = conn.prepareStatement(sqlLivre);
             PreparedStatement pstmtMagazine = conn.prepareStatement(sqlMagazine)) {


            pstmtDocument.setString(1, document.getTitre());
            pstmtDocument.setString(2, document.getAuteur());
            pstmtDocument.setDate(3, Date.valueOf(document.getDateDePublication()));
            pstmtDocument.setInt(4, document.getNombreDePages());
            pstmtDocument.setString(5, document.getEtat());

            ResultSet rs = pstmtDocument.executeQuery();
            if (rs.next()) {
                long id = rs.getLong("id");
                document.setId(id);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }






}
