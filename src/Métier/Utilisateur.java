package src.Métier;

public abstract class Utilisateur {

    protected String nom;
    protected String email;

    public String getEmail() {
        return email;
    }

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
