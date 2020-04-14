package com.project.service.API;

import com.project.model.BookEntity;
import com.project.model.BookStatus;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BookService {


    BookEntity createBook(String isbn, String title, String bookAuthor, Date yearOfPublication, BookStatus status);
    public void deleteBook(String title);
}
