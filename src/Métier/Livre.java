package Métier;
import java.time.LocalDate;

public class Livre extends Document implements Empruntable, Réservable {
    private String isbn;

    public Livre(String titre, String auteur, LocalDate dateDePublication, int nombreDePages, String isbn, String etat) {
        super(titre, auteur, dateDePublication, nombreDePages, etat);
        this.isbn = isbn;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Livre - ISBN: " + isbn + ", Titre: " + titre + ", Auteur: " + auteur + ", Publication: " + dateDePublication);
    }

    @Override
    public void emprunter() {
        if ("disponible".equals(etat)) {
            setEtat("emprunté");
            System.out.println("Livre emprunté.");
        } else {
            System.out.println("Le livre n'est pas disponible pour l'emprunt.");
        }
    }

    @Override
    public void retourner() {
        setEtat("disponible");
        System.out.println("Livre retourné.");
    }

    @Override
    public void réserver() {
        if ("disponible".equals(etat)) {
            setEtat("réservé");
            System.out.println("Livre réservé.");
        } else {
            System.out.println("Le livre n'est pas disponible pour la réservation.");
        }
    }

    @Override
    public void annulerRéservation() {
        setEtat("disponible");
        System.out.println("Réservation annulée.");
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
