package com.dengelei.springboot_mongodb_demo;

import com.dengelei.springboot_mongodb_demo.dao.StudentDao;
import com.dengelei.springboot_mongodb_demo.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMongodbDemoApplicationTests {

    @Autowired
    private StudentDao studentDao;

    @Test
    void tt(){
        List<Student> students = studentDao.find();
        System.out.println(students);

    }


    @Test
    void contextLoads() {


    }

}
