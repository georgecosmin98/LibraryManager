package com.project;

import com.project.model.BookEntity;
import com.project.model.BookStatus;
import com.project.repository.BookRepositoryImpl;
import com.project.service.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Library {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");

        BookServiceImpl bookService = (BookServiceImpl) context.getBean(BookServiceImpl.class);

        List<BookEntity> bookList = bookService.getBookRepository().displayAllBook();



    }
}
