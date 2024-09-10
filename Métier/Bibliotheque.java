package Métier;

import java.util.HashMap;
import java.util.Map;

public class Bibliotheque {
    private Map<String, Document> documents = new HashMap<>();

    public void ajouterDocument(Document document) {
        documents.put(document.getId(), document);
        System.out.println("Document ajouté: " + document.getTitre());
    }

    public void afficherTousLesDocuments() {
        for (Document doc : documents.values()) {
            doc.afficherDetails();
        }
    }

    public void emprunterDocument(String id) {
        Document document = documents.get(id);
        if (document != null && document instanceof Empruntable) {
            ((Empruntable) document).emprunter();
        } else {
            System.out.println("Document non disponible pour emprunt.");
        }
    }

    public void retournerDocument(String id) {
        Document document = documents.get(id);
        if (document != null && document instanceof Empruntable) {
            ((Empruntable) document).retourner();
        } else {
            System.out.println("Document non disponible pour retour.");
        }
    }

    public void réserverDocument(String id) {
        Document document = documents.get(id);
        if (document != null && document instanceof Réservable) {
            ((Réservable) document).réserver();
        } else {
            System.out.println("Document non disponible pour réservation.");
        }
    }

    public void annulerRéservationDocument(String id) {
        Document document = documents.get(id);
        if (document != null && document instanceof Réservable) {
            ((Réservable) document).annulerRéservation();
        } else {
            System.out.println("Document non disponible pour annulation de réservation.");
        }
    }
}

