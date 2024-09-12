package src.Métier;

import src.DAO.ProfesseurDAO;

import java.util.Scanner;

public class Professeur extends Utilisateur {
    private String specialite;

    public Professeur(String nom, String prenom,String specialite) {
        super(nom,prenom);
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public void afficherDetails() {

    }


    public static Professeur saisirProfesseur() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ajout d'un nouveau professeur :");
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Département : ");
        String specialite = scanner.nextLine();

        Professeur professeur = new Professeur(nom, prenom, specialite);

        return  professeur;

    }


    public static void modifierProfesseur() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID du professeur à modifier: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Professeur professeur = ProfesseurDAO.getProfesseurById(id);
        if (professeur != null) {
            System.out.println("Saisissez les nouvelles informations pour ce professeur.");
            professeur = saisirProfesseur();
            ProfesseurDAO.mettreAJourProfesseur(professeur, id);
            System.out.println("Professeur modifié avec succès.");
        } else {
            System.out.println("Professeur non trouvé.");
        }
    }


}
