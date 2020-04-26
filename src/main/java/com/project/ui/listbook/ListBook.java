package com.project.ui.listbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListBook extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/list_book.fxml"));
        primaryStage.setTitle("Library Manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
