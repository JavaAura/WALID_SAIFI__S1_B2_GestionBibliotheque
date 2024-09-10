package Métier;

public class Etudiant extends Utilisateur {
    private String niveau;

    public Etudiant(String id, String nom, String niveau) {
        super(id, nom);
        this.niveau = niveau;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Étudiant - ID: " + id + ", Nom: " + nom + ", Niveau: " + niveau);
    }
}
