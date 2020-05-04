package com.project.ui.listbookborrow;

import com.project.model.BookBorrowEntity;
import com.project.service.BookBorrowServiceImpl;
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

public class listBookBorrowController implements Initializable {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<BookBorrowEntity> tableView;

    @FXML
    private TableColumn<BookBorrowEntity, String> idCol;

    @FXML
    private TableColumn<BookBorrowEntity, String> sidCol;

    @FXML
    private TableColumn<BookBorrowEntity, String> isbnCol;

    @FXML
    private TableColumn<BookBorrowEntity, Date> loanCol;

    @FXML
    private TableColumn<BookBorrowEntity, Date> submissionCol;

    ObservableList<BookBorrowEntity> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCol();
        ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
        BookBorrowServiceImpl bookBorrowService = (BookBorrowServiceImpl) context.getBean(BookBorrowServiceImpl.class);
        tableView.getItems().setAll(createBookList(bookBorrowService.getBookBorrowRepository().displayAllBookBorrow()));
    }

    private void initCol() {
        idCol.setCellValueFactory(new PropertyValueFactory<BookBorrowEntity, String>("id"));
        sidCol.setCellValueFactory(new PropertyValueFactory<BookBorrowEntity, String>("sid"));
        isbnCol.setCellValueFactory(new PropertyValueFactory<BookBorrowEntity, String>("isbn"));
        loanCol.setCellValueFactory(new PropertyValueFactory<BookBorrowEntity, Date>("loanDate"));
        submissionCol.setCellValueFactory(new PropertyValueFactory<BookBorrowEntity, Date>("submissionDate"));
    }

    public List<BookBorrowEntity> createBookList(List<BookBorrowEntity> allBooks) {
        List<BookBorrowEntity> bookBorrowList = allBooks;
        for (BookBorrowEntity b : bookBorrowList) {
            list.add(new BookBorrowEntity(b.getId(),b.getSid(),b.getIsbn(),b.getLoanDate(),b.getSubmissionDate()));
        }
        return list;
    }
}
