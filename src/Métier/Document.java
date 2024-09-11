package Métier;

import java.time.LocalDate;

public abstract class Document {
    private long id;
    protected String titre;
    protected String auteur;
    protected LocalDate dateDePublication;
    protected int nombreDePages;
    protected String etat;


    public Document(String titre, String auteur, LocalDate dateDePublication, int nombreDePages, String etat) {

        this.titre = titre;
        this.auteur = auteur;
        this.dateDePublication = dateDePublication;
        this.nombreDePages = nombreDePages;
        this.etat = etat;
    }


    public abstract void afficherDetails();



    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public LocalDate getDateDePublication() {
        return dateDePublication;
    }

    public int getNombreDePages() {
        return nombreDePages;
    }

    public String getEtat() {
        return etat;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setDateDePublication(LocalDate dateDePublication) {
        this.dateDePublication = dateDePublication;
    }

    public void setNombreDePages(int nombreDePages) {
        this.nombreDePages = nombreDePages;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
