package com.project.ui.login;

import com.project.alert.makeAlert;
import com.project.model.TypeOfUser;
import com.project.service.UserAccountServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField username;
    public TextField password;

    ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
    UserAccountServiceImpl userAccountService = (UserAccountServiceImpl) context.getBean(UserAccountServiceImpl.class);
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void login(ActionEvent actionEvent) throws IOException {
        if (userAccountService.getUserAccountRepository().searchUser(username.getText(),password.getText()).getTypeOfUser().equals(TypeOfUser.LIBRARIAN)) {
            closeStage();
            loadMain();
        }
        else
        if (userAccountService.getUserAccountRepository().searchUser(username.getText(),password.getText()).getTypeOfUser().equals(TypeOfUser.ADMIN))
            {
            closeStage();
            loadAdminMain();
        }
        else
        {makeAlert.showMessageAlert("Username or password invalid!");
        return ;}

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

    public void loadAdminMain() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/admin_main.fxml"));
        Stage primaryStage = new Stage (StageStyle.DECORATED);
        primaryStage.setTitle("Admin menu");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(true);
        primaryStage.show();
    }
    public void close(ActionEvent actionEvent) {
        System.exit(0);
    }
}
