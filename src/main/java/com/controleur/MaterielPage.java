package com.controleur;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MaterielPage extends BorderPane {

    // Liste centrale des éléments matériels disponibles
    private ListView<String> materielListView;

    // Liste des éléments matériels empruntés par l'utilisateur
    private ListView<String> materielEmprunteListView;

    public MaterielPage() {
        // Création des boutons de retour
        Button retourButton = new Button("Retour");

        // Création de la liste d'ordinateurs portables (à remplacer par les données
        // réelles)
        materielListView = new ListView<>();
        materielListView.getItems().addAll(
                "Marque: Dell, OS: Windows",
                "Marque: HP, OS: Linux",
                "Marque: Lenovo, OS: Windows",
                "Marque: Asus, OS: Windows",
                "Marque: Apple, OS: MacOS",
                "Marque: Acer, OS: Windows");

        // Création de la liste des éléments matériels empruntés par l'utilisateur
        materielEmprunteListView = new ListView<>();

        // Création du conteneur pour les listes
        VBox materielBox = new VBox(10); // Espacement vertical entre les éléments
        materielBox.getChildren().addAll(materielListView, materielEmprunteListView);

        // Ajout du conteneur à la partie centrale de la page
        setCenter(materielBox);

        // Ajout du bouton de retour en bas de la page
        setBottom(retourButton);

        // Gestion de l'événement du bouton "Retour"
        retourButton.setOnAction(event -> {
            // Retour à la page Bibliotheque
            BorderPane root = (BorderPane) getScene().getRoot();
            root.setCenter(new BibliothequePage(null));
        });

        // Gestion de l'événement du clic sur un élément matériel emprunté
        materielEmprunteListView.setOnMouseClicked(event -> {
            // Récupérer l'élément matériel sélectionné
            String materielSelectionne = materielEmprunteListView.getSelectionModel().getSelectedItem();
            // Ajouter l'élément à la liste des éléments disponibles
            materielListView.getItems().add(materielSelectionne);
            // Supprimer l'élément de la liste des éléments matériels empruntés
            materielEmprunteListView.getItems().remove(materielSelectionne);
        });

        // Gestion de l'événement du clic sur un élément matériel disponible (pour
        // l'emprunter)
        materielListView.setOnMouseClicked(event -> {
            // Récupérer l'élément matériel sélectionné
            String materielSelectionne = materielListView.getSelectionModel().getSelectedItem();
            // Ajouter l'élément à la liste des éléments matériels empruntés
            materielEmprunteListView.getItems().add(materielSelectionne);
            // Supprimer l'élément de la liste des éléments matériels disponibles
            materielListView.getItems().remove(materielSelectionne);
        });
    }
}
