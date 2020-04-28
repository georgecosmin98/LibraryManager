package com.project.repository.api;

import com.project.model.StudentEntity;

public interface StudentRepository {

    StudentEntity create(StudentEntity studentToCreate);

    void save(StudentEntity s1);

    void readStudent();

    void deleteStudent(String sid);

    StudentEntity searchStudent(String sid);
}
