package src.Métier;
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

}
