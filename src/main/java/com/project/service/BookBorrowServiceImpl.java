package com.project.service;

import com.project.model.BookBorrowEntity;
import com.project.repository.BookBorrowRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Transactional
public class BookBorrowServiceImpl {

    @Resource
    private BookBorrowRepositoryImpl bookBorrowRepository;

    public BookBorrowEntity createBookBorrow(String sid, String isbn, Date loanDate, Date submissionDate) {
        BookBorrowEntity newBook = new BookBorrowEntity(sid, isbn, loanDate, submissionDate);
        return bookBorrowRepository.create(newBook);
    }

    public BookBorrowRepositoryImpl getBookBorrowRepository() {
        return bookBorrowRepository;
    }
}
