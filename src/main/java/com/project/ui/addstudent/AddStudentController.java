package com.project.ui.addstudent;

import com.project.alert.makeAlert;
import com.project.service.StudentServiceImpl;
import com.project.ui.addlibrarian.AddLibrarianController;
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
import java.util.logging.Logger;

public class AddStudentController implements Initializable {


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

    private static Logger logger;

    static {
        System.setProperty("java.util.logging.config.file",
                "C:\\Users\\ylyho\\OneDrive\\Documente\\GitHub\\LibraryManager\\src\\main\\resources\\log.properties");
        //must initialize loggers after setting above property
        logger = Logger.getLogger(AddLibrarianController.class.getName());
    }

    ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
    StudentServiceImpl studentService = (StudentServiceImpl) context.getBean(StudentServiceImpl.class);


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addStudent(ActionEvent actionEvent) throws ParseException {

        if (sid.getText().isEmpty() || studentName.getText().isEmpty() || phoneNumber.getText().isEmpty()
                || address.getText().isEmpty() || email.getText().isEmpty() ) {
            makeAlert.showMessageAlert("Please fill all fields!");
            logger.warning("Not all fields were completed!");
            return;
        }

        studentService.createStudent(sid.getText(), studentName.getText(), phoneNumber.getText(), address.getText(), email.getText());
        return;
    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) mainController.getScene().getWindow();
        logger.info("Closing stage");
        stage.close();
    }

}
