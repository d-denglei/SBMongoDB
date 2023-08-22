package com.dengelei.springboot_mongodb_demo.dao;

import com.dengelei.springboot_mongodb_demo.pojo.Student;

import java.util.List;

/**
 * @FileName： StudentDao
 * @author： dengl
 * @date： 2021/12/27
 */

public interface StudentDao {

    void save(Student student);

    void update(Student student);

    List<Student> findAll();

    List<Student> find();

    void delete(String id);
}
