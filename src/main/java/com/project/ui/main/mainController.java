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
import java.sql.SQLOutput;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void addBook(ActionEvent actionEvent) throws IOException {
        loadWindows("/add_book.fxml","Add book menu");
    }

    public void listbook(ActionEvent actionEvent) throws IOException{
        loadWindows("/list_book.fxml","List book menu");
    }

    public void addstudent(ActionEvent actionEvent) throws IOException {
        loadWindows("/add_student.fxml","Add student menu");
    }

    public void liststudent(ActionEvent actionEvent) throws IOException {
        loadWindows("/list_student.fxml","List student menu");
    }

    public void loadWindows(String location, String windowsTitle){
        try{
            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(windowsTitle);
            stage.setScene(new Scene(parent));
            stage.initModality(Modality.APPLICATION_MODAL); //Blocheaza parintele pana e inchisa scena copilului
            stage.show();
        }
        catch (IOException ex){
            System.out.println(ex.toString());
            System.out.println("Could not open " + windowsTitle);
        }
    }
}
