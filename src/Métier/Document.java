package src.Métier;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Document {
    private long id;
    protected String titre;
    protected String auteur;
    protected LocalDate dateDePublication;
    protected int nombreDePages;
    protected String etat;

    public boolean isReserve() {
        return reserve;
    }

    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }

    protected  boolean reserve;


    public Document(String titre, String auteur, LocalDate dateDePublication, int nombreDePages, String etat,boolean reserve) {

        this.titre = titre;
        this.auteur = auteur;
        this.dateDePublication = dateDePublication;
        this.nombreDePages = nombreDePages;
        this.etat = etat;
        this.reserve = reserve;
    }
    public Document(String titre, String auteur, LocalDate dateDePublication, int nombreDePages) {

        this.titre = titre;
        this.auteur = auteur;
        this.dateDePublication = dateDePublication;
        this.nombreDePages = nombreDePages;
    }



    public abstract void afficherDetails();

    public long getId() {
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

    public int getNombreDePages() {
        return nombreDePages;
    }

    public String getEtat() {
        return this.etat;
    }


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



    public static void modifierDocument() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel type de document voulez-vous modifier ?");
        System.out.println("1- Livre");
        System.out.println("2- Magazine");
        System.out.println("3- Journal Scientifique");
        System.out.println("4- Thèse Universitaire");
        int type = scanner.nextInt();
        scanner.nextLine();  

        System.out.println("Entrez l'ID du document à modifier :");
        int id = scanner.nextInt();
        scanner.nextLine();
        switch (type) {
            case 1:
                Livre.modifierLivre(id);
                break;
            case 2:
                Magazine.modifierMagazine(id);
                break;
            case 3:
                JournalScientifique.modifierJournalScientifique(id);
                break;
            case 4:
                TheseUniversitaire.modifierTheseUniversitaire(id);
                break;
            default:
                System.out.println("Type de document invalide.");
        }
    }
}
