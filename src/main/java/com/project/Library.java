package com.project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Library {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("library_application_context.xml");


    }
}
