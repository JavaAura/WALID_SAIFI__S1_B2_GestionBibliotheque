package src.Métier;
import java.time.LocalDate;

public class TheseUniversitaire extends Document {


        private String universite;
        private String domaine;



    public TheseUniversitaire(String titre, String auteur, LocalDate dateDePublication, int nombreDePages, String etat) {
        super(titre, auteur, dateDePublication, nombreDePages, etat);
        this.universite = universite;
        this.domaine = domaine;
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
}

