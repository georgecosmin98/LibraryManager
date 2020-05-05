package com.project.service;

import com.project.model.LibrarianEntity;
import com.project.repository.LibrarianRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class LibrarianServiceImpl {

    @Resource
    LibrarianRepositoryImpl librarianRepository;

    public LibrarianEntity createLibrarian(String librarianName, String phoneNumber, String address, String email) {
        LibrarianEntity newLibrarian = new LibrarianEntity(librarianName, phoneNumber, address, email);
        return librarianRepository.create(newLibrarian);
    }

    public LibrarianRepositoryImpl getLibrarianRepository() {
        return librarianRepository;
    }
}
