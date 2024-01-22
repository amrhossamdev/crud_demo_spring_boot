package com.amr.cruddemo.dao;

import com.amr.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by firstName", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE firstName=:theData", Student.class);
        query.setParameter("theData", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        // return number of rows effected.
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
