package com.aptech.dao;

import java.util.List;

public interface StudentDao {
    void create(Student student);

    void update(Student student);

    boolean delete(long studentId);

    List<Student> findAll();
}
