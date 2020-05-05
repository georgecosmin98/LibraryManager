package com.project;
import com.project.service.BookServiceImpl;
import com.project.service.StudentServiceImpl;
import com.project.service.UserAccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;


public class Library {
    public static void main(String[] args) {

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");

        StudentServiceImpl studentService = (StudentServiceImpl) context.getBean(StudentServiceImpl.class);

        BookServiceImpl bookService = (BookServiceImpl) context.getBean((BookServiceImpl.class));
        UserAccountServiceImpl userAccountService = (UserAccountServiceImpl) context.getBean(UserAccountServiceImpl.class);

    }
}
