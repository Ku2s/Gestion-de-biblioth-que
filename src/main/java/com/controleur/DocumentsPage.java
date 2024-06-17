package com.controleur;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class DocumentsPage extends BorderPane {

    // Liste centrale des documents disponibles
    private ListView<String> documentsListView;

    // Liste des documents empruntés par l'utilisateur
    private ListView<String> documentsEmpruntesListView;

    public DocumentsPage() {
        // Création des boutons de retour
        Button retourButton = new Button("Retour");

        // Création de la liste d'éléments disponibles
        documentsListView = new ListView<>();
        documentsListView.getItems().addAll(
                "Titre : Les fleurs du mal, Auteur : Charles Baudelaire, Editeur : Le Livre de Poche",
                "Titre : L'Étranger, Auteur : Albert Camus, Editeur : Gallimard",
                "Titre : Le Petit Prince, Auteur : Antoine de Saint-Exupéry, Editeur : Gallimard",
                "Titre : Les Misérables, Auteur : Victor Hugo, Editeur : Gallimard",
                "Titre : Le Rouge et le Noir, Auteur : Stendhal, Editeur : Le Livre de Poche",
                "Titre : Germinal, Auteur : Émile Zola, Editeur : Le Livre de Poche");

        // Création de la liste des éléments empruntés par l'utilisateur
        documentsEmpruntesListView = new ListView<>();

        // Création du conteneur pour les listes
        VBox documentsBox = new VBox(10); // Espacement vertical entre les éléments
        documentsBox.getChildren().addAll(documentsListView, documentsEmpruntesListView);

        // Ajout du conteneur à la partie centrale de la page
        setCenter(documentsBox);

        // Ajout du bouton de retour en bas de la page
        setBottom(retourButton);

        // Gestion de l'événement du bouton "Retour"
        retourButton.setOnAction(event -> {
            // Retour à la page Bibliotheque
            BorderPane root = (BorderPane) getScene().getRoot();
            root.setCenter(new BibliothequePage(null));
        });

        // Gestion de l'événement du clic sur un document emprunté
        documentsEmpruntesListView.setOnMouseClicked(event -> {
            // Récupérer le document sélectionné
            String documentSelectionne = documentsEmpruntesListView.getSelectionModel().getSelectedItem();
            // Ajouter le document à la liste des documents disponibles
            documentsListView.getItems().add(documentSelectionne);
            // Supprimer le document de la liste des documents empruntés
            documentsEmpruntesListView.getItems().remove(documentSelectionne);
        });

        // Gestion de l'événement du clic sur un document disponible (pour l'emprunter)
        documentsListView.setOnMouseClicked(event -> {
            // Récupérer le document sélectionné
            String documentSelectionne = documentsListView.getSelectionModel().getSelectedItem();
            // Ajouter le document à la liste des documents empruntés
            documentsEmpruntesListView.getItems().add(documentSelectionne);
            // Supprimer le document de la liste des documents disponibles
            documentsListView.getItems().remove(documentSelectionne);
        });
    }
}
