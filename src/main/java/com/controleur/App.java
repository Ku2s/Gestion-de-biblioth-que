package com.controleur;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Nouvel Adhérent");

        NouvelAdherentPage nouvelAdherentPage = new NouvelAdherentPage(primaryStage);

        // Affichage initial de la page "Nouvel Adhérent"
        Scene scene = new Scene(nouvelAdherentPage, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
