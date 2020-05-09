package com.project;
import com.project.service.UserAccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;


public class Library {
    public static void main(String[] args) {

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");

        UserAccountServiceImpl userAccountService = (UserAccountServiceImpl) context.getBean(UserAccountServiceImpl.class);

    }
}
