package com.project.repository;

import com.project.model.UserAccountEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserAccountRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;

    public UserAccountEntity create(UserAccountEntity userToCreate) {
        entityManager.persist(userToCreate);
        return userToCreate;
    }

    public void deleteUserAccount(String id) {
        Query query = this.entityManager.createQuery("select u from UserAccountEntity u where u.id =: id");
        query.setParameter("id", id);
        entityManager.remove(query.getSingleResult());
    }

    public List<UserAccountEntity> displayAllUsers() {
        Query query = this.entityManager.createQuery("select u from UserAccountEntity u");
        return query.getResultList();
    }

    public List<UserAccountEntity> searchUser(String username, String password) {
            Query query = this.entityManager.createQuery("select u from UserAccountEntity u where u.username =: username and u.password =: password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getResultList();

        }
    }

