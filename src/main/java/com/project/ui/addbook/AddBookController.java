package com.project.ui.addbook;

import com.project.model.BookStatus;
import com.project.service.BookServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javafx.event.ActionEvent;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddBookController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainController;

    @FXML
    private TextField isbn;

    @FXML
    private TextField title;

    @FXML
    private TextField bookauthor;

    @FXML
    private DatePicker data;

    @FXML
    private Button save;

    @FXML
    private Button close;

    @FXML
    private StackPane rootPane;

    BookServiceImpl bookService;

    @FXML
    void initialize() {
    }

    public void initialize(URL location, ResourceBundle resources) {

    }


    public void addBook(ActionEvent actionEvent) throws ParseException {
        String bookId = isbn.getText();
        String bookTitle = title.getText();
        String bookAuthor = bookauthor.getText();

        ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
        BookServiceImpl bookService = (BookServiceImpl) context.getBean(BookServiceImpl.class);

        if (bookId.isEmpty() || bookTitle.isEmpty() || bookAuthor.isEmpty() || data.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter in all fields");
            alert.showAndWait();
            return;
        }
        String date = data.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        bookService.createBook(bookId, bookTitle, bookAuthor, ft.parse(date), BookStatus.AVAILABLE);
    }


    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) mainController.getScene().getWindow();
        stage.close();
    }
}
