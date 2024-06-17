package com.controleur;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BibliothequePage extends BorderPane {

    public BibliothequePage(Stage primaryStage) {
        // Création des boutons
        Button documentButton = new Button("Document");
        Button materielButton = new Button("Matériel");
        Button elementsEnPossessionButton = new Button("Éléments en ma possession");
        Button deconnexionButton = new Button("Déconnexion");

        // Création du conteneur pour les boutons
        VBox boutonsBox = new VBox(10); // Espacement vertical entre les boutons
        boutonsBox.getChildren().addAll(documentButton, materielButton,
                elementsEnPossessionButton, deconnexionButton);

        // Ajout du conteneur à la partie centrale de la page
        setCenter(boutonsBox);

        // Gestion de l'événement du bouton "Document"
        documentButton.setOnAction(event -> {
            // Affichage de la page DocumentsPage
            setCenter(new DocumentsPage());
        });

        materielButton.setOnAction(event -> {
            // Affichage de la page MaterielPage
            setCenter(new MaterielPage());
        });

        elementsEnPossessionButton.setOnAction(event -> {
            // Affichage de la page ElementsEnPossessionPage
            setCenter(new ElementsEnPossessionPage());
        });

        deconnexionButton.setOnAction(event -> {
            // Redirection vers la page de connexion
            ConnexionPage connexionPage = new ConnexionPage(primaryStage);
            primaryStage.setScene(new Scene(connexionPage, 800, 600));
            primaryStage.setTitle("Connexion");
        });
    }
}
