package com.project.ui.listlibrarian;

import com.project.model.LibrarianEntity;
import com.project.service.LibrarianServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListLibrarianController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<LibrarianEntity> tableView;

    @FXML
    private TableColumn<LibrarianEntity, String> nameCol;

    @FXML
    private TableColumn<LibrarianEntity, String> phoneNumberCol;

    @FXML
    private TableColumn<LibrarianEntity, String> addressCol;

    @FXML
    private TableColumn<LibrarianEntity, String> emailCol;

    ObservableList<LibrarianEntity> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCol();
        ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
        LibrarianServiceImpl librarianService = (LibrarianServiceImpl) context.getBean(LibrarianServiceImpl.class);
        tableView.getItems().setAll(createLibrarianList(librarianService.getLibrarianRepository().displayAllLibrarian()));
    }

    private void initCol(){
        nameCol.setCellValueFactory(new PropertyValueFactory<LibrarianEntity, String>("librarianName"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<LibrarianEntity, String>("phoneNumber"));
        addressCol.setCellValueFactory(new PropertyValueFactory<LibrarianEntity, String>("address"));
        emailCol.setCellValueFactory(new PropertyValueFactory<LibrarianEntity, String>("emailAddress"));
    }
    public List<LibrarianEntity> createLibrarianList(List<LibrarianEntity> allLibrarians){
        List<LibrarianEntity> librararianList = allLibrarians;
        for (LibrarianEntity l : librararianList){
            list.add(new LibrarianEntity(l.getLibrarianName(),l.getPhoneNumber(),l.getAddress(),l.getEmailAddress(),l.getUserAccountEntity()));
        }
        return list;
    }
}
