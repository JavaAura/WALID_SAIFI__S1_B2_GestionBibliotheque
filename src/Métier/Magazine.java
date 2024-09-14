package src.Métier;
import src.DAO.MagazineDAO;
import src.Utilitaire.InputValidator;

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
        String titreValider = InputValidator.validateString(titre);
        System.out.print("Auteur: ");
        String auteur = scanner.nextLine();
        String auteurValider  = InputValidator.validateString(titreValider);
        LocalDate dateDePublicationValider = InputValidator.validateDate();
        System.out.print("Nombre de pages: ");
        int nombreDePages = scanner.nextInt();
        int nombreValide = InputValidator.validateInt(nombreDePages);
        System.out.print("Numéro: ");
        int numero = scanner.nextInt();
        int numeroValider = InputValidator.validateInt(numero);

        return new Magazine(titreValider, auteurValider, dateDePublicationValider, nombreValide, numeroValider);
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




    public static void modifierMagazine(int id) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Modification du magazine avec ID: " + id);

        System.out.print("Entrez le nouveau titre : ");
        String titre = scanner.nextLine();
        String titreValide = InputValidator.validateString(titre);

        System.out.print("Entrez le nouvel auteur : ");
        String auteur = scanner.nextLine();
        String auteurValide = InputValidator.validateString(auteur);


        LocalDate dateDePublicationValide = InputValidator.validateDate();

        System.out.print("Entrez le nouveau nombre de pages : ");
        int nombreDePages = InputValidator.validateInt(scanner.nextInt());

        System.out.print("Entrez le nouveau numéro : ");
        int numeroValide = InputValidator.validateInt(scanner.nextInt());

        Magazine magazine = new Magazine(titreValide, auteurValide, dateDePublicationValide, nombreDePages, numeroValide);

        MagazineDAO.modifierMagazine(magazine,id);
    }



}
