package com.project.service;

import com.project.model.TypeOfUser;
import com.project.model.UserAccountEntity;
import com.project.repository.api.UserAccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UserAccountServiceTest {

    @Mock
    UserAccountRepository userAccountRepository;

    @InjectMocks
    UserAccountServiceImpl userAccountService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnCorrectCreateUserAccount(){

        UserAccountEntity userAccountEntity = new UserAccountEntity("MyUsername","MyPassword", TypeOfUser.LIBRARIAN);
        userAccountService.createUser(userAccountEntity);
        verify(userAccountRepository,times(1)).create(userAccountEntity);
    }
}
