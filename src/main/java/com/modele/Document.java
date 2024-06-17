package com.modele;

abstract public class Document {
    protected String titre;
    protected String auteur;

    public Document(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

}