package src.Présentation;
import src.DAO.*;

import src.Métier.*;

import java.time.LocalDate;
import java.util.Scanner;


public class Console {



     public Console(){

     }


    public static void afficheMenu() {
        while (true) {
            System.out.println("-------------------------------------------------------");
            System.out.println("1-  Ajouter un document");
            System.out.println("2-  Modifier un document");
            System.out.println("3-  Supprimer un document");
            System.out.println("4-  Afficher tous les documents");
            System.out.println("5-  Emprunter un document");
            System.out.println("6-  Retourner un document");
            System.out.println("7-  Ajouter un utilisateur");
            System.out.println("8-  Modifier un utilisateur");
            System.out.println("9-  Supprimer un utilisateur");
            System.out.println("10- Afficher tous les utilisateurs");
            System.out.println("11- Quitter");
            System.out.print("Veuillez entrer votre choix (1-11) : ");
            Scanner scanner = new Scanner(System.in);
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                           Document.ajouterDocument();
                    break;
                case 2:
                            Document.modifierDocument();
                    break;
                case 3:
                            Document.supprimerDocument();
                    break;
                case 4:
                    DocumentDAO.afficherToutDocument();
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:


                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }















}
