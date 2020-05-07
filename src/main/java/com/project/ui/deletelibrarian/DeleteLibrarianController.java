package com.project.ui.deletelibrarian;

import com.project.model.LibrarianEntity;
import com.project.service.LibrarianServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.NoResultException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteLibrarianController implements Initializable {
    @FXML
    private TextField librarianName;

    @FXML
    private Button deleteButton;

    @FXML
    private ListView<String> listView;

    ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
    LibrarianServiceImpl librarianService = (LibrarianServiceImpl) context.getBean(LibrarianServiceImpl.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void deleteLibrarian(ActionEvent actionEvent) {
        try {
            librarianService.getLibrarianRepository().deleteLibrarian(librarianName.getText());
        } catch (Exception ex) {
            System.out.println("This user do not exist into database!");
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
            System.out.println("This name do not exist into database!");
        }
    }
}
