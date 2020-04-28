package com.project.service.API;

import com.project.model.StudentEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface StudentService {

    StudentEntity createStudent(String sid, String studentName, String phoneNumber, String address, String emailAddress);
    void deleteStudent(String sid);
}
