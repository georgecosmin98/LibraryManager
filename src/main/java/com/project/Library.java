package com.project;

import com.project.model.BookStatus;
import com.project.service.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Library {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");

        BookServiceImpl bookService = (BookServiceImpl) context.getBean(BookServiceImpl.class);

        bookService.createBook("3","Hatz","Dorian",ft.parse("2019-09-20"),BookStatus.AVAILABLE);


    }
}
