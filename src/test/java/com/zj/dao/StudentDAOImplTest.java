package com.zj.dao;

import com.zj.domain.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOImplTest {

    @Test
    public void testQueryAll() {
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.queryAll();

        Assert.assertTrue(students.size() > 0);
        for (Student student:
             students) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void testInsert() {
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student("insert2", 45);
        studentDAO.insert(student);
    }
}