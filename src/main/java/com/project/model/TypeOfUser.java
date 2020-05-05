package com.project.model;

public enum TypeOfUser {
    ADMIN(0),
    LIBRARIAN(1);
    private final int typeOfUserCode;

    TypeOfUser(int typeOfUserCode) {
        this.typeOfUserCode = typeOfUserCode;
    }
}
