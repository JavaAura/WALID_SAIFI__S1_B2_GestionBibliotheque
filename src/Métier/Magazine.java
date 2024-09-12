package src.Métier;
import src.DAO.MagazineDAO;

import java.time.LocalDate;
import java.util.Scanner;

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

    public static Magazine saisirMagazine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Titre: ");
        String titre = scanner.nextLine();
        System.out.print("Auteur: ");
        String auteur = scanner.nextLine();
        System.out.print("Date de publication (yyyy-mm-dd): ");
        LocalDate dateDePublication = LocalDate.parse(scanner.nextLine());
        System.out.print("Nombre de pages: ");
        int nombreDePages = scanner.nextInt();
        System.out.print("Numéro: ");
        int numero = scanner.nextInt();

        return new Magazine(titre, auteur, dateDePublication, nombreDePages, numero);
    }

    public static void modifierMagazine(int id) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Modification du magazine avec ID: " + id);
        System.out.println("Entrez le nouveau titre : ");
        String titre = scanner.nextLine();
        System.out.println("Entrez le nouvel auteur : ");
        String auteur = scanner.nextLine();
        System.out.println("Entrez la nouvelle date de publication (format: yyyy-mm-dd) : ");
        LocalDate dateDePublication = LocalDate.parse(scanner.nextLine());
        System.out.println("Entrez le nouveau nombre de pages : ");
        int nombreDePages = scanner.nextInt();
        System.out.println("Entrez le nouveau numéro : ");
        int numero = scanner.nextInt();

        Magazine magazine = new Magazine(titre, auteur, dateDePublication, nombreDePages, numero);

        MagazineDAO.modifierMagazine(magazine);
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



    public static void supprimerMagazine(int id) {
        MagazineDAO.supprimerMagazine(id);
        System.out.println("Le magazine avec l'ID " + id + " a été supprimé.");
    }
  

}
