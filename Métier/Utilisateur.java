package Métier;

public abstract class Utilisateur {
    protected String id;
    protected String nom;

    public Utilisateur(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public abstract void afficherDetails();
}
