package Métier;

public class Professeur extends Utilisateur {
    private String specialite;

    public Professeur(String nom, String specialite) {
        super(nom);
        this.specialite = specialite;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Professeur : , Nom: " + nom + ", Spécialité: " + specialite);
    }
}
