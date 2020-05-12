package com.project.service;

import com.project.model.BookEntity;
import com.project.model.BookStatus;
import com.project.repository.api.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.logging.Logger;

@Service
@Transactional
public class BookServiceImpl {

    @Resource
    private BookRepository bookRepository;

    private static Logger logger;

    static {
        System.setProperty("java.util.logging.config.file",
                "C:\\Users\\ylyho\\OneDrive\\Documente\\GitHub\\LibraryManager\\src\\main\\resources\\log.properties");
        //must initialize loggers after setting above property
        logger = Logger.getLogger(BookServiceImpl.class.getName());
    }

    public BookEntity createBook(String isbn, String title, String bookAuthor, Date yearOfPublication, BookStatus status) {
        BookEntity newBook = new BookEntity(isbn, title, bookAuthor, yearOfPublication, status);
        logger.info("Creating new book");
        return bookRepository.create(newBook);
    }

    public void deleteBook(String title) {
        logger.info("Deleting book from database");
        bookRepository.deleteBook(title);
    }

    public void updateBookStatus(String isbn, BookStatus status) {
        logger.info("Updating book status");
        bookRepository.updateBookStatus(isbn, status);
    }


    public BookRepository getBookRepository() {
        return bookRepository;
    }
}
