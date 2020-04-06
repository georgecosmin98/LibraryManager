package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_book")
public class BookEntity {

    private String title;
    private String bookAuthor;
    private Date yearOfPublication;
    private BookStatus status;

    public BookEntity() {
    }

    public BookEntity(String title, String bookAuthor, Date yearOfPublication, BookStatus status) {
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

    @Override
    public String toString() {
        return "BookEntity{" +
                "title='" + title + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", status=" + status +
                '}';
    }
}
