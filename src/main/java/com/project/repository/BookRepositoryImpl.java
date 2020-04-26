package com.project.repository;

import com.project.model.BookEntity;
import com.project.repository.api.BookRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public BookEntity create(BookEntity bookToCreate) {
        entityManager.persist(bookToCreate);
        return bookToCreate;
    }

    public void save(BookEntity u1) {
        this.entityManager.merge(u1);
    }

    public void readBook() {
        Query query = this.entityManager.createQuery("select b from BookEntity b");
        System.out.println((BookEntity) query.getSingleResult());
    }

    public void deleteBook(String title) {
        Query query = this.entityManager.createQuery("select b from BookEntity b where b.title = :title");
        query.setParameter("title", title);
        entityManager.remove(query.getSingleResult());
    }

    public BookEntity searchBook(String title) {
        Query query = this.entityManager.createQuery("select b from BookEntity b where BookEntity =:title");
        query.setParameter("title", title);
        return (BookEntity) query.getSingleResult();
    }

    public void displayAllBook() {
        Query query = this.entityManager.createQuery("select b from BookEntity b");
        System.out.println(query.getResultList());
    }
}
