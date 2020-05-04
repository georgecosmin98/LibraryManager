package com.project.repository;

import com.project.model.StudentEntity;
import com.project.repository.api.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public StudentEntity create(StudentEntity studentToCreate) {
        entityManager.persist(studentToCreate);
        return studentToCreate;
    }

    @Override
    public void save(StudentEntity s1) {
        this.entityManager.merge(s1);
    }

    @Override
    public void readStudent() {
        Query query = this.entityManager.createQuery("select s from StudentEntity s");
        System.out.println((StudentEntity) query.getSingleResult());
    }

    @Override
    public void deleteStudent(String sid) {
        Query query = this.entityManager.createQuery("select s from StudentEntity s where s.sid =: sid");
        query.setParameter("sid", sid);
        entityManager.remove(query.getSingleResult());
    }

    @Override
    public StudentEntity searchStudentBySID(String sid) {
        Query query = this.entityManager.createQuery("select s from StudentEntity s where s.sid=:sid");
        query.setParameter("sid", sid);
        return (StudentEntity) query.getSingleResult();
    }

    @Override
    public List<StudentEntity> displayAllStudent() {
        Query query = this.entityManager.createQuery("select s from StudentEntity s");
        return query.getResultList();
    }


}
