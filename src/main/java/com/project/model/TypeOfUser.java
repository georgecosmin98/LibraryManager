package com.project.model;

public enum TypeOfUser {
    ADMIN(0),
    LIBRARIAN(1),
    STUDENT(2);

    private final int typeOfUserCode;

    TypeOfUser(int typeOfUserCode) {
        this.typeOfUserCode = typeOfUserCode;
    }
}
