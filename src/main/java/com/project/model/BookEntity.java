package com.project.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.internal.SessionImpl;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_book")
public class BookEntity {

    @Id
    private String isbn;
    private String title;
    private String bookAuthor;
    private Date yearOfPublication;
    private BookStatus status;

    public BookEntity() {
    }

    public BookEntity(String isbn, String title, String bookAuthor, Date yearOfPublication, BookStatus status) {
        this.isbn = isbn;
        this.title = title;
        this.bookAuthor = bookAuthor;
        this.yearOfPublication = yearOfPublication;
        this.status = status;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Date getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Date yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    @Override
    public String toString() {
        return "BookEntity{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", status=" + status +
                '}';
    }


}
