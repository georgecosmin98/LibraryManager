package com.project.service;

import com.project.model.BookEntity;
import com.project.model.BookStatus;
import com.project.repository.BookRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Transactional
public class BookServiceImpl {

    @Resource
    private BookRepositoryImpl bookRepository;

    public BookEntity createBook(String isbn, String title, String bookAuthor, Date yearOfPublication, BookStatus status) {
        BookEntity newFlight = new BookEntity(isbn, title, bookAuthor, yearOfPublication, status);
        return bookRepository.create(newFlight);
    }

    public BookRepositoryImpl getBookRepository() {
        return bookRepository;
    }
}
