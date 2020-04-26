package com.project.ui.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void addBook(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/add_book.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Add book menu");
        stage.setScene(new Scene(parent));
        stage.initModality(Modality.APPLICATION_MODAL); //Blocheaza parintele pana e inchisa scena copilului
        stage.show();
    }

    public void listbook(ActionEvent actionEvent) {
    }
}
