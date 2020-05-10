package com.project.service;

import com.project.ui.settings.Settings;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

public class BookBorrowServiceTest {

    private BookBorrowServiceImpl bookBorrowService;
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
    @Before
    public void setUp(){
        this.bookBorrowService = new BookBorrowServiceImpl();
    }

    @Test
    public void shouldReturnCorrectFine(){

        Settings settings = Settings.getSettings();
        float numberOfDays = 2;
        long expected = (long) (settings.getFinePerDay()*numberOfDays);
        long count = bookBorrowService.fineCalculator((long) numberOfDays);
        Assert.assertEquals("Should return correct fine ammount: ",expected,count);
    }
    
}
