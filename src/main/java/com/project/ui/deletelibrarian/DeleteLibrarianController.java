package com.project.ui.deletelibrarian;

import com.project.alert.makeAlert;
import com.project.model.LibrarianEntity;
import com.project.service.LibrarianServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.NoResultException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class DeleteLibrarianController implements Initializable {
    @FXML
    private TextField librarianName;

    @FXML
    private ListView<String> listView;

    @FXML
    private AnchorPane mainController;

    private static Logger logger;

    static {
        System.setProperty("java.util.logging.config.file",
                "C:\\Users\\ylyho\\OneDrive\\Documente\\GitHub\\LibraryManager\\src\\main\\resources\\log.properties");
        //must initialize loggers after setting above property
        logger = Logger.getLogger(DeleteLibrarianController.class.getName());
    }

    ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
    LibrarianServiceImpl librarianService = (LibrarianServiceImpl) context.getBean(LibrarianServiceImpl.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void deleteLibrarian(ActionEvent actionEvent) {
        try {
            librarianService.deleteLibrarian(librarianName.getText());
            makeAlert.showConfirmationMessage("Librarian succesfully deleted!");
            logger.info("Librarian succesfully deleted from database!");
            close(actionEvent);
        } catch (Exception ex) {
            logger.warning("This user do not exist into database!");
        }
    }

    public void loadLibrarianInfo(ActionEvent actionEvent) {
        ObservableList<String> librarianData = FXCollections.observableArrayList();
        try {
            LibrarianEntity librarianEntity = librarianService.getLibrarianRepository().searchLibrarianByName(librarianName.getText());
            librarianData.add("Info about this librarian");
            librarianData.add("Librarian Name: " + librarianEntity.getLibrarianName());
            librarianData.add("Phone number: " + librarianEntity.getPhoneNumber());
            librarianData.add("Email: " + librarianEntity.getEmailAddress());
            librarianData.add("Address: " + librarianEntity.getAddress());


            listView.getItems().setAll(librarianData);
        } catch (NoResultException ex) {
           logger.warning("This name do not exist into database!");
        }
    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) mainController.getScene().getWindow();
        logger.info("Closing stage!");
        stage.close();
    }
}
