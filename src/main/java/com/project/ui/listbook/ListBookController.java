package com.project.ui.listbook;

import com.project.model.BookEntity;
import com.project.model.BookStatus;
import com.project.service.BookServiceImpl;
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
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class ListBookController implements Initializable {

    ObservableList<BookEntity> list = FXCollections.observableArrayList();

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<BookEntity> tableView;

    @FXML
    private TableColumn<BookEntity, String> isbnCol;

    @FXML
    private TableColumn<BookEntity, String> titleCol;

    @FXML
    private TableColumn<BookEntity, String> authorCol;

    @FXML
    private TableColumn<BookEntity, Date> yearOfPublCol;

    @FXML
    private TableColumn<BookEntity, BookStatus> statusCol;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCol();
        ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
        BookServiceImpl bookService = (BookServiceImpl) context.getBean(BookServiceImpl.class);
        tableView.getItems().setAll(createBookList(bookService.getBookRepository().displayAllBook()));
        }

        private void initCol(){
            isbnCol.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("isbn"));
            titleCol.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("title"));
            authorCol.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("bookAuthor"));
            yearOfPublCol.setCellValueFactory(new PropertyValueFactory<BookEntity, Date>("yearOfPublication"));
            statusCol.setCellValueFactory(new PropertyValueFactory<BookEntity, BookStatus>("Status"));
    }

        public List<BookEntity> createBookList(List<BookEntity> allBooks){
            List<BookEntity> bookList = allBooks;
            for (BookEntity b : bookList){
                String ISBN = b.getIsbn();
                String Title = b.getTitle();
                String Author = b.getBookAuthor();
                Date Date = b.getYearOfPublication();
                BookStatus Status = b.getStatus();
                list.add(new BookEntity(ISBN,Title,Author,Date,Status));
            }
            return list;
        }
}

