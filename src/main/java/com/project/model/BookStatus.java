package com.project.model;

public enum BookStatus {
    AVAILABLE(0),
    NOTAVAILABLE(1);

    private final int bookStatusCode;

    BookStatus(int bookStatusCode) {
        this.bookStatusCode = bookStatusCode;
    }
}
