package com.controleur;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ElementsEnPossessionPage extends BorderPane {

    public ElementsEnPossessionPage() {
        // Création des boutons de retour
        Button retourButton = new Button("Retour");

        // Création de la liste des éléments en possession de l'utilisateur
        ListView<String> elementsEnPossessionListView = new ListView<>();

        // Ajout des données à la liste (exemple simplifié)
        elementsEnPossessionListView.getItems().addAll(
                "Document emprunté 1",
                "Document emprunté 2",
                "Document emprunté 3");

        // Création du conteneur pour la liste
        VBox elementsBox = new VBox(10); // Espacement vertical entre les éléments
        elementsBox.getChildren().addAll(elementsEnPossessionListView);

        // Ajout du conteneur à la partie centrale de la page
        setCenter(elementsBox);

        // Ajout du bouton de retour en bas de la page
        setBottom(retourButton);

        // Gestion de l'événement du bouton "Retour"
        retourButton.setOnAction(event -> {
            // Retour à la page Bibliotheque
            BorderPane root = (BorderPane) getScene().getRoot();
            root.setCenter(new BibliothequePage(null));
        });
    }
}
