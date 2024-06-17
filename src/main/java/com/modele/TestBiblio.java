package com.modele;

public class TestBiblio {
    public static void main(String[] args) {
        // Bibliotheque b = new Bibliotheque();
        Adherant a1 = new Adherant("Dupont", "Jean", Statut.ETUDIANT);
        Adherant a2 = new Adherant("Durand", "Paul", Statut.ENSEIGNANT);
        Livre l1 = new Livre("Les Misérables", "Victor Hugo", "Gallimard");
        Livre l2 = new Livre("Le Rouge et le Noir", "Stendhal", "Folio");
        Livre l3 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", "Gallimard");
        Livre l4 = new Livre("Les Fleurs du Mal", "Charles Baudelaire", "Gallimard");
        Livre l5 = new Livre("Les Trois Mousquetaires", "Alexandre Dumas", "Folio");
        Livre l6 = new Livre("Twist", "Milki", "Djouest");
        OrdinateurPortable op1 = new OrdinateurPortable(false, "Apple", Os.LINUX);
        OrdinateurPortable op2 = new OrdinateurPortable(false, "Dell", Os.WINDOWS);
        a1.emprunter(l1);
        a2.emprunter(l1);
        a1.emprunter(l2);
        a1.emprunter(l3);
        a1.emprunter(l4);
        a1.emprunter(l5);
        a1.emprunter(l6);
        a1.emprunter(op1);
        a1.emprunter(op2);

        System.out.println(a1);

        // b.ajouterDocument(l1);
        // b.ajouterDocument(l2);
        // b.ajouterDocument(bd1);
        // b.ajouterMateriel(op1);
        // b.ajouterMateriel(op2);

        // b.afficherDocuments();
        // b.afficherMateriels();
        // b.afficherAdherants();
        // EXO2:

    }

}