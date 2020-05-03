package com.project.ui.main;

import com.project.service.BookServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    @FXML
    private Button listbook;

    @FXML
    private Button addstudent;

    @FXML
    private Button liststudent;

    @FXML
    private HBox book_info;

    @FXML
    private TextField bookISBNinput;

    @FXML
    private Text bookName;

    @FXML
    private Text bookAuthor;

    @FXML
    private HBox student_info;

    @FXML
    private TextField studentIDinput;

    @FXML
    private Text studentName;

    @FXML
    private Text phoneNumber;

    @FXML
    private Text Email;

    @FXML
    private Text status;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void addBook(ActionEvent actionEvent) throws IOException {
        loadWindows("/add_book.fxml", "Add book menu");
    }

    public void listbook(ActionEvent actionEvent) throws IOException {
        loadWindows("/list_book.fxml", "List book menu");
    }

    public void addstudent(ActionEvent actionEvent) throws IOException {
        loadWindows("/add_student.fxml", "Add student menu");
    }

    public void liststudent(ActionEvent actionEvent) throws IOException {
        loadWindows("/list_student.fxml", "List student menu");
    }

    public void loadWindows(String location, String windowsTitle) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(windowsTitle);
            stage.setScene(new Scene(parent));
            stage.initModality(Modality.APPLICATION_MODAL); //Blocheaza parintele pana e inchisa scena copilului
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Could not open " + windowsTitle);
        }
    }

    public void loadBookInfo(ActionEvent event){
        ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
        BookServiceImpl bookService = (BookServiceImpl) context.getBean(BookServiceImpl.class);

        bookName.setText(bookService.getBookRepository().searchBookByISBN(bookISBNinput.getText()).getTitle());
        bookAuthor.setText(bookService.getBookRepository().searchBookByISBN(bookISBNinput.getText()).getBookAuthor());
        status.setText(bookService.getBookRepository().searchBookByISBN(bookISBNinput.getText()).getStatus().toString());
    }
}
