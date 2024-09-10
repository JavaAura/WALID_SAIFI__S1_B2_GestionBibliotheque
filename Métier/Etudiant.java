package Métier;

public class Etudiant extends Utilisateur {
    private String niveau;

    public Etudiant(String id, String nom, String niveau) {
        super(nom);
        this.niveau = niveau;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Étudiant  " + nom + ", Niveau: " + niveau);
    }

}
