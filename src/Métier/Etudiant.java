package src.Métier;

import src.DAO.EtudiantDAO;

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

        System.out.print("Entrez le prénom de l'étudiant : ");
        String prenom = scanner.nextLine();

        System.out.print("Entrez le matricule de l'étudiant : ");
        String matricule = scanner.nextLine();

        Etudiant etudiant = new Etudiant(nom, prenom, matricule);

        return  etudiant;

    }



    public static void modifierEtudiant() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le matricule de l'étudiant à modifier: ");
        String matricule = scanner.nextLine();

        Etudiant etudiant = EtudiantDAO.obtenirEtudiant(matricule);
        if (etudiant != null) {
            System.out.println("Saisissez les nouvelles informations pour cet étudiant.");
            etudiant = saisirEtudiant();
            EtudiantDAO.mettreAJourEtudiant(etudiant, matricule);
            System.out.println("Étudiant modifié avec succès.");
        } else {
            System.out.println("Étudiant non trouvé.");
        }
    }


}
