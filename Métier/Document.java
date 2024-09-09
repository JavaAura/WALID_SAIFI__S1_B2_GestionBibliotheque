package Métier;

import java.time.LocalDate;


public abstract class Document {
    protected String id;
    protected String titre;
    protected String auteur;
    protected LocalDate dateDePublication;
    protected int nombreDePages;
    protected String etat; // "disponible", "emprunté", "réservé"

    public Document(String id, String titre, String auteur, LocalDate dateDePublication, int nombreDePages, String etat) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.dateDePublication = dateDePublication;
        this.nombreDePages = nombreDePages;
        this.etat = etat;
    }

    public abstract void afficherDetails();

    public String getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public LocalDate getDateDePublication() {
        return dateDePublication;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
