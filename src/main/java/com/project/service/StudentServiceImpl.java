package com.project.service;

import com.project.model.StudentEntity;
import com.project.repository.StudentRepositoryImpl;
import com.project.service.API.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentRepositoryImpl studentRepository;

    @Override
    public StudentEntity createStudent(String sid, String studentName, String phoneNumber, String address, String emailAddress) {
        StudentEntity newStudent = new StudentEntity(sid, studentName, phoneNumber, address, emailAddress);
        return studentRepository.create(newStudent);
    }

    @Override
    public void deleteStudent(String sid) {
        studentRepository.deleteStudent(sid);
    }

    public StudentRepositoryImpl getStudentRepository() {
        return studentRepository;
    }
}
