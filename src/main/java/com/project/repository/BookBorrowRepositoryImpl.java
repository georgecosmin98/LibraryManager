package com.project.repository;

import com.project.model.BookBorrowEntity;
import com.project.model.BookBorrowStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BookBorrowRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public BookBorrowEntity create(BookBorrowEntity borrowToCreate) {
        entityManager.persist(borrowToCreate);
        return borrowToCreate;
    }

    public List<BookBorrowEntity> displayAllBookBorrow() {
        Query query = this.entityManager.createQuery("select b from BookBorrowEntity b");
        return query.getResultList();
    }

    public void updateBookBorrowStatus(String isbn, BookBorrowStatus status) {
        Query query = this.entityManager.createQuery("update BookBorrowEntity b set b.status =: status where b.isbn =:isbn");
        query.setParameter("isbn", isbn);
        query.setParameter("status", status);
        query.executeUpdate();
    }

    public BookBorrowEntity searchBookByISBN(String isbn) {
        Query query = this.entityManager.createQuery("select b from BookBorrowEntity b where b.isbn =:isbn and b.status =: stats");
        query.setParameter("isbn", isbn);
        query.setParameter("stats", BookBorrowStatus.ISSUED);
        return (BookBorrowEntity) query.getSingleResult();
    }
}
