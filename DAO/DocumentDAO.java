package DAO;

import Métier.Document;

import java.sql.Connection;

public class DocumentDAO {


    private static final String URL = "jdbc:postgresql://localhost:5432/biblio";

    private static final String USER = "postgres";

    private static final String PASSWORD = "123";


    public void ajouterDocument(Document document){
        String sql = "INSERT INTO documents (titre, auteur, date_publication, nombre_pages, etat) VALUES (?, ?, ?, ?, ?) ";
    }


}
