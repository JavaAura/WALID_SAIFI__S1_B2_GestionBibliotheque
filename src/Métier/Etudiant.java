package src.Métier;

public class Etudiant extends Utilisateur {
    private String matricule;

    public Etudiant(int id,String nom, String prenom, String matricule) {
        super(nom, id, prenom);
        this.matricule = matricule;
    }

    public Etudiant(String nom, String prenom, String matricule) {
        super(nom, prenom);
        this.matricule = matricule;
    }


    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     *
     */
    @Override
    public void afficherDetails() {

    }
}
