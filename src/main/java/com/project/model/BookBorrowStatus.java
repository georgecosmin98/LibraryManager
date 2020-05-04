package com.project.model;

public enum BookBorrowStatus {
    ISSUED(0),
    RETURNED(1);

    private final int bookBorrowStatusCode;

    BookBorrowStatus(int bookBorrowStatusCode) {
        this.bookBorrowStatusCode = bookBorrowStatusCode;
    }
}
