package com.project.repository;

import com.project.model.BookBorrowEntity;
import com.project.model.BookBorrowStatus;
import com.project.repository.api.BookBorrowRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BookBorrowRepositoryImpl implements BookBorrowRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BookBorrowEntity create(BookBorrowEntity borrowToCreate) {
        entityManager.persist(borrowToCreate);
        return borrowToCreate;
    }

    @Override
    public List<BookBorrowEntity> displayAllBookBorrow() {
        Query query = this.entityManager.createQuery("select b from BookBorrowEntity b");
        return query.getResultList();
    }

    @Override
    public void updateBookBorrowStatus(String isbn, BookBorrowStatus status) {
        Query query = this.entityManager.createQuery("update BookBorrowEntity b set b.status =: status where b.isbn =:isbn");
        query.setParameter("isbn", isbn);
        query.setParameter("status", status);
        query.executeUpdate();
    }

    @Override
    public BookBorrowEntity searchBookByISBN(String isbn) {
        Query query = this.entityManager.createQuery("select b from BookBorrowEntity b where b.isbn =:isbn and b.status =: stats");
        query.setParameter("isbn", isbn);
        query.setParameter("stats", BookBorrowStatus.ISSUED);
        return (BookBorrowEntity) query.getSingleResult();
    }

    public List <BookBorrowEntity> searchBookBySID(String sid) {
        Query query = this.entityManager.createQuery("select b from BookBorrowEntity b where b.sid =:sid  and b.status =: stats");
        query.setParameter("sid", sid);
        query.setParameter("stats", BookBorrowStatus.ISSUED);
        return query.getResultList();
    }
}
