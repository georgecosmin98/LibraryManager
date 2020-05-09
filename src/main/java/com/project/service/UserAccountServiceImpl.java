package com.project.service;

import com.project.model.TypeOfUser;
import com.project.model.UserAccountEntity;
import com.project.repository.api.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserAccountServiceImpl {

    @Resource
    private UserAccountRepository userAccountRepository;

    public UserAccountEntity createUser(String username, String password, TypeOfUser typeOfUser){
        UserAccountEntity userAccountEntity = new UserAccountEntity(username,password,typeOfUser);
        return userAccountRepository.create(userAccountEntity);
    }

    public UserAccountRepository getUserAccountRepository(){
        return userAccountRepository;
    }
}
