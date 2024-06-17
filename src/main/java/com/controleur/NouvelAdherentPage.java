package com.controleur;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NouvelAdherentPage extends VBox {

    public NouvelAdherentPage(Stage primaryStage) {
        // Création des champs de saisie pour le formulaire d'inscription
        TextField nomField = new TextField();
        TextField prenomField = new TextField();
        ComboBox<String> statutComboBox = new ComboBox<>();
        PasswordField motDePasseField = new PasswordField();
        PasswordField confirmationField = new PasswordField();
        Button validerButton = new Button("Valider");
        Button connexionButton = new Button("Connectez-vous");

        // Ajout des options au ComboBox pour le statut
        statutComboBox.getItems().addAll("Enseignant", "Étudiant");

        // Création du formulaire d'inscription
        getChildren().addAll(
                new Label("Nom:"),
                nomField,
                new Label("Prénom:"),
                prenomField,
                new Label("Statut:"),
                statutComboBox,
                new Label("Mot de passe:"),
                motDePasseField,
                new Label("Valider le mot de passe:"),
                confirmationField,
                validerButton,
                connexionButton);

        // Gestion des actions des boutons
        validerButton.setOnAction(event -> {
            // Vérification que tous les champs sont remplis
            if (nomField.getText().isEmpty() || prenomField.getText().isEmpty() ||
                    statutComboBox.getValue() == null || motDePasseField.getText().isEmpty() ||
                    confirmationField.getText().isEmpty()) {
                // Affichage d'un message d'erreur si tous les champs ne sont pas remplis
                new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs.").show();
            } else if (!motDePasseField.getText().equals(confirmationField.getText())) {
                // Vérification que les champs "Mot de passe" et "Valider le mot de passe" sont
                // identiques
                new Alert(Alert.AlertType.ERROR, "Les mots de passe ne correspondent pas.").show();
            } else {
                // Logique de validation du formulaire d'inscription
                // ...

                // Redirection vers la page "Bibliothèque"
                primaryStage.setScene(new Scene(new BibliothequePage(primaryStage), 800, 600));
                primaryStage.setTitle("Bibliothèque");
            }
        });

        connexionButton.setOnAction(event -> {
            // Affichage du formulaire de connexion
            primaryStage.setScene(new Scene(new ConnexionPage(primaryStage), 800, 600));
            primaryStage.setTitle("Connexion");
        });
    }
}
