package com.project.ui.liststudent;

import com.project.model.BookEntity;
import com.project.model.BookStatus;
import com.project.model.StudentEntity;
import com.project.service.BookServiceImpl;
import com.project.service.StudentServiceImpl;
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

public class ListStudentController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<StudentEntity> tableView;

    @FXML
    private TableColumn<StudentEntity, String> sid;

    @FXML
    private TableColumn<StudentEntity, String> studentName;

    @FXML
    private TableColumn<StudentEntity, String> phoneNumber;

    @FXML
    private TableColumn<StudentEntity, String> address;

    @FXML
    private TableColumn<StudentEntity, String> email;

    ObservableList<StudentEntity> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCol();
        ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");
        StudentServiceImpl studentService = (StudentServiceImpl) context.getBean(StudentServiceImpl.class);
        tableView.getItems().setAll(createStudentList(studentService.getStudentRepository().displayAllStudent()));
    }

    private void initCol() {
        sid.setCellValueFactory(new PropertyValueFactory<StudentEntity, String>("sid"));
        studentName.setCellValueFactory(new PropertyValueFactory<StudentEntity, String>("studentName"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<StudentEntity, String>("phoneNumber"));
        address.setCellValueFactory(new PropertyValueFactory<StudentEntity, String>("address"));
        email.setCellValueFactory(new PropertyValueFactory<StudentEntity, String>("emailAddress"));

    }
    public List<StudentEntity> createStudentList(List<StudentEntity> allStudents){
        List<StudentEntity> studentList = allStudents;
        for (StudentEntity s : studentList){
            list.add(new StudentEntity(s.getSid(),s.getStudentName(),s.getPhoneNumber(),s.getAddress(),s.getEmailAddress()));
        }
        return list;
    }
}
