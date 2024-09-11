package src.Métier;
import java.time.LocalDate;

public class Livre extends Document implements Empruntable, Réservable {
    private String isbn;

    public Livre(String titre, String auteur, LocalDate dateDePublication, int nombreDePages,String etat, String isbn) {
        super(titre, auteur, dateDePublication, nombreDePages, etat);
        this.isbn = isbn;
    }






    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     *
     */
    @Override
    public void afficherDetails() {

    }

    /**
     *
     */
    @Override
    public void emprunter() {

    }

    /**
     *
     */
    @Override
    public void retourner() {

    }

    /**
     *
     */
    @Override
    public void réserver() {

    }

    /**
     *
     */
    @Override
    public void annulerRéservation() {

    }
}
