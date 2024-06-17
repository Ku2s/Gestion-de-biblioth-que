package com.modele;

import java.util.ArrayList;

public class Bibliotheque {
    private ArrayList<Document> documents;
    private ArrayList<Materiel> materiels;
    private ArrayList<Adherant> adherants;

    public Bibliotheque() {
        documents = new ArrayList<Document>();
        materiels = new ArrayList<Materiel>();
        adherants = new ArrayList<Adherant>();
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public void ajouterDocument(Document document) {
        documents.add(document);
    }

    public void ajouterAdherant(Adherant adherant) {
        adherants.add(adherant);
    }

    public void ajouterMateriel(Materiel materiel) {
        materiels.add(materiel);
    }

    public void afficherDocuments() {
        System.out.println("Liste des documents :");
        for (Document d : documents) {
            System.out.println(d);
        }
    }

    public void afficherMateriels() {
        System.out.println("Liste des matériels :");
        for (Materiel m : materiels) {
            System.out.println(m);
        }
    }

    public void afficherAdherants() {
        System.out.println("Liste des adhérents :");
        for (Adherant a : adherants) {
            System.out.println(a);
        }
    }
}