package src.Métier;
import java.time.LocalDate;

public class Magazine extends Document{
    private int numéro;


    public Magazine(String titre, String auteur, LocalDate dateDePublication, int nombreDePages, String etat, boolean reserve, int numéro) {
        super(titre, auteur, dateDePublication, nombreDePages, etat, reserve);
        this.numéro = numéro;
    }

    public Magazine(String titre, String auteur, LocalDate dateDePublication, int nombreDePages, int numéro) {
        super(titre, auteur, dateDePublication, nombreDePages);
        this.numéro = numéro;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Magazine - Numéro: " + numéro + ", Titre: " + titre + ", Auteur: " + auteur + ", Publication: " + dateDePublication);
    }





    public int getNuméro() {
        return numéro;
    }


    public void setNuméro(int numéro) {
        this.numéro = numéro;
    }
}
