package src.Métier;
import src.DAO.JournalScientifiqueDAO;

import java.time.LocalDate;
import java.util.Scanner;


public class JournalScientifique extends Document {
        private String domaineRecherche;

        public JournalScientifique(String titre, String auteur, LocalDate dateDePublication, int nombreDePages, String etat, boolean reserve, String domaineRecherche) {
            super(titre, auteur, dateDePublication, nombreDePages, etat, reserve);
            this.domaineRecherche = domaineRecherche;
        }

        public JournalScientifique(String titre, String auteur, LocalDate dateDePublication, int nombreDePages, String domaineRecherche) {
            super(titre, auteur, dateDePublication, nombreDePages);
            this.domaineRecherche = domaineRecherche;
        }


    public static JournalScientifique saisirJournalScientifique() {
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
        System.out.print("Domaine de recherche: ");
        String domaineRecherche = scanner.nextLine();

        return new JournalScientifique(titre, auteur, dateDePublication, nombreDePages, domaineRecherche);
    }

    public static void modifierJournalScientifique(int id) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Modification du journal scientifique avec ID: " + id);
        System.out.println("Entrez le nouveau titre : ");
        String titre = scanner.nextLine();
        System.out.println("Entrez le nouvel auteur : ");
        String auteur = scanner.nextLine();
        System.out.println("Entrez la nouvelle date de publication (format: yyyy-mm-dd) : ");
        LocalDate dateDePublication = LocalDate.parse(scanner.nextLine());
        System.out.println("Entrez le nouveau nombre de pages : ");
        int nombreDePages = scanner.nextInt();
        scanner.nextLine();  // Consomme la ligne restante
        System.out.println("Entrez le nouveau domaine de recherche : ");
        String domaineRecherche = scanner.nextLine();

        JournalScientifique journal = new JournalScientifique(titre, auteur, dateDePublication, nombreDePages, domaineRecherche);

        JournalScientifiqueDAO.modifierJournalScientifique(id, journal);
    }

    public void setDomaineRecherche(String domaineRecherche) {
            this.domaineRecherche = domaineRecherche;
        }

        public String getDomaineRecherche() {
            return domaineRecherche;
        }

        @Override
        public void afficherDetails() {
            System.out.println("Journal Scientifique - Domaine: " + domaineRecherche + ", Titre: " + titre + ", Auteur: " + auteur);
        }
    }

