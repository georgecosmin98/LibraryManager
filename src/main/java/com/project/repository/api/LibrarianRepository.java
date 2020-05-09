package com.project.repository.api;

import com.project.model.LibrarianEntity;

import java.util.List;

public interface LibrarianRepository {

    LibrarianEntity create(LibrarianEntity librarianToCreate);

    List<LibrarianEntity> displayAllLibrarian();

    LibrarianEntity searchLibrarianByName(String name);

    void deleteLibrarian(String name);
}
