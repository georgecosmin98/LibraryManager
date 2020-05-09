package com.project.model;

import javax.persistence.*;

@Entity
@Table(name = "t_librarian")
public class LibrarianEntity extends AbstractBaseEntity {
    private String librarianName;
    private String phoneNumber;
    private String address;
    private String emailAddress;

    @OneToOne(targetEntity = UserAccountEntity.class, fetch = FetchType.EAGER)
    private UserAccountEntity userAccountEntity;

    public UserAccountEntity getUserAccountEntity() {
        return userAccountEntity;
    }

    public void setUserAccountEntity(UserAccountEntity userAccountEntity) {
        this.userAccountEntity = userAccountEntity;
    }

    public LibrarianEntity() {
    }

    public LibrarianEntity(String librarianName, String phoneNumber, String address, String emailAddress,UserAccountEntity userAccountEntity) {
        this.librarianName = librarianName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.emailAddress = emailAddress;
        this.userAccountEntity=userAccountEntity;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "LibrarianEntity{" +
                "librarianName='" + librarianName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
