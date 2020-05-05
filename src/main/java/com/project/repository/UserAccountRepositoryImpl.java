package com.project.repository;

import com.project.model.UserAccountEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserAccountRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;

    public UserAccountEntity create(UserAccountEntity userToCreate){
        entityManager.persist(userToCreate);
        return userToCreate;
    }

    public void deleteUserAccount(String id){
        Query query = this.entityManager.createQuery("select u from UserAccountEntity u where u.id =: id");
        query.setParameter("id", id);
        entityManager.remove(query.getSingleResult());
    }

    public List<UserAccountEntity> displayAllUsers(){
        Query query = this.entityManager.createQuery("select u from UserAccountEntity u");
        return query.getResultList();
    }



}
