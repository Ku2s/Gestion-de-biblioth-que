package com.controleur;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConnexionPage extends GridPane {

    public ConnexionPage(Stage primaryStage) {
        this.setHgap(10);
        this.setVgap(5);

        // Création des champs de saisie pour le formulaire de connexion
        TextField nomUtilisateurField = new TextField();
        PasswordField motDePasseField = new PasswordField();
        Button connexionButton = new Button("Connexion");
        Button retourButton = new Button("Retour");

        // Ajout des éléments à la grille
        this.add(new Label("Nom d'utilisateur:"), 0, 0);
        this.add(nomUtilisateurField, 1, 0);
        this.add(new Label("Mot de passe:"), 0, 1);
        this.add(motDePasseField, 1, 1);
        this.add(connexionButton, 0, 2);
        this.add(retourButton, 1, 2);

        // Gestion des actions des boutons
        connexionButton.setOnAction(event -> {
            // Vérification que les champs de nom d'utilisateur et de mot de passe ne sont
            // pas vides
            if (nomUtilisateurField.getText().isEmpty() || motDePasseField.getText().isEmpty()) {
                // Affichage d'un message d'erreur si les champs sont vides
                new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs.").show();
            } else {
                // Vérification que l'utilisateur est inscrit
                if (!estInscrit(nomUtilisateurField.getText())) {
                    // Affichage d'un message d'erreur si l'utilisateur n'est pas inscrit
                    new Alert(Alert.AlertType.ERROR, "Le compte n'existe pas.").show();
                } else {
                    // Logique de connexion
                    boolean connexionReussie = verifierConnexion(nomUtilisateurField.getText(),
                            motDePasseField.getText());
                    if (connexionReussie) {
                        // Redirection vers la page "Bibliothèque"
                        primaryStage.setScene(new Scene(new BibliothequePage(primaryStage), 800, 600));
                        primaryStage.setTitle("Bibliothèque");
                    } else {
                        // Afficher un message d'erreur si la connexion échoue
                        new Alert(Alert.AlertType.ERROR, "Connexion échouée. Veuillez vérifier vos identifiants.")
                                .show();
                    }
                }
            }
        });

        retourButton.setOnAction(event -> {
            // Retour à la page "Nouvel Adhérent"
            primaryStage.setScene(new Scene(new NouvelAdherentPage(primaryStage), 800, 600));
            primaryStage.setTitle("Nouvel Adhérent");
        });
    }

    // Méthode pour vérifier si l'utilisateur est inscrit
    private boolean estInscrit(String nomUtilisateur) {
        // Ici, vous pouvez implémenter la logique pour vérifier si l'utilisateur est
        // inscrit
        // Par exemple, vous pouvez vérifier dans une base de données
        // Pour cet exemple, nous supposons simplement que l'utilisateur est toujours
        // inscrit
        return true;
    }

    // Méthode pour vérifier la connexion
    private boolean verifierConnexion(String nomUtilisateur, String motDePasse) {
        // Ici, vous pouvez implémenter la logique pour vérifier la connexion
        // Par exemple, vous pouvez vérifier les identifiants dans une base de données
        // Pour cet exemple, nous supposons simplement que la connexion réussit toujours
        return true;
    }
}
