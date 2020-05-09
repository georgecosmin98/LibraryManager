package com.project.service;

import com.project.model.LibrarianEntity;
import com.project.repository.api.LibrarianRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class LibrarianServiceImpl {

    @Resource
    LibrarianRepository librarianRepository;

    public LibrarianEntity createLibrarian(String librarianName, String phoneNumber, String address, String email) {
        LibrarianEntity newLibrarian = new LibrarianEntity(librarianName, phoneNumber, address, email);
        return librarianRepository.create(newLibrarian);
    }

    public LibrarianRepository getLibrarianRepository() {
        return librarianRepository;
    }
}
