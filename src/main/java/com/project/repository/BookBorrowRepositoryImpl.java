package com.project.repository;

import com.project.model.BookBorrowEntity;
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

}
