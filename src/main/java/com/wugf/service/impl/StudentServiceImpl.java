package com.wugf.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.wugf.model.Student;
import com.wugf.service.StudentService;
import com.wugf.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by acer on 2018-6-27.
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<Student, String> implements StudentService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public long updateById(Student student) {
        Query query = new Query();
        // 设置查询条件
        Criteria criteria = new Criteria();
        criteria.andOperator(
                Criteria.where("id").is(student.getId())
        );
        query.addCriteria(criteria);

        Update update = new Update();
        update.set("name", student.getName());

        UpdateResult result = mongoTemplate.updateFirst(query, update, Student.class);
        return result.getModifiedCount();
    }

    @Override
    public long updateByName(Student student) {
        Query query = new Query();
        Criteria criteria = Criteria.where("name").is(student.getName());
        query.addCriteria(criteria);

        Update update = new Update();
        update.set("sex", student.getSex());

        UpdateResult result = mongoTemplate.updateMulti(query, update, Student.class);
        return result.getModifiedCount();
    }

    @Override
    public long deleteOperation(Student student) {
        Query query = new Query();
        Criteria criteria = Criteria.where("name").is(student.getName());
        // 这句很重要
        query.addCriteria(criteria);

        DeleteResult result = mongoTemplate.remove(query, Student.class);
        return result.getDeletedCount();
    }

    @Override
    public List<Student> ne(Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").ne(student.getName()));

        return mongoTemplate.find(query, Student.class);
    }

    @Override
    public List<Student> lt(Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").lt(student.getAge()));
        return mongoTemplate.find(query, Student.class);
    }

    @Override
    public List<Student> lte(Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").lte(student.getAge()));
        return mongoTemplate.find(query, Student.class);
    }

    @Override
    public List<Student> gt(Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(student.getAge()));
        return mongoTemplate.find(query, Student.class);
    }

    @Override
    public List<Student> gte(Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gte(student.getAge()));
        return mongoTemplate.find(query, Student.class);
    }

    @Override
    public List<Student> in(String ...names) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").in(names));
        return mongoTemplate.find(query, Student.class);
    }

    @Override
    public List<Student> nin(String ...names) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").nin(names));
        return mongoTemplate.find(query, Student.class);
    }

    @Override
    public List<Student> regex(Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(student.getName()));
        return mongoTemplate.find(query, Student.class);
    }
}
