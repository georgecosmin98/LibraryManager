package com.project.repository;

import com.project.model.LibrarianEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class LibrarianRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;

    public LibrarianEntity create(LibrarianEntity librarianToCreate) {
        entityManager.persist(librarianToCreate);
        return librarianToCreate;
    }

    public List<LibrarianEntity> displayAllLibrarian() {
        Query query = this.entityManager.createQuery("select l from LibrarianEntity l");
        return query.getResultList();
    }
}
