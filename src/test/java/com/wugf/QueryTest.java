package com.wugf;

import com.alibaba.fastjson.JSON;
import com.wugf.model.Student;
import com.wugf.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by acer on 2018-6-27.
 */

public class QueryTest extends BaseTest {

    @Autowired
    private StudentService studentService;

    /**
     * 查询所有
     * 命令:db.collection.find()
     */
    @Test
    public void findAll() {
        System.out.println(studentService.findAll().size());
    }

    /**
     * 排序
     * 命令 db.collection.find().sort("_id":-1)
     */
    @Test
    public void sort() {
        // Sort有多种构造方式
        Sort sort = Sort.by(Sort.Order.desc("_id"));

        List<Student> list = studentService.findAll(sort);
        System.out.println(JSON.toJSONString(list));
    }

    /**
     * 分页
     * 命令:db.collection.find().skip( (page-1) * size).limit(size)
     */
    @Test
    public void pageable() {
        Pageable pageInfo = PageRequest.of(1,1);
        Page<Student> page = studentService.findAll(pageInfo);

        // 获取查询内容
        System.out.println(page.getContent());

        // 总页数
        System.out.println(page.getTotalPages());

        /** 翻页操作
        page.nextPageable();
        page.previousPageable();
         */
    }

    /**
     * 根据实体属性做条件精确查询
     * 命令:db.collection.find({...})
     */
    @Test
    public void findByExample() {
        Student student = new Student();
        student.setId("5b3a4a797c5924302cc4c1cf");

        Example<Student> example = Example.of(student);
        List<Student> list = studentService.findAll(example);
        System.out.println(JSON.toJSONString(list));
    }


    /**
     * 根据id查询
     * 命令:db.student.find({"_id":{$in:[id1, id2]}})
     */
    @Test
    public void findAllById() {
        Iterable<Student> iterable = studentService.findAllById(Arrays.asList("5b3a4a797c5924302cc4c1ce"));
        Iterator<Student> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println(JSON.toJSONString(iterator.next()));
        }

    }

    /**
     * 根据条件匹配查询第一条
     * 命令: db.student.find({...}).limit(1)
     */
    @Test
    public void findOne() {
        Student student = new Student();
        student.setName("小米");
        Example<Student> example = Example.of(student);

        Optional<Student> result = studentService.findOne(example);
        System.out.println(JSON.toJSONString(result.get()));
    }

    /**
     * 不等于
     * db.student.find({"name":{$ne:"小米"}})
     */
    @Test
    public void ne() {
        Student student = new Student();
        student.setName("小米");
        System.out.println(JSON.toJSONString(studentService.ne(student)));
    }

    /**
     * 小于
     * db.student.find({"age":{$lt:20}})
     */
    @Test
    public void lt() {
        Student student = new Student();
        student.setAge(20);
        System.out.println(JSON.toJSONString(studentService.lt(student)));
    }

    /**
     * 小于等于
     * db.student.find({"age":{$lte:25}})
     */
    @Test
    public void lte() {
        Student student = new Student();
        student.setAge(25);
        System.out.println(JSON.toJSONString(studentService.lte(student)));
    }

    /**
     * 大于
     * db.student.find({"age":{$gt:20}})
     */
    @Test
    public void gt() {
        Student student = new Student();
        student.setAge(20);
        System.out.println(JSON.toJSONString(studentService.gt(student)));
    }

    /**
     * 大于等于
     * db.student.find({"age":{$gte:18}})
     */
    @Test
    public void gte() {
        Student student = new Student();
        student.setAge(18);
        System.out.println(JSON.toJSONString(studentService.gte(student)));
    }

    /**
     * 包含
     * db.student.find({"name":{$in:["小米","华为"]}})
     */
    @Test
    public void in() {
        String names[] = {"小米", "华为"};
        System.out.println(JSON.toJSONString(studentService.in(names)));
    }

    /**
     * 不包含
     * db.student.find({"name":{$nin:["小米"]}})
     */
    @Test
    public void nin() {
        String names[] = {"小米"};
        System.out.println(JSON.toJSONString(studentService.nin(names)));
    }

    /**
     * 模糊匹配(正则)
     * db.student.find({"name":{$regex:"米"}})
     */
    @Test
    public void regex() {
        Student student = new Student();
        student.setName("米");
        System.out.println(JSON.toJSONString(studentService.regex(student)));
    }
}
