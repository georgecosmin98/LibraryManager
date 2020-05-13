package com.project.service;

import com.project.model.BookBorrowEntity;
import com.project.model.BookBorrowStatus;
import com.project.repository.api.BookBorrowRepository;
import com.project.ui.settings.Settings;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BookBorrowServiceTest {

    @Mock
    BookBorrowRepository bookBorrowRepository;

    @InjectMocks
    BookBorrowServiceImpl bookBorrowService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnCorrectFine() {

        Settings settings = Settings.getSettings();
        float numberOfDays = 2;
        long expected = (long) (settings.getFinePerDay() * numberOfDays);
        long count = bookBorrowService.fineCalculator((long) numberOfDays);
        Assert.assertEquals("Should return correct fine ammount: ", expected, count);
    }

    @Test
    public void shouldReturnCorrectUpdateStatus(){

        bookBorrowService.updateBookBorrowStatus("1234", BookBorrowStatus.RETURNED);
        verify(bookBorrowRepository,times(1)).updateBookBorrowStatus("1234", BookBorrowStatus.RETURNED);
    }

    @Test
    public void shouldReturnCorrectCreateBookBorrow(){

        BookBorrowEntity savedBook = new BookBorrowEntity("123","345",new Date(), new Date(),BookBorrowStatus.RETURNED);
        bookBorrowService.createBookBorrow(savedBook);
        verify(bookBorrowRepository,times(1)).create(savedBook);
    }

}
