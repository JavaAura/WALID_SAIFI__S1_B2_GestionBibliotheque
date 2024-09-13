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
            System.out.println("6 - Réserver un document");
            System.out.println("7-  Retourner un document");
            System.out.println("8-  Ajouter un utilisateur");
            System.out.println("9-  Modifier un utilisateur");
            System.out.println("10-  Supprimer un utilisateur");
            System.out.println("11- Afficher tous les utilisateurs");
            System.out.println("12- Quitter");
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
                            Document.demanderEmpruntDocument();
                    break;
                case 6:
                            Document.demanderReservationDocument();
                    break;
                case 7:
                            Document.demanderRetourDocument();
                    break;
                case 8:
                            Utilisateur.ajouterUtilisateur();
                    break;
                case 9:
                            Utilisateur.modifierUtilisateur();
                    break;
                case 10:
                            Utilisateur.supprimerUtilisateur();
                    break;
                case 11:
                            UtilisateurDAO.afficherToutUtilisateur();
                    break;
                case 12:



                        System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }















}
