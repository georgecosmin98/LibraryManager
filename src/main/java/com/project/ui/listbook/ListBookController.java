package com.project.ui.listbook;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ListBookController implements Initializable {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> isbnCol;

    @FXML
    private TableColumn<?, ?> titleCol;

    @FXML
    private TableColumn<?, ?> authorCol;

    @FXML
    private TableColumn<?, ?> yearOfPublCol;

    @FXML
    private TableColumn<?, ?> statusCol;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
}
