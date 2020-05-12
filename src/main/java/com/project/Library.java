package com.project;

import com.project.model.BookStatus;
import com.project.service.BookBorrowServiceImpl;
import com.project.service.BookServiceImpl;
import com.project.service.UserAccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;


public class Library {
    private static Logger logger;

    static {
        System.setProperty("java.util.logging.config.file",
                "C:\\Users\\ylyho\\OneDrive\\Documente\\GitHub\\LibraryManager\\src\\main\\resources\\log.properties");
        //must initialize loggers after setting above property
        logger = Logger.getLogger(Library.class.getName());
    }
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");

        UserAccountServiceImpl userAccountService = (UserAccountServiceImpl) context.getBean(UserAccountServiceImpl.class);
        BookBorrowServiceImpl bookBorrowService = (BookBorrowServiceImpl) context.getBean(BookBorrowServiceImpl.class);
        BookServiceImpl bookService = (BookServiceImpl) context.getBean(BookServiceImpl.class);
        logger.info("Test");
        bookService.createBook("74","Capitan la 15 ani","Jules Verne",new Date(), BookStatus.AVAILABLE);

    }
}
