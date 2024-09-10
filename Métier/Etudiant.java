package Métier;

public class Etudiant extends Utilisateur {
    private String niveau;

    public Etudiant(String nom, String niveau) {
        super(nom);
        this.niveau = niveau;
    }


    public String getNiveau() {
        return niveau;
    }


    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Étudiant: " + getNom() + ", Niveau: " + niveau);
    }
}
