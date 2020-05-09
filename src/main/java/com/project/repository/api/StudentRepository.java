package com.project.repository.api;

import com.project.model.StudentEntity;

import java.util.List;

public interface StudentRepository {

    StudentEntity create(StudentEntity studentToCreate);

    void save(StudentEntity s1);

    void readStudent();

    void deleteStudent(String sid);

    StudentEntity searchStudentBySID(String sid);

    List<StudentEntity> displayAllStudent();
}
