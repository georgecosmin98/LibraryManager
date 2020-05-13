package com.project.service;

import com.project.model.BookEntity;
import com.project.model.BookStatus;
import com.project.repository.api.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookServiceImpl bookService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldReturnCorrectUpdateStatus(){

        bookService.updateBookStatus("1234", BookStatus.AVAILABLE);
        verify(bookRepository,times(1)).updateBookStatus("1234", BookStatus.AVAILABLE);
    }

    @Test
    public void shouldReturnCorrectCreateBook(){
        Date myDate = new Date(2020,9,10);

        BookEntity savedBook = new BookEntity("123","Testing","Test",myDate,BookStatus.AVAILABLE);
        bookService.createBook(savedBook);
        verify(bookRepository,times(1)).create(savedBook);
    }

    @Test
    public void shouldReturnCorrectDeleteBook(){

        bookService.deleteBook("Test");
        verify(bookRepository,times(1)).deleteBook("Test");
    }
}
