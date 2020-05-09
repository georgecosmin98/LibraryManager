package com.project.ui.adminmain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AdminController {

    @FXML
    private AnchorPane mainController;

    public void addlibrarian(ActionEvent actionEvent) {
        loadWindows("/add_librarian.fxml", "Add librarian menu");
    }

    public void listlibrarian(ActionEvent actionEvent) {
        loadWindows("/list_librarian.fxml", "List librarian menu");
    }

    public void deletelibrarian(ActionEvent actionEvent) {
        loadWindows("/delete_librarian.fxml", "Delete librarian menu");
    }

    public void loadWindows(String location, String windowsTitle) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(windowsTitle);
            stage.setScene(new Scene(parent));
            stage.initModality(Modality.APPLICATION_MODAL); //Blocheaza parintele pana e inchisa scena copilului
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Could not open " + windowsTitle);
        }
    }

    public void logOut(ActionEvent actionEvent) {
        loadWindows("/login.fxml","Login Screen");
        Stage stage = (Stage) mainController.getScene().getWindow();
        stage.close();
    }
}
