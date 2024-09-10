package DAO;

import Métier.Document;

import java.sql.Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Métier.*;

public class DocumentDAO {




    public void ajouterDocument(Document document) throws SQLException {
        String sql = "INSERT INTO documents (titre, auteur, date_publication, nombre_pages, etat) VALUES (?, ?, ?, ?, ?) RETURNING id";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Ajouter les champs communs
            stmt.setString(1, document.getTitre());
            stmt.setString(2, document.getAuteur());
            stmt.setDate(3, Date.valueOf(document.getDateDePublication()));
            stmt.setInt(4, document.getNombreDePages());
            stmt.setString(5, document.getEtat());

            // Exécuter la requête et obtenir l'ID généré
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                long idDocument = rs.getLong(1);
                document.setId(idDocument);

                // Vérifier le type du document et insérer dans la table correspondante
                if (document instanceof Livre) {
                    ajouterLivre((Livre) document, conn);
                } else if (document instanceof Magazine) {
                    ajouterMagazine((Magazine) document, conn);
                }
            }
        }
    }





}
