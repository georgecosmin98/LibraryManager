package com.project.service;

import com.project.model.LibrarianEntity;
import com.project.model.UserAccountEntity;
import com.project.repository.api.LibrarianRepository;
import com.project.repository.api.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class LibrarianServiceImpl {

    @Resource
    LibrarianRepository librarianRepository;
    @Resource
    UserAccountRepository userAccountRepository;
    public LibrarianEntity createLibrarian(String librarianName, String phoneNumber, String address, String email, UserAccountEntity userAccountEntity) {
        LibrarianEntity newLibrarian = new LibrarianEntity(librarianName, phoneNumber, address, email, userAccountEntity);
        return librarianRepository.create(newLibrarian);
    }

    public void deleteLibrarian(String name){
        LibrarianEntity deleteLibrarian = librarianRepository.searchLibrarianByName(name);
        librarianRepository.deleteLibrarian(deleteLibrarian.getLibrarianName());
        userAccountRepository.deleteUserAccount(deleteLibrarian.getUserAccountEntity().getId());
    }
    public LibrarianRepository getLibrarianRepository() {
        return librarianRepository;
    }
}
