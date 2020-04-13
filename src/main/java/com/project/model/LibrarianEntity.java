package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_librarian")
public class LibrarianEntity extends AbstractBaseEntity{
    private String librarianName;
    private String phoneNumber;
    private String emailAddress;

    public LibrarianEntity() {
    }

    public LibrarianEntity(String librarianName, String phoneNumber, String emailAddress) {
        this.librarianName = librarianName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "LibrarianEntity{" +
                "librarianName='" + librarianName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
