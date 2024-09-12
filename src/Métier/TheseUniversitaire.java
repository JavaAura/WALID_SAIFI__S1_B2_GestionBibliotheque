package src.Métier;
import src.DAO.TheseUniversitaireDAO;

import java.time.LocalDate;
import java.util.Scanner;

public class TheseUniversitaire extends Document {


        private String universite;
        private String domaine;

    public TheseUniversitaire(String titre, String auteur, LocalDate dateDePublication, int nombreDePages, String etat, boolean reserve, String universite, String domaine) {
        super(titre, auteur, dateDePublication, nombreDePages, etat, reserve);
        this.universite = universite;
        this.domaine = domaine;
    }

    public TheseUniversitaire(String titre, String auteur, LocalDate dateDePublication, int nombreDePages, String universite, String domaine) {
        super(titre, auteur, dateDePublication, nombreDePages);
        this.universite = universite;
        this.domaine = domaine;
    }

    public static TheseUniversitaire saisirTheseUniversitaire() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Titre: ");
        String titre = scanner.nextLine();
        System.out.print("Auteur: ");
        String auteur = scanner.nextLine();
        System.out.print("Date de publication (yyyy-mm-dd): ");
        LocalDate dateDePublication = LocalDate.parse(scanner.nextLine());
        System.out.print("Nombre de pages: ");
        int nombreDePages = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Université: ");
        String universite = scanner.nextLine();
        System.out.print("Domaine: ");
        String domaine = scanner.nextLine();

        return new TheseUniversitaire(titre, auteur, dateDePublication, nombreDePages, universite, domaine);
    }

    public static void modifierTheseUniversitaire(int id) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Modification de la thèse universitaire avec ID: " + id);
        System.out.println("Entrez le nouveau titre : ");
        String titre = scanner.nextLine();
        System.out.println("Entrez le nouvel auteur : ");
        String auteur = scanner.nextLine();
        System.out.println("Entrez la nouvelle date de publication (format: yyyy-mm-dd) : ");
        LocalDate dateDePublication = LocalDate.parse(scanner.nextLine());
        System.out.println("Entrez le nouveau nombre de pages : ");
        int nombreDePages = scanner.nextInt();
        scanner.nextLine();  // Consomme la ligne restante
        System.out.println("Entrez la nouvelle université : ");
        String universite = scanner.nextLine();
        System.out.println("Entrez le nouveau domaine : ");
        String domaine = scanner.nextLine();

        TheseUniversitaire these = new TheseUniversitaire(titre, auteur, dateDePublication, nombreDePages, universite, domaine);

        TheseUniversitaireDAO.modifierTheseUniversitaire(id, these);
    }

    public static void supprimerTheseUniversitaire(int id) {
    }

    @Override
        public void afficherDetails() {
            System.out.println("Thèse Universitaire - Université: " + universite
                    + ", Domaine: " + domaine
                    + ", Titre: " + getTitre()
                    + ", Auteur: " + getAuteur()
                    + ", Date de publication: " + getDateDePublication()
                    + ", Nombre de pages: " + getNombreDePages()
                    + ", État: " + getEtat());
        }


        public String getUniversite() {
            return universite;
        }

        public void setUniversite(String universite) {
            this.universite = universite;
        }

        public String getDomaine() {
            return domaine;
        }

        public void setDomaine(String domaine) {
            this.domaine = domaine;
        }


    public static void supprimerTheseUniversitaireT(int id) {
        TheseUniversitaireDAO.supprimerTheseUniversitaire(id);
        System.out.println("La thèse universitaire avec l'ID " + id + " a été supprimée.");
    }
}

