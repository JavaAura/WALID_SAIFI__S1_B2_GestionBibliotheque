package src.Présentation;
import java.sql.SQLException;
import java.time.LocalDate;
import  src.DAO.*;

import src.Métier.*;


public class main {

    public static void main(String[] args) throws SQLException {

        // Création des objets Livre
        Livre l1 = new Livre(
                "Le Petit Prince",
                "Antoine de Saint-Exupéry",
                LocalDate.of(1943, 4, 6),
                96,
                "9780156012195");

        Livre l2 = new Livre(
                "1984",
                "George Orwell",
                LocalDate.of(1949, 6, 8),
                328,
                "9780451524935");

        Livre l3 = new Livre(
                "La Peste",
                "Albert Camus",
                LocalDate.of(1947, 6, 10),
                307,
                "9782070363027");

        Livre l4 = new Livre(
                "Moby Dick",
                "Herman Melville",
                LocalDate.of(1851, 10, 18),
                635,
                "123456789012");



        LivreDAO.supprimerLivre(1);
    }


}




