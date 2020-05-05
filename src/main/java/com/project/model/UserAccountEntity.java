package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_useraccount")
public class UserAccountEntity extends AbstractBaseEntity {

    private String username;
    private String password;
    private TypeOfUser typeOfUser;

    public UserAccountEntity(String username, String password, TypeOfUser typeOfUser) {
        this.username = username;
        this.password = password;
        this.typeOfUser = typeOfUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TypeOfUser getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(TypeOfUser typeOfUser) {
        this.typeOfUser = typeOfUser;
    }
}
