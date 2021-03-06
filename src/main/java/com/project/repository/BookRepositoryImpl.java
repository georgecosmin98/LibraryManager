package com.project.repository;

import com.project.model.BookEntity;
import com.project.model.BookStatus;
import com.project.repository.api.BookRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BookEntity create(BookEntity bookToCreate) {
        entityManager.persist(bookToCreate);
        return bookToCreate;
    }

    @Override
    public void deleteBook(String title) {
        Query query = this.entityManager.createQuery("select b from BookEntity b where b.title = :title");
        query.setParameter("title", title);
        entityManager.remove(query.getSingleResult());
    }

    @Override
    public BookEntity searchBook(String title) {
        Query query = this.entityManager.createQuery("select b from BookEntity b where b.title =:title");
        query.setParameter("title", title);
        return (BookEntity) query.getSingleResult();
    }

    @Override
    public BookEntity searchBookByISBN(String isbn) {
        Query query = this.entityManager.createQuery("select b from BookEntity b where b.isbn =:isbn");
        query.setParameter("isbn", isbn);
        return (BookEntity) query.getSingleResult();
    }

    @Override
    public void updateBookStatus(String isbn,BookStatus status){
        Query query = this.entityManager.createQuery("update BookEntity b set b.status =: status where b.isbn =:isbn");
        query.setParameter("isbn", isbn);
        query.setParameter("status",status);
        query.executeUpdate();
    }

    @Override
    public List<BookEntity> displayAllBook() {
        Query query = this.entityManager.createQuery("select b from BookEntity b");
        return query.getResultList();
    }
}
