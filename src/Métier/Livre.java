package src.Métier;
import src.DAO.LivreDAO;
import src.Utilitaire.InputValidator;

import java.sql.SQLException;
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

    public static void modifierLivre(int id) {
    }

    public static void supprimerLivre(int id){
        try {
            LivreDAO.supprimerLivre(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Le livre avec l'ID " + id + " a été supprimé.");
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
        titre = InputValidator.validateString(titre);
        System.out.print("Auteur: ");
        String auteur = scanner.nextLine();
        auteur = InputValidator.validateString(auteur);
        System.out.print("Date de publication (yyyy-mm-dd): ");
        LocalDate dateDePublication = LocalDate.parse(scanner.nextLine());
        dateDePublication = InputValidator.validateDate(dateDePublication);
        System.out.print("Nombre de pages: ");
        int nombreDePages = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        return new Livre(titre, auteur, dateDePublication, nombreDePages, isbn);
    }



    @Override
    public void afficherDetails() {

    }
}
