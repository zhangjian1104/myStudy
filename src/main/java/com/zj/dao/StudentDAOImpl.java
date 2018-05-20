package com.zj.dao;

import com.zj.domain.Student;
import com.zj.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO 访问接口实现类，通过原生JDBC方式访问数据库
 */
public class StudentDAOImpl implements StudentDAO {
    /**
     * 查询全部学生信息
     * @return 全部学生信息
     */
    @Override
    public List<Student> queryAll() {

        List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "select id ,name ,age from spring_data.student";

        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            Student student;
            while (resultSet.next()) {
                student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"));
                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.realease(resultSet,preparedStatement,connection);
        }

        return students;
    }

    /**
     * 插入学生信息
     */
    @Override
    public void insert(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "insert into spring_data.student(name, age) values (?,?)";

        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.realease(null,preparedStatement,connection);
        }
    }
}
