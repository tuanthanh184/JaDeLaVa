package com.aptech.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void create(Student student) {
        String sql = "INSERT INTO student(id,name,gender,dob,address,mobile,email) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement statement = DBManager.getInstance().getConnection().prepareStatement(sql)) {
            statement.setLong(1, student.getId());
            statement.setString(2, student.getName());
            statement.setBoolean(3, student.isGender());
            statement.setDate(4, (Date) student.getDob());
            statement.setString(5, student.getAddress());
            statement.setString(6, student.getMobile());
            statement.setString(7, student.getEmail());
            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("Them sinh vien thanh cong");
            } else {
                System.out.println("Them sinh vien that bai");
            }
            DBManager.getInstance().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        String sql = "UPDATE student SET name=?, gender=?, dob=?,address=?,mobile=?,email=? WHERE id=?";
        try (PreparedStatement statement = DBManager.getInstance().getConnection().prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setBoolean(2, student.isGender());
            statement.setDate(3, (Date) student.getDob());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getMobile());
            statement.setString(6, student.getEmail());
            statement.setLong(7, student.getId());
            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("Cap nhat thong tin sinh vien thanh cong");
            } else {
                System.out.println("Cap nhat thong tin sinh vien that bai");
            }
            DBManager.getInstance().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(long studentId) {
        boolean result = false;
        String sql = "DELETE FROM student where id = ?";
        try (PreparedStatement statement = DBManager.getInstance().getConnection().prepareStatement(sql)) {
            statement.setLong(1, studentId);
            int output = statement.executeUpdate();
            if (output > 0) {
                result = true;
                System.out.println("Xoa sinh vien thanh cong");
            } else {
                System.out.println("Xoa sinh vien that bai");
            }
            DBManager.getInstance().close();
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * from student";
        List<Student> students = new ArrayList<>();
        try (PreparedStatement statement = DBManager.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setGender(resultSet.getBoolean("gender"));
                student.setDob(resultSet.getDate("dob"));
                student.setAddress(resultSet.getString("address"));
                student.setMobile(resultSet.getString("mobile"));
                student.setEmail(resultSet.getString("email"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
