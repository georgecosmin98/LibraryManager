package com.project.service;

import com.project.model.TypeOfUser;
import com.project.model.UserAccountEntity;
import com.project.repository.api.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Service
@Transactional
public class UserAccountServiceImpl {

    @Resource
    private UserAccountRepository userAccountRepository;

    private static Logger logger;

    static {
        System.setProperty("java.util.logging.config.file",
                "C:\\Users\\ylyho\\OneDrive\\Documente\\GitHub\\LibraryManager\\src\\main\\resources\\log.properties");
        //must initialize loggers after setting above property
        logger = Logger.getLogger(UserAccountServiceImpl.class.getName());
    }

    public UserAccountEntity createUser(String username, String password, TypeOfUser typeOfUser){
        UserAccountEntity userAccountEntity = new UserAccountEntity(username,password,typeOfUser);
        logger.info("Creating user account");
        return userAccountRepository.create(userAccountEntity);
    }

    public UserAccountRepository getUserAccountRepository(){
        return userAccountRepository;
    }
}
