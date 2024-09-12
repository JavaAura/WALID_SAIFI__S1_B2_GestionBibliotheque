package src.Présentation;
import java.sql.SQLException;
import java.time.LocalDate;
import  src.DAO.*;

import src.Métier.*;


public class main {

    public static void main(String[] args) throws SQLException {

      Livre l1 = new Livre(
                "test",
                "YouCode",
                LocalDate.of(1954, 7, 29),
                1178,
                "0369741258745");// ISBN de 13 caractères);

       //  Professeur pr = new Professeur("walid","saifi","info");
       // Etudiant e = new Etudiant("oumaima","SAIFI","K148");

       // ProfesseurDAO.ajouterProfesseur(pr);


        LivreDAO.modifierLivre(1,l1);

     // EtudiantDAO.afficherEtudiantDetails();
       // EtudiantDAO.ajouterEtudiant(e);
       // EtudiantDAO.afficherTousLesEtudiants();
        //ProfesseurDAO.afficherTousLesProfesseurs();
       // UtilisateurDAO.afficherToutUtilisateur();
      //  LivreDAO.afficherTousLesLivres();
       //MagazineDAO.afficherTousLesMagazines();
    }


}




