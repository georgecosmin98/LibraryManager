package com.project.service.API;

import com.project.model.StudentEntity;

public interface StudentService {

    StudentEntity createStudent(String sid, String studentName, String phoneNumber, String address, String emailAddress);
    void deleteStudent(String sid);
}
