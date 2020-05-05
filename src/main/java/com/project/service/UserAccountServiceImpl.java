package com.project.service;

import com.project.model.TypeOfUser;
import com.project.model.UserAccountEntity;
import com.project.repository.UserAccountRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserAccountServiceImpl {

    @Resource
    private UserAccountRepositoryImpl userAccountRepository;

    public UserAccountEntity createUser(String username, String password, TypeOfUser typeOfUser){
        UserAccountEntity userAccountEntity = new UserAccountEntity(username,password,typeOfUser);
        return userAccountRepository.create(userAccountEntity);
    }

    public UserAccountRepositoryImpl getUserAccountRepository(){
        return userAccountRepository;
    }
}
