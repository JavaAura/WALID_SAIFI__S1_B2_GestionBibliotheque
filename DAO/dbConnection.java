package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/biblio";

    private static final String USER = "postgres";

    private static final String PASSWORD = "123";


    public static Connection connect(){
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


}
