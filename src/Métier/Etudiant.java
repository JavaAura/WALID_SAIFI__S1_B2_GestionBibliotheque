package src.Métier;

import src.DAO.EtudiantDAO;
import src.Utilitaire.InputValidator;

import java.util.Scanner;

public class Etudiant extends Utilisateur {
    private String matricule;

    public Etudiant(int id,String nom, String prenom, String matricule) {
        super(nom, id, prenom);
        this.matricule = matricule;
    }

    public Etudiant(String nom, String prenom, String matricule) {
        super(nom, prenom);
        this.matricule = matricule;
    }


    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     *
     */
    @Override
    public void afficherDetails() {

    }

    public static Etudiant saisirEtudiant() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom de l'étudiant : ");
        String nom = scanner.nextLine();
        String nomValider = InputValidator.validateString(nom);

        System.out.print("Entrez le prénom de l'étudiant : ");
        String prenom = scanner.nextLine();
        String prenomValider  = InputValidator.validateString(prenom);
        System.out.print("Entrez le matricule de l'étudiant : ");
        String matricule = scanner.nextLine();


        Etudiant etudiant = new Etudiant(nomValider, prenomValider, matricule);

        return  etudiant;

    }



}
