package Présentation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import  DAO.*;

import  DAO.DocumentDAO;

import Métier.*;


public class main {

    public static void main(String[] args) throws SQLException {

        Livre livre1 = new Livre(
                "Youcode",
                "walid",
                LocalDate.of(1954, 7, 29),
                1178,
                "1234567893214", // ISBN de 13 caractères
                "disponible"
        );

        try {
            LivreDAO.ajouterLivre(livre1);
            System.out.println("test");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}




