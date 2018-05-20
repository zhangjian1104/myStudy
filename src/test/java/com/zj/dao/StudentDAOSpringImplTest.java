package com.zj.dao;

import com.zj.domain.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOSpringImplTest {

    private ApplicationContext ctx = null;
    private StudentDAOSpringImpl studentDAOSpring = null;

    @Before
    public void setUp()  {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDAOSpring = (StudentDAOSpringImpl)ctx.getBean("studentDaoSpringImpl");
        System.out.println("test begin");
    }

    @After
    public void tearDown()  {
        ctx = null;
        studentDAOSpring = null;
        System.out.println("test end");
    }

    @Test
    public void queryAll() {
        List<Student> students = studentDAOSpring.queryAll();
        Assert.assertTrue(students.size()>0);
        for (Student student:
             students) {
            System.out.println(student.toString());
        }

    }

    @Test
    public void insert() {
        studentDAOSpring.insert(new Student("spring jdbc",33));
    }
}