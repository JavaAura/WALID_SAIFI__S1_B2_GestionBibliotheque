package src.Métier;

import src.Métier.Document;

import java.util.*;
public class Bibliotheque {

    private List<Document> documents;

    private Map<String, Document> documentMap = new HashMap<>();

    public Bibliotheque(){

        this.documents = new ArrayList();

    }


    public void ajouterDocument(Document doc) {
        this.documents.add(doc);

        this.documentMap.put(String.valueOf(doc.getId()), doc);
    }








}