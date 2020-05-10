package com.project.service;

import com.project.model.BookBorrowEntity;
import com.project.model.BookBorrowStatus;
import com.project.repository.api.BookBorrowRepository;
import com.project.ui.settings.Settings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional
public class BookBorrowServiceImpl {

    @Resource
    private BookBorrowRepository bookBorrowRepository;

    public BookBorrowEntity createBookBorrow(String sid, String isbn, Date loanDate, Date submissionDate, BookBorrowStatus status) {
        BookBorrowEntity newBook = new BookBorrowEntity(sid, isbn, loanDate, submissionDate, status);
        return bookBorrowRepository.create(newBook);
    }

    public BookBorrowRepository getBookBorrowRepository() {
        return bookBorrowRepository;
    }

    public void updateBookBorrowStatus(String isbn, BookBorrowStatus status) {
        bookBorrowRepository.updateBookBorrowStatus(isbn, status);
    }

    public long fineCalculator(long daysBetween) {

        Settings settings = Settings.getSettings();
        return (long) (daysBetween * settings.getFinePerDay());
    }

    public long fine(String isbn) {
        long fineToPay = 0;
        try {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            long times = ft.parse(ft.format(new Date())).getTime() - bookBorrowRepository.searchBookByISBN(isbn).getSubmissionDate().getTime();
            long daysBetween = TimeUnit.DAYS.convert(times, TimeUnit.MILLISECONDS);
            if (daysBetween < 1)
                fineToPay = 0;
            else
                fineToPay = fineCalculator(daysBetween);
        } catch (ParseException ex) {
            Logger.getLogger(BookBorrowServiceImpl.class.getName()).log(Level.SEVERE, "Parse exception throws!", ex);
        }
        return fineToPay;
    }
}
