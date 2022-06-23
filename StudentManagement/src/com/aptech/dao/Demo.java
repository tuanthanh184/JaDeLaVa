package com.aptech.dao;

public class Demo {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.findAll();
    }
}
