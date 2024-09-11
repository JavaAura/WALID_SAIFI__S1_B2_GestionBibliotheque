package src.Présentation;
import java.sql.SQLException;
import java.time.LocalDate;
import  src.DAO.*;

import src.Métier.*;


public class main {

    public static void main(String[] args) throws SQLException {

      /*  Livre livre1 = new Livre(
                "Youcode",
                "walid",
                LocalDate.of(1954, 7, 29),
                1178,
                "1234568521214", // ISBN de 13 caractères
                "disponible"
        );
*/
        Professeur pr = new Professeur("walid","saifi","info");


        // LivreDAO.ajouterLivre(livre1);
        ProfesseurDAO.supprimerProfesseur(1);
        System.out.println("test");
    }


}




