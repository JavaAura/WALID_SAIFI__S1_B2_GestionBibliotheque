package src.Métier;
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

