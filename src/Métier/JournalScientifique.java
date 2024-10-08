package src.Métier;
import src.DAO.JournalScientifiqueDAO;
import src.DAO.TheseUniversitaireDAO;
import src.Utilitaire.InputValidator;

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
        String titreValider = InputValidator.validateString(titre);
        System.out.print("Auteur: ");
        String auteur = scanner.nextLine();
        String auteurValider  = InputValidator.validateString(auteur);
        LocalDate dateDePublication = InputValidator.validateDate();
        System.out.print("Nombre de pages: ");
        int nombreDePages = scanner.nextInt();
        scanner.nextLine();
        int nombreDePagesValider  = InputValidator.validateInt(nombreDePages);
        System.out.print("Domaine de recherche: ");
        String domaineRecherche = scanner.nextLine();
        String  domaineRechercheValider = InputValidator.validateString(domaineRecherche);
        return new JournalScientifique(titreValider, auteurValider, dateDePublication, nombreDePagesValider, domaineRechercheValider);
    }

    public static void modifierJournalScientifique(int id) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Modification du journal scientifique avec ID: " + id);
        System.out.println("Entrez le nouveau titre : ");
        String titre = scanner.nextLine();
        String titreValider = InputValidator.validateString(titre);
        System.out.println("Entrez le nouvel auteur : ");
        String auteur = scanner.nextLine();
        String auteurValider  = InputValidator.validateString(auteur);
        LocalDate dateDePublication = InputValidator.validateDate();
        System.out.println("Entrez le nouveau nombre de pages : ");
        int nombreDePages = scanner.nextInt();
        int nombreDePagesValider  = InputValidator.validateInt(nombreDePages);
        scanner.nextLine();
        System.out.println("Entrez le nouveau domaine de recherche : ");
        String domaineRecherche = scanner.nextLine();
        String  domaineRechercheValider = InputValidator.validateString(domaineRecherche);

        JournalScientifique journal = new JournalScientifique(titreValider, auteurValider, dateDePublication, nombreDePagesValider, domaineRechercheValider);

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

    public static void supprimerJournalScientifique(int id) {
        JournalScientifiqueDAO.supprimerJournalScientifique(id);
        System.out.println("Le journal scientifique avec l'ID " + id + " a été supprimé.");
    }


    public static void supprimerTheseUniversitaire(int id) {
        TheseUniversitaireDAO.supprimerTheseUniversitaire(id);
        System.out.println("La thèse universitaire avec l'ID " + id + " a été supprimée.");
    }

    }

