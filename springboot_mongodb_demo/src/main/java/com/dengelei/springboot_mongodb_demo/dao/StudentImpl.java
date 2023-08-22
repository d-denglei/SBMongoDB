package com.dengelei.springboot_mongodb_demo.dao;

import com.dengelei.springboot_mongodb_demo.pojo.Student;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @FileName： StudentImpl
 * @author： dengl
 * @date： 2021/12/27
 */
@Service
public class StudentImpl implements StudentDao{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Student student) {
        mongoTemplate.save(student);
    }

    @Override
    public void update(Student student) {
        //查询条件
        Query query = new Query(Criteria.where("_id").is(student.getId()));
        Update update = new Update();
        update.set("content",student.getContent());
        update.set("name",student.getName());
        update.set("userId",student.getUserId());
        //修改对象需要三个参数，
        mongoTemplate.updateFirst(query,update,Student.class);
    }

    @Override
    public List<Student> findAll() {

        return mongoTemplate.findAll(Student.class);
    }

    @Override
    public List<Student> find() {
        Criteria criteria = new Criteria();
        criteria.andOperator(
                Criteria.where("name").regex(".*i.*"),
                Criteria.where("visits").gte(100).lte(1225)
        );
        Query query = new Query(criteria);


        return mongoTemplate.find(query,Student.class,"student");
    }

    @Override
    public void delete(String id) {
        Student byId = mongoTemplate.findById(id, Student.class);
        mongoTemplate.remove(byId);
    }
}
