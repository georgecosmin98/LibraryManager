package com.project.ui.addstudent;

import com.project.alert.makeAlert;
import com.project.service.StudentServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

public class studentController implements Initializable {


    @FXML
    private AnchorPane mainController;

    @FXML
    private TextField sid;

    @FXML
    private TextField studentName;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField address;

    @FXML
    private TextField email;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
    StudentServiceImpl studentService = (StudentServiceImpl) context.getBean(StudentServiceImpl.class);

    public void addStudent(ActionEvent actionEvent) throws ParseException {

        if (sid.getText().isEmpty() || studentName.getText().isEmpty() || phoneNumber.getText().isEmpty()
                || address.getText().isEmpty() || email.getText().isEmpty() ) {
            makeAlert.showMessageAlert("Please fill all fields!");
            return;
        }

        studentService.createStudent(sid.getText(), studentName.getText(), phoneNumber.getText(), address.getText(), email.getText());
        return;
    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) mainController.getScene().getWindow();
        stage.close();
    }

}
