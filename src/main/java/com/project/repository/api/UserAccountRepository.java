package com.project.repository.api;

import com.project.model.UserAccountEntity;

import java.util.List;

public interface UserAccountRepository {

    UserAccountEntity create(UserAccountEntity userToCreate);
    void deleteUserAccount(long id);
    List<UserAccountEntity> displayAllUsers();
    List<UserAccountEntity> searchUser(String username, String password);

}
