package com.modele;

public class Livre extends Document implements Empruntable {
    private String editeur;
    private boolean dispo;

    public Livre(String titre, String auteur, String editeur) {
        super(titre, auteur);
        this.editeur = editeur;
        this.dispo = true; // Par défaut, le livre est disponible
    }

    public String getTitre() {
        return titre;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public boolean getDispo() {
        return dispo;
    }

    @Override
    public boolean estDisponible() {
        return dispo;
    }

    @Override
    public void emprunter() {
        if (dispo) {
            dispo = false; // Marquer le livre comme non disponible lorsqu'il est emprunté
        } else {
            System.out.println("Ce livre n'est pas disponible pour l'emprunt.");
        }
    }

    @Override
    public void rendre() {
        dispo = true; // Marquer le livre comme disponible lorsqu'il est rendu
    }

    // Getters et setters pour editeur
}