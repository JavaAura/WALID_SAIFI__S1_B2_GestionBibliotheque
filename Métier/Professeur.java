package Métier;

public class Professeur extends Utilisateur {
    private String specialite;

    public Professeur(String id, String nom, String specialite) {
        super(id, nom);
        this.specialite = specialite;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Professeur - ID: " + id + ", Nom: " + nom + ", Spécialité: " + specialite);
    }
}
