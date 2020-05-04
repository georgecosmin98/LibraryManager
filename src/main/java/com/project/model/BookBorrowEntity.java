package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_bookBorrow")
public class BookBorrowEntity extends AbstractBaseEntity{
    String sid;
    String isbn;
    Date loanDate;
    Date submissionDate;
    BookBorrowStatus status;

    public BookBorrowEntity(String sid, String isbn, Date loanDate, Date submissionDate,BookBorrowStatus status) {
        this.sid = sid;
        this.isbn = isbn;
        this.loanDate = loanDate;
        this.submissionDate = submissionDate;
        this.status = status;
    }

    public BookBorrowEntity(long id, String sid, String isbn, Date loanDate, Date submissionDate,BookBorrowStatus status) {
        super(id);
        this.sid = sid;
        this.isbn = isbn;
        this.loanDate = loanDate;
        this.submissionDate = submissionDate;
        this.status = status;
    }

    public BookBorrowEntity() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public BookBorrowStatus getStatus() {
        return status;
    }

    public void setStatus(BookBorrowStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookBorrowEntity{" +
                "sid='" + sid + '\'' +
                ", isbn='" + isbn + '\'' +
                ", loanDate=" + loanDate +
                ", submissionDate=" + submissionDate +
                ", status=" + status +
                '}';
    }
}
