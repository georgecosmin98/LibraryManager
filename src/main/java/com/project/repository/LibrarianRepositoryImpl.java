package com.project.repository;

import com.project.model.LibrarianEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LibrarianRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;

    public LibrarianEntity create(LibrarianEntity librarianToCreate) {
        entityManager.persist(librarianToCreate);
        return librarianToCreate;
    }
}
