package com.project.service;

import com.project.model.StudentEntity;
import com.project.repository.api.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Service
@Transactional
public class StudentServiceImpl{

    @Resource
    private StudentRepository studentRepository;

    private static Logger logger;

    static {
        System.setProperty("java.util.logging.config.file",
                "C:\\Users\\ylyho\\OneDrive\\Documente\\GitHub\\LibraryManager\\src\\main\\resources\\log.properties");
        //must initialize loggers after setting above property
        logger = Logger.getLogger(StudentServiceImpl.class.getName());
    }

    public StudentEntity createStudent(String sid, String studentName, String phoneNumber, String address, String emailAddress) {
        StudentEntity newStudent = new StudentEntity(sid, studentName, phoneNumber, address, emailAddress);
        logger.info("Creating student");
        return studentRepository.create(newStudent);
    }

    public StudentEntity createStudent(StudentEntity studentEntity) {
        logger.info("Creating student");
        return studentRepository.create(studentEntity);
    }


    public void deleteStudent(String sid) {
        logger.info("Deleting student from database");
        studentRepository.deleteStudent(sid);
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }
}
