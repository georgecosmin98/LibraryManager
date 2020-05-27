package com.project.service;

import com.project.alert.makeAlert;
import com.project.model.LibrarianEntity;
import com.project.model.UserAccountEntity;
import com.project.repository.api.LibrarianRepository;
import com.project.repository.api.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Service
@Transactional
public class LibrarianServiceImpl {

    @Resource
    LibrarianRepository librarianRepository;
    @Resource
    UserAccountRepository userAccountRepository;

    private static Logger logger;

    static {
        System.setProperty("java.util.logging.config.file",
                "C:\\Users\\ylyho\\OneDrive\\Documente\\GitHub\\LibraryManager\\src\\main\\resources\\log.properties");
        //must initialize loggers after setting above property
        logger = Logger.getLogger(LibrarianServiceImpl.class.getName());
    }

    public LibrarianEntity createLibrarian(String librarianName, String phoneNumber, String address, String email, UserAccountEntity userAccountEntity) {
        LibrarianEntity newLibrarian = new LibrarianEntity(librarianName, phoneNumber, address, email, userAccountEntity);
        logger.info("Creating new librarian");
        return librarianRepository.create(newLibrarian);
    }

    public LibrarianEntity createLibrarian(LibrarianEntity librarianEntity) {
        logger.info("Creating new librarian");
        return librarianRepository.create(librarianEntity);
    }

    public void deleteLibrarian(String name){
        LibrarianEntity deleteLibrarian = librarianRepository.searchLibrarianByName(name);
        logger.info("Deleting librarian from databse");
        librarianRepository.deleteLibrarian(deleteLibrarian.getLibrarianName());
        logger.info("Deleting user account from database");
        userAccountRepository.deleteUserAccount(deleteLibrarian.getUserAccountEntity().getId());
        makeAlert.showConfirmationMessage("Librarian succesfully deleted from database!");
    }
    public LibrarianRepository getLibrarianRepository() {
        return librarianRepository;
    }
}
