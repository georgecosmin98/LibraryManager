package com.project.ui.addlibrarian;

import com.project.alert.makeAlert;
import com.project.model.TypeOfUser;
import com.project.service.LibrarianServiceImpl;
import com.project.service.UserAccountServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class AddLibrarianController {
    @FXML
    private TextField librarianName;

    @FXML
    private TextField address;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField email;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button addButton;

    private static Logger logger;

    static {
        System.setProperty("java.util.logging.config.file",
                "C:\\Users\\ylyho\\OneDrive\\Documente\\GitHub\\LibraryManager\\src\\main\\resources\\log.properties");
        //must initialize loggers after setting above property
        logger = Logger.getLogger(AddLibrarianController.class.getName());
    }

    ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
    UserAccountServiceImpl userAccountService = (UserAccountServiceImpl) context.getBean(UserAccountServiceImpl.class);
    LibrarianServiceImpl librarianService = (LibrarianServiceImpl) context.getBean(LibrarianServiceImpl.class);

    public void addLibrarian(ActionEvent actionEvent) {
        if (librarianName.getText().isEmpty() || address.getText().isEmpty() || phoneNumber.getText().isEmpty() || email.getText().isEmpty()
                || username.getText().isEmpty() || password.getText().isEmpty()) {
            makeAlert.showMessageAlert("Please fill all fields!");
            logger.warning("Not all fields were completed!");
        } else {

            librarianService.createLibrarian(librarianName.getText(), phoneNumber.getText(), address.getText(), email.getText(),
                    userAccountService.createUser(username.getText(), password.getText(), TypeOfUser.LIBRARIAN));

        }
    }
}
