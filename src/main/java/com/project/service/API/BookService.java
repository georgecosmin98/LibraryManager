package com.project.service.API;

import com.project.model.BookEntity;
import com.project.model.BookStatus;
import com.project.repository.BookRepositoryImpl;

import java.util.Date;

public interface BookService {

    public BookEntity createBook(String isbn, String title, String bookAuthor, Date yearOfPublication, BookStatus status);
    public void deleteBook(String title);
    public BookRepositoryImpl getBookRepository();

}
