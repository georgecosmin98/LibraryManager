package com.project.service;

import com.project.model.LibrarianEntity;
import com.project.model.UserAccountEntity;
import com.project.repository.api.LibrarianRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LibrarianServiceTest {

    @Mock
    LibrarianRepository librarianRepository;

    @InjectMocks
    LibrarianServiceImpl librarianService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnCorrectCreateLibrarian() {
        UserAccountEntity userAccountEntity = new UserAccountEntity();
        LibrarianEntity librarianEntity = new LibrarianEntity("MyName", "0765123456", "MyAddress", "MyEmail", userAccountEntity);
        librarianService.createLibrarian(librarianEntity);
        verify(librarianRepository,times(1)).create(librarianEntity);
    }

}
