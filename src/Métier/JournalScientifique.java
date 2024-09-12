package src.Métier;
import java.time.LocalDate;


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

