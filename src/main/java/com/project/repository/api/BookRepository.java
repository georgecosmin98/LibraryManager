package com.project.repository.api;

import com.project.model.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {

    BookEntity create(BookEntity bookToCreate);

    void save(BookEntity u1);

    void readBook();

    void deleteBook(String title);

    BookEntity searchBook(String title);

    List<BookEntity> displayAllBook();
}

