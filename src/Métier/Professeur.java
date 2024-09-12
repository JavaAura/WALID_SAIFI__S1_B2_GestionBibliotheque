package src.Métier;

import src.DAO.EtudiantDAO;
import src.DAO.ProfesseurDAO;

import java.util.Scanner;

public class Professeur extends Utilisateur {
    private String specialite;

    public Professeur(String nom, String prenom, String specialite) {
        super(nom, prenom);
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

        return professeur;

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


    public static void supprimerUtilisateur() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel type d'utilisateur voulez-vous supprimer ?");
        System.out.println("1- Étudiant");
        System.out.println("2- Professeur");
        System.out.print("Votre choix: ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                System.out.print("Entrez le matricule de l'étudiant à supprimer: ");
                String matricule = scanner.nextLine();
                EtudiantDAO.supprimerEtudiant(matricule);
                break;
            case 2:
                System.out.print("Entrez l'ID du professeur à supprimer: ");
                int id = scanner.nextInt();
                ProfesseurDAO.supprimerProfesseur(id);
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }


    }
}
