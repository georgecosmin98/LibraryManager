package com.project.service.API;

import com.project.model.BookEntity;
import com.project.model.BookStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public interface BookService {

    BookEntity createBook(String isbn, String title, String bookAuthor, Date yearOfPublication, BookStatus status);

    void deleteBook(String title);
}
