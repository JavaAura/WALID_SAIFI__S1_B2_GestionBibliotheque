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
        scanner.nextLine();

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

    public static void modifierUtilisateur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel type d'utilisateur voulez-vous modifier ?");
        System.out.println("1- Étudiant");
        System.out.println("2- Professeur");
        System.out.print("Votre choix: ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                System.out.print("Entrez le matricule de l'étudiant à modifier: ");
                String matricule = scanner.nextLine();
                Etudiant etudiant = EtudiantDAO.obtenirEtudiant(matricule);
                if (etudiant != null) {
                    etudiant = Etudiant.saisirEtudiant();
                    EtudiantDAO.mettreAJourEtudiant(etudiant, matricule);
                } else {
                    System.out.println("Étudiant non trouvé.");
                }
                break;

            case 2:
                System.out.print("Entrez l'ID du professeur à modifier: ");
                int idProfesseur = scanner.nextInt();
                scanner.nextLine();
                Professeur professeur = ProfesseurDAO.getProfesseurById(idProfesseur);
                if (professeur != null) {
                    professeur = Professeur.saisirProfesseur();
                    ProfesseurDAO.mettreAJourProfesseur(professeur, idProfesseur);
                } else {
                    System.out.println("Professeur non trouvé.");
                }
                break;

            default:
                System.out.println("Choix invalide.");
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
