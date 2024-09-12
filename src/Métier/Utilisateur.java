package src.Métier;

import src.DAO.EtudiantDAO;
import src.DAO.ProfesseurDAO;

import java.util.Scanner;

public abstract class Utilisateur {
    protected  int id;
    protected String nom;
    protected String prenom;

    public Utilisateur(String nom, int id, String prenom) {
        this.nom = nom;
        this.id = id;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public Utilisateur(String nom, String prenom) {
        this.nom =nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public abstract void afficherDetails();


    public static void ajouterUtilisateur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel type d'utilisateur voulez-vous ajouter ?");
        System.out.println("1- Étudiant");
        System.out.println("2- Professeur");
        System.out.print("Votre choix: ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        switch (choix) {
            case 1:

                Etudiant etudiant = Etudiant.saisirEtudiant();
                EtudiantDAO.ajouterEtudiant(etudiant);
                break;

            case 2:
                Professeur professeur = Professeur.saisirProfesseur();
                ProfesseurDAO.ajouterProfesseur(professeur);
                break;

            default:
                System.out.println("Choix invalide.");
        }
    }

}
