package Métier;

public abstract class Utilisateur {

    protected String nom;

    public Utilisateur(String nom) {
        this.nom = nom;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public abstract void afficherDetails();
}
