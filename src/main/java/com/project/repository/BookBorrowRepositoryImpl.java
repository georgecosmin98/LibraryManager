package com.project.repository;

import com.project.model.BookBorrowEntity;
import com.project.model.BookBorrowStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookBorrowRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public BookBorrowEntity create (BookBorrowEntity borrowToCreate) {
        entityManager.persist(borrowToCreate);
        return borrowToCreate;
    }

    public void save(BookBorrowEntity b1) {
        this.entityManager.merge(b1);
    }


    public List<BookBorrowEntity> displayAllBookBorrow() {
        Query query = this.entityManager.createQuery("select b from BookBorrowEntity b");
        return query.getResultList();
    }

    public void updateBookBorrowStatus(String isbn, BookBorrowStatus status){
        Query query = this.entityManager.createQuery("update BookBorrowEntity b set b.status =: status where b.isbn =:isbn");
        query.setParameter("isbn", isbn);
        query.setParameter("status",status);
        query.executeUpdate();
    }

    public BookBorrowEntity searchBookByISBN(String isbn) {
        Query query = this.entityManager.createQuery("select b from BookBorrowEntity b where b.isbn =:isbn");
        query.setParameter("isbn", isbn);
        return (BookBorrowEntity) query.getSingleResult();
    }
}
