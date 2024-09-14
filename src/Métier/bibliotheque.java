package src.Métier;

import java.util.*;
public class bibliotheque implements  Empruntable{

    private List<Document> documents;

    private Map<String, Document> documentMap = new HashMap<>();

    public bibliotheque(){

        this.documents = new ArrayList();

    }


    public void ajouterDocument(Document doc) {
        this.documents.add(doc);

        this.documentMap.put(String.valueOf(doc.getId()), doc);
    }








}