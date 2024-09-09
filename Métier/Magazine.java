package Métier;
import java.time.LocalDate;

public class Magazine extends Document implements Empruntable {
    private int numéro;

    public Magazine(String id, String titre, String auteur, LocalDate dateDePublication, int nombreDePages, int numéro, String etat) {
        super(id, titre, auteur, dateDePublication, nombreDePages, etat);
        this.numéro = numéro;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Magazine - Numéro: " + numéro + ", Titre: " + titre + ", Auteur: " + auteur + ", Publication: " + dateDePublication);
    }

    @Override
    public void emprunter() {
        if ("disponible".equals(etat)) {
            setEtat("emprunté");
            System.out.println("Magazine emprunté.");
        } else {
            System.out.println("Le magazine n'est pas disponible pour l'emprunt.");
        }
    }

    @Override
    public void retourner() {
        setEtat("disponible");
        System.out.println("Magazine retourné.");
    }
}
