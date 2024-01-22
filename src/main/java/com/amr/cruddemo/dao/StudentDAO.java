package com.amr.cruddemo.dao;

import com.amr.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByFirstName(String lastName);

    void update(Student student);

}
