package src.Métier;
import java.time.LocalDate;
import java.util.Scanner;

public class Livre extends Document {
    private String isbn;

    public Livre(String titre, String auteur, LocalDate dateDePublication, int nombreDePages,String etat,boolean reserve , String isbn) {
        super(titre, auteur, dateDePublication, nombreDePages, etat,reserve);
        this.isbn = isbn;
    }


    public Livre(String titre, String auteur, LocalDate dateDePublication, int nombreDePages,String isbn) {
        super(titre, auteur, dateDePublication, nombreDePages);
        this.isbn = isbn;
    }







    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }



    public static Livre saisirLivre() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Titre: ");
        String titre = scanner.nextLine();
        System.out.print("Auteur: ");
        String auteur = scanner.nextLine();
        System.out.print("Date de publication (yyyy-mm-dd): ");
        LocalDate dateDePublication = LocalDate.parse(scanner.nextLine());
        System.out.print("Nombre de pages: ");
        int nombreDePages = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        return new Livre(titre, auteur, dateDePublication, nombreDePages, isbn);
    }


    /**
     *
     */
    @Override
    public void afficherDetails() {

    }
}
