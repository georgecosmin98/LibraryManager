package com.project.ui.deletestudent;

import com.project.alert.makeAlert;
import com.project.model.StudentEntity;
import com.project.service.BookBorrowServiceImpl;
import com.project.service.StudentServiceImpl;
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

public class DeleteStudentController implements Initializable {

    @FXML
    private TextField studentSid;

    @FXML
    private Button deleteButton;

    @FXML
    private ListView<String> listView;

    ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
    StudentServiceImpl studentService = (StudentServiceImpl) context.getBean(StudentServiceImpl.class);
    BookBorrowServiceImpl bookBorrowService = (BookBorrowServiceImpl) context.getBean((BookBorrowServiceImpl.class));

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadStudentInfo(ActionEvent actionEvent) {
        ObservableList<String> studentData = FXCollections.observableArrayList();
        try {
            StudentEntity studentEntity = studentService.getStudentRepository().searchStudentBySID(studentSid.getText());
            studentData.add("Info about this student");
            studentData.add("Student Name: " + studentEntity.getStudentName());
            studentData.add("Phone number: " + studentEntity.getPhoneNumber());
            studentData.add("Email: " + studentEntity.getEmailAddress());
            studentData.add("Address: " + studentEntity.getAddress());


            listView.getItems().setAll(studentData);
        } catch (NoResultException ex) {
            System.out.println("This name do not exist into database!");
        }
    }

    public void deleteStudent(ActionEvent actionEvent) {

        try {//nu e bine!!!
            if(bookBorrowService.getBookBorrowRepository().searchBookBySID(studentSid.getText()).isEmpty()){
                studentService.deleteStudent(studentSid.getText());
            }
            else
            {
                makeAlert.showMessageAlert("This student do not return all books!");
            }
        } catch (NoResultException ex) {
            makeAlert.showMessageAlert("This student do not exist");
        }
    }
}
