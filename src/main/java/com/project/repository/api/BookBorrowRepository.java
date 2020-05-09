package com.project.repository.api;

import com.project.model.BookBorrowEntity;
import com.project.model.BookBorrowStatus;

import java.util.List;

public interface BookBorrowRepository {

    BookBorrowEntity create(BookBorrowEntity borrowToCreate);

    List<BookBorrowEntity> displayAllBookBorrow();

    void updateBookBorrowStatus(String isbn, BookBorrowStatus status);

    BookBorrowEntity searchBookByISBN(String isbn);

    List <BookBorrowEntity> searchBookBySID(String sid);
}
