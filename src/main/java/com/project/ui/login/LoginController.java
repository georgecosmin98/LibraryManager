package com.project.ui.login;

import com.project.alert.makeAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField username;
    public TextField password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void login(ActionEvent actionEvent) throws IOException {
        if (!username.getText().equals("admin") || !password.getText().equals("pass")) {
            makeAlert.showMessageAlert("Username or password invalid! Try again!");
            return;
        }
        else {
            closeStage();
            loadMain();
        }

    }

    public void closeStage(){
        ((Stage)username.getScene().getWindow()).close();
    }

    public void loadMain() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        Stage primaryStage = new Stage (StageStyle.DECORATED);
        primaryStage.setTitle("Library Manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public void close(ActionEvent actionEvent) {
        System.exit(0);
    }
}
