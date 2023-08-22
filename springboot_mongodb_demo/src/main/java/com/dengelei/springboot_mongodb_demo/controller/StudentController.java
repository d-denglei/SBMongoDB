package com.dengelei.springboot_mongodb_demo.controller;

import com.dengelei.springboot_mongodb_demo.dao.StudentDao;
import com.dengelei.springboot_mongodb_demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @FileName： StudentController
 * @author： dengl
 * @date： 2021/12/27
 */

@RestController
public class StudentController {

    @Autowired
    private StudentDao studentImpl;

    @RequestMapping("/save")
    public String save(Student student) {
        studentImpl.save(student);
        return "1";
    }

    @RequestMapping("/update")
    public String update(Student student) {
        studentImpl.update(student);
        return "1";
    }

    @RequestMapping("/findAll")
    public List<Student> findAll() {

        return studentImpl.findAll();
    }

    @RequestMapping("/delete")
    public String delete(String id) {
        studentImpl.delete(id);
        return "1";
    }
}
