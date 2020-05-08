package com.project.ui.deletebook;

import com.project.alert.makeAlert;
import com.project.model.BookEntity;
import com.project.model.BookStatus;
import com.project.service.BookServiceImpl;
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

public class DeleteBookController implements Initializable {

    @FXML
    private TextField ISBN;

    @FXML
    private Button deleteButton;

    @FXML
    private ListView<String> listView;

    ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
    BookServiceImpl bookService = (BookServiceImpl) context.getBean(BookServiceImpl.class);

    public void deleteBook(ActionEvent actionEvent) {
        try{
           if(bookService.getBookRepository().searchBookByISBN(ISBN.getText()).getStatus().equals(BookStatus.AVAILABLE))
               bookService.getBookRepository().deleteBook(bookService.getBookRepository().searchBookByISBN(ISBN.getText()).getTitle());
           else
               makeAlert.showMessageAlert("This book is not available, please check if ISBN is correct or if this book has been returned!");
        }catch (Exception ex){
            System.out.println("This book ISBN do not exist into database!");
            makeAlert.showMessageAlert("This book ISBN do not exist into database!");
        }
    }

    public void loadBookInfo(ActionEvent actionEvent) {
        ObservableList<String>  bookData = FXCollections.observableArrayList();
        try{
            BookEntity bookEntity =bookService.getBookRepository().searchBookByISBN(ISBN.getText());
            bookData.add ("Info about this book: \n");
            bookData.add ("Book Author: " + bookEntity.getBookAuthor());
            bookData.add ("Book Title: " + bookEntity.getTitle());
            bookData.add ("Book year of publication: " + bookEntity.getYearOfPublication());
            bookData.add ("Book status: " + bookEntity.getStatus());
        }
        catch(NoResultException ex){
            makeAlert.showMessageAlert("This book do not exist into database!");
        }

        listView.getItems().setAll(bookData);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
