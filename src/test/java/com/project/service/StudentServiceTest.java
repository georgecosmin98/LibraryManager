package com.project.service;

import com.project.model.StudentEntity;
import com.project.repository.api.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentServiceImpl studentService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnCorrectCreateStudent(){
        StudentEntity savedStudent = new StudentEntity("123","MyName","MyPhone","Myaddress","MyEmail");
        studentService.createStudent(savedStudent);
        verify(studentRepository,times(1)).create(savedStudent);
    }

    @Test
    public void shouldReturnCorrectDeleteStudent(){

        studentService.deleteStudent("123");
        verify(studentRepository,times(1)).deleteStudent("123");
    }
}
