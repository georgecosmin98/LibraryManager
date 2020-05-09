package com.project.repository.api;

import com.project.model.BookEntity;
import com.project.model.BookStatus;

import java.util.List;

public interface BookRepository {

    BookEntity create(BookEntity bookToCreate);

    void deleteBook(String title);

    BookEntity searchBook(String title);

    BookEntity searchBookByISBN(String isbn);

    void updateBookStatus(String isbn, BookStatus status);

    List<BookEntity> displayAllBook();
}

