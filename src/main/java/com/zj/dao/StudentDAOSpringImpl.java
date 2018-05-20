package com.zj.dao;

import com.zj.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用JDBCTemplate
 */
public class StudentDAOSpringImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> queryAll() {
        final List<Student> students = new ArrayList<>();
        String sql = "select id ,name ,age from spring_data.student";

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                students.add(new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age")));
            }
        });
        return students;
    }

    @Override
    public void insert(Student student) {
        String sql = "insert into spring_data.student(name, age) values (?,?)";
        jdbcTemplate.update(sql, student.getName(), student.getAge());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
