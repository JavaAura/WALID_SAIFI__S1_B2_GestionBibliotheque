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
        Etudiant e = new Etudiant("oumaima","SAIFI","K148");
        Etudiant e1 = new Etudiant("walidl","SAIFI","K855");
        Etudiant e2 = new Etudiant("manal","SAIFI","K246");


        //LivreDAO.ajouterLivre(livre1);

     // EtudiantDAO.afficherEtudiantDetails();
        EtudiantDAO.ajouterEtudiant(e);
        EtudiantDAO.afficherTousLesEtudiants();
        System.out.println("test");
    }


}




