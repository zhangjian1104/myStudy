package com.zj.dao;

import com.zj.domain.Student;

import java.util.List;

/**
 * StudentDAO 访问接口
 *
 * */
public interface StudentDAO {

    /**
     * 查询所有学生信息
     * @return 全部学生信息
     */
    List<Student> queryAll();
}
