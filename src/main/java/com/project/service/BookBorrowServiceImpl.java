package com.project.service;

import com.project.model.BookBorrowEntity;
import com.project.model.BookBorrowStatus;
import com.project.repository.api.BookBorrowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Transactional
public class BookBorrowServiceImpl {

    @Resource
    private BookBorrowRepository bookBorrowRepository;

    public BookBorrowEntity createBookBorrow(String sid, String isbn, Date loanDate, Date submissionDate, BookBorrowStatus status) {
        BookBorrowEntity newBook = new BookBorrowEntity(sid, isbn, loanDate, submissionDate,status);
        return bookBorrowRepository.create(newBook);
    }

    public BookBorrowRepository getBookBorrowRepository() {
        return bookBorrowRepository;
    }

    public void updateBookBorrowStatus (String isbn, BookBorrowStatus status){
        bookBorrowRepository.updateBookBorrowStatus(isbn,status);
    }
}
