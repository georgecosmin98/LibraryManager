package com.project.repository;

import com.project.model.LibrarianEntity;
import com.project.repository.api.LibrarianRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class LibrarianRepositoryImpl implements LibrarianRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public LibrarianEntity create(LibrarianEntity librarianToCreate) {
        entityManager.persist(librarianToCreate);
        return librarianToCreate;
    }

    @Override
    public List<LibrarianEntity> displayAllLibrarian() {
        Query query = this.entityManager.createQuery("select l from LibrarianEntity l");
        return query.getResultList();
    }

    @Override
    public LibrarianEntity searchLibrarianByName(String name) {
        Query query = this.entityManager.createQuery("select l from LibrarianEntity l where l.librarianName =:name");
        query.setParameter("name", name);
        return (LibrarianEntity) query.getSingleResult();
    }

    @Override
    public void deleteLibrarian(String name) {
        Query query = this.entityManager.createQuery("select l from LibrarianEntity l where l.librarianName = :name");
        query.setParameter("name", name);
        entityManager.remove(query.getSingleResult());
    }
}
