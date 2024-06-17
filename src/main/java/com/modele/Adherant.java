package com.modele;

public class Adherant {
    private String nom;
    private String prenom;
    private Statut statut;
    private int nbEmprunt = 0;
    private int nbEmpruntLivre = 0;
    private int nbEmpruntOrdinateurPortable = 0;

    public Adherant(String nom, String prenom, Statut statut) {
        this.nom = nom;
        this.prenom = prenom;
        this.statut = statut;
    }

    public int getNbEmprunt() {
        return nbEmprunt;
    }

    public void setNbEmprunt(int nbEmprunt) {
        this.nbEmprunt = nbEmprunt;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Statut getStatut() {
        return statut;
    }

    public void emprunter(Object o) {
        if (o instanceof Livre) {
            Livre l = (Livre) o;
            if (l.estDisponible() && nbEmpruntLivre < 5) {
                l.emprunter();
                System.out.println(getNom() + " " + getPrenom() + " a emprunté le livre " + l.getTitre() + ".");
                nbEmprunt++;
                nbEmpruntLivre++;
            } else {
                System.out.println(
                        "Ce livre n'est pas disponible pour l'emprunt ou vous avez atteint le nombre maximum d'emprunts.");
            }
        } else if (o instanceof OrdinateurPortable) {
            OrdinateurPortable op = (OrdinateurPortable) o;
            if (op.estDisponible() && nbEmpruntOrdinateurPortable < 1) {
                op.emprunter();
                System.out.println(getNom() + " " + getPrenom() + " a emprunté l'ordinateur portable " + op.getMarque()
                        + " " + op.getSysteme() + ".");
                nbEmprunt++;
                nbEmpruntOrdinateurPortable++;
            } else {
                System.out.println(
                        "Cet ordinateur portable n'est pas disponible pour l'emprunt ou vous avez atteint le nombre maximum d'emprunts.");
            }
        }
    }

    // public void emprunter(Object o) {
    // if (o instanceof Livre) {
    // Livre l = (Livre) o;
    // if (l.estDisponible() && nbEmprunt < 5) {
    // l.emprunter();
    // System.out.println(getNom() + " " + getPrenom() + " a emprunté le livre " +
    // l.getTitre() + ".");
    // nbEmprunt++;
    // } else {
    // System.out.println(
    // "Ce livre n'est pas disponible pour l'emprunt ou vous avez atteint le nombre
    // maximum d'emprunts.");
    // }
    // } else if (o instanceof OrdinateurPortable) {
    // OrdinateurPortable op = (OrdinateurPortable) o;
    // if (op.estDisponible() && nbEmprunt < 5) {
    // op.emprunter();
    // System.out.println(getNom() + " " + getPrenom() + " a emprunté l'ordinateur
    // portable " + op.getMarque()
    // + " " + op.getSysteme() + ".");
    // nbEmprunt++;
    // } else {
    // System.out.println(
    // "Cet ordinateur portable n'est pas disponible pour l'emprunt ou vous avez
    // atteint le nombre maximum d'emprunts.");
    // }
    // }
    // }

    public void rendre(Object o) {
        if (o instanceof Livre) {
            Livre l = (Livre) o;
            if (!l.estDisponible()) {
                l.rendre();
                nbEmprunt--;
                nbEmpruntLivre--;
                System.out.println(getNom() + " " + getPrenom() + " a rendu le livre " + l.getTitre() + ".");
            } else {
                System.out.println("Ce livre n'a pas été emprunté par " + getNom() + " " + getPrenom() + ".");
            }
        }
        if (o instanceof OrdinateurPortable) {
            Livre l = (Livre) o;
            if (!l.estDisponible()) {
                l.rendre();
                nbEmprunt--;
                nbEmpruntOrdinateurPortable--;
                System.out
                        .println(getNom() + " " + getPrenom() + " a rendu l'ordinateur portable " + l.getTitre() + ".");
            } else {
                System.out.println(
                        "Cet ordinateur portable n'a pas été emprunté par " + getNom() + " " + getPrenom() + ".");
            }
        }

    }

    public String toString() {
        return "\nNom: " + getNom() + "\nPrénom: " + getPrenom() + "\nStatut: " + getStatut() + "\nNombre d'emprunts: "
                + getNbEmprunt() + "\nNombre d'emprunts de livres: " + nbEmpruntLivre
                + "\nNombre d'emprunts d'ordinateurs portables: " + nbEmpruntOrdinateurPortable + "\n";
    }

}