package src.Métier;

public abstract class Utilisateur {

    protected String nom;
    protected String prenom;

    public String getNom() {
        return nom;
    }

    public Utilisateur(String nom, String prenom) {
        this.nom =nom;
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public abstract void afficherDetails();
}
