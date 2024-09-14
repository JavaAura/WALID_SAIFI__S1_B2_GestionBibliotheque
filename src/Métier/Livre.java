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
        System.out.println("Saisir les informations du livre à modifier :\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Titre: ");
        String titre = scanner.nextLine();
        String titreValider = InputValidator.validateString(titre);
        System.out.print("Auteur: ");
        String auteur = scanner.nextLine();
        String  auteurValider = InputValidator.validateString(auteur);
        LocalDate  dateValider = InputValidator.validateDate();
        System.out.print("Nombre de pages: ");
        int nombreDePages = scanner.nextInt();
        int nombreDePagesValider = InputValidator.validateInt(nombreDePages);
        scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        String isbnValide = InputValidator.validateString(isbn);
         Livre livre = new    Livre(titreValider, auteurValider, dateValider, nombreDePagesValider, isbnValide);
         LivreDAO.modifierLivre(id,livre);
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
        String titreValider = InputValidator.validateString(titre);
        System.out.print("Auteur: ");
        String auteur = scanner.nextLine();
        String  auteurValider = InputValidator.validateString(auteur);
        LocalDate  dateValider = InputValidator.validateDate();
        System.out.print("Nombre de pages: ");
        int nombreDePages = scanner.nextInt();
        int nombreDePagesValider = InputValidator.validateInt(nombreDePages);
        scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();


        return new Livre(titreValider, auteurValider, dateValider, nombreDePagesValider, isbn);
    }



    @Override
    public void afficherDetails() {

    }
}
