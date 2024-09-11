package src.Métier;

public abstract class Utilisateur {
    protected  int id;
    protected String nom;
    protected String prenom;

    public Utilisateur(String nom, int id, String prenom) {
        this.nom = nom;
        this.id = id;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public Utilisateur(String nom, String prenom) {
        this.nom =nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
