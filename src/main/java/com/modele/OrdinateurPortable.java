package com.modele;

public class OrdinateurPortable extends Materiel implements Empruntable {
    private String marque;
    private Os systeme;
    private boolean dispo;

    public OrdinateurPortable(boolean enPanne, String marque, Os systeme) {
        super(enPanne);
        this.marque = marque;
        this.systeme = systeme;
        this.dispo = true; // Par défaut, l'ordinateur portable est disponible
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Os getSysteme() {
        return systeme;
    }

    public void setSysteme(Os systeme) {
        this.systeme = systeme;
    }

    @Override
    public boolean estDisponible() {
        return dispo;
    }

    @Override
    public void emprunter() {
        if (dispo) {
            dispo = false; // Marquer l'ordinateur portable comme non disponible lorsqu'il est emprunté
        } else {
            System.out.println("Cet ordinateur portable n'est pas disponible pour l'emprunt.");
        }
    }

    @Override
    public void rendre() {
        dispo = true; // Marquer l'ordinateur portable comme disponible lorsqu'il est rendu
    }

}