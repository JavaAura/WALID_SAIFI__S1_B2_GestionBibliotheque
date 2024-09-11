package src.Métier;

public class Professeur extends Utilisateur {
    private String specialite;

    public Professeur(String nom, String specialite) {
        super(nom);
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

        System.out.println("Professeur : Nom: " + getNom() + ", Spécialité: " + specialite);
    }
}
