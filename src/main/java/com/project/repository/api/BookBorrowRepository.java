package com.project.repository.api;

import com.project.model.BookBorrowEntity;
import com.project.model.BookBorrowStatus;

import java.util.List;

public interface BookBorrowRepository {

    public BookBorrowEntity create(BookBorrowEntity borrowToCreate);
    public List<BookBorrowEntity> displayAllBookBorrow();
    public void updateBookBorrowStatus(String isbn, BookBorrowStatus status);
    public BookBorrowEntity searchBookByISBN(String isbn);
}
