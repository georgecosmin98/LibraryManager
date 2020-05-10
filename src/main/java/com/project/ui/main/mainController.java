package com.project.ui.main;

import com.project.alert.makeAlert;
import com.project.model.*;
import com.project.service.BookBorrowServiceImpl;
import com.project.service.BookServiceImpl;
import com.project.service.StudentServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

    @FXML
    private DatePicker submissionDate;

    @FXML
    private TextField isbnSubmission;

    @FXML
    private Button returnButton;

    @FXML
    private ListView<String> listSubmissionView;

    @FXML
    private StackPane mainController;

    ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
    BookBorrowServiceImpl bookBorrowService = (BookBorrowServiceImpl) context.getBean(BookBorrowServiceImpl.class);
    BookServiceImpl bookService = (BookServiceImpl) context.getBean(BookServiceImpl.class);
    StudentServiceImpl studentService = (StudentServiceImpl) context.getBean(StudentServiceImpl.class);

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

    public void deleteBook(ActionEvent actionEvent) throws IOException {
        loadWindows("/delete_book.fxml", "Delete book menu");
    }

    public void deleteStudent(ActionEvent actionEvent) throws IOException {
        loadWindows("/delete_student.fxml", "Delete student menu");
    }

    public void settings(ActionEvent actionEvent) throws IOException{
        loadWindows("/settings.fxml","Settings menu");
    }


    public void listBorrowBook(ActionEvent actionEvent) {
        loadWindows("/list_bookborrow.fxml", "List borrow book");
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

    public void loadBookInfo(ActionEvent event) {
        try{
        bookName.setText(bookService.getBookRepository().searchBookByISBN(bookISBNinput.getText()).getTitle());
        bookAuthor.setText(bookService.getBookRepository().searchBookByISBN(bookISBNinput.getText()).getBookAuthor());
        status.setText(bookService.getBookRepository().searchBookByISBN(bookISBNinput.getText()).getStatus().toString());
    }catch(NoResultException ex){
            makeAlert.showMessageAlert("This book do not exist into database!");
        }
    }

    public void loadStudentInfo(ActionEvent actionEvent) {

        try {
            studentName.setText(studentService.getStudentRepository().searchStudentBySID(studentIDinput.getText()).getStudentName());

            phoneNumber.setText(studentService.getStudentRepository().searchStudentBySID(studentIDinput.getText()).getPhoneNumber());
            Email.setText(studentService.getStudentRepository().searchStudentBySID(studentIDinput.getText()).getEmailAddress());
        }catch (NoResultException ex){
            makeAlert.showMessageAlert("This student do not exist into database!");
        }
    }

    public void issueBook(ActionEvent actionEvent) throws ParseException {

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String date = submissionDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (bookService.getBookRepository().searchBookByISBN(bookISBNinput.getText()).getStatus().equals(BookStatus.AVAILABLE)) {
            bookBorrowService.createBookBorrow(studentIDinput.getText(), bookISBNinput.getText(), ft.parse(ft.format(new Date())), ft.parse(date), BookBorrowStatus.ISSUED);
            bookService.updateBookStatus(bookISBNinput.getText(), BookStatus.NOTAVAILABLE);

        } else {
            makeAlert.showMessageAlert("This book is not available!");
        }
    }

    public void returnBook(ActionEvent actionEvent) {

        if (bookService.getBookRepository().searchBookByISBN(isbnSubmission.getText()).getStatus().equals(BookStatus.NOTAVAILABLE)) {
            long fineAmmount= bookBorrowService.fine(bookISBNinput.getText());
            if (fineAmmount>0)
                makeAlert.showMessageAlert("You must pay a fine of: " + fineAmmount);
            bookService.updateBookStatus(isbnSubmission.getText(), BookStatus.AVAILABLE);
            bookBorrowService.updateBookBorrowStatus(isbnSubmission.getText(), BookBorrowStatus.RETURNED);

        } else
            makeAlert.showMessageAlert("This book is already returned or not exist in database, please check if ISBN is correct write!");
    }

    public void loadSubmissionInfo(ActionEvent actionEvent) {

        try {
            ObservableList<String> issueData = FXCollections.observableArrayList();
            BookBorrowEntity bookBorrowEntity = bookBorrowService.getBookBorrowRepository().searchBookByISBN(isbnSubmission.getText());
            BookEntity bookEntity = bookService.getBookRepository().searchBookByISBN(isbnSubmission.getText());
            StudentEntity studentEntity = studentService.getStudentRepository().searchStudentBySID(bookBorrowEntity.getSid());

            if (bookBorrowEntity.getStatus().equals(BookBorrowStatus.ISSUED)) {
                issueData.add("Issue Date and Time: " + bookBorrowEntity.getLoanDate());
                issueData.add("Book Information: ");
                issueData.add("Book Title: " + bookEntity.getTitle());
                issueData.add("Book Author: " + bookEntity.getBookAuthor());
                issueData.add("Student Information: ");
                issueData.add("Student Name: " + studentEntity.getStudentName());
                issueData.add("Student Phone Number: " + studentEntity.getPhoneNumber());
                issueData.add("Student Email: " + studentEntity.getEmailAddress());
            } else
                makeAlert.showMessageAlert("This isbn is incorrect or this book is already returned!");

            listSubmissionView.getItems().setAll(issueData);
        } catch (NoResultException ex) {
            makeAlert.showMessageAlert("This book is not borrowed or do not exist into database!");
        }
    }

    public void logOut(ActionEvent actionEvent) {
        loadWindows("/login.fxml", "Login Screen");
        Stage stage = (Stage) mainController.getScene().getWindow();
        stage.close();

    }
}
