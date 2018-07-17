package com.wugf;

import com.alibaba.fastjson.JSON;
import com.wugf.model.Student;
import com.wugf.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

/**
 * Created by acer on 2018-7-15.
 */
public class AggTest extends BaseTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void max() {

        AggregationResults<Student> results = studentService.max();
        System.out.println(results.getMappedResults().get(0).getAge());
    }

    @Test
    public void min() {
        AggregationResults<Student> results = studentService.min();
        System.out.println(results.getMappedResults().get(0).getAge());
    }

    @Test
    public void avg() {
        AggregationResults<Student> results = studentService.avg();
        System.out.println(results.getMappedResults().get(0).getAge());
    }

    @Test
    public void sum() {
        AggregationResults<Student> results = studentService.sum();
        System.out.println(results.getMappedResults().get(0).getAge());
    }

    @Test
    public void first() {
        AggregationResults<Student> results = studentService.first();
        System.out.println(results.getMappedResults().get(0).getAge());
    }

    @Test
    public void last() {
        AggregationResults<Student> results = studentService.last();
        System.out.println(results.getMappedResults().get(0).getAge());
    }

    @Test
    public void count() {
        System.out.println(studentService.count());
    }

    @Test
    public void count2() {
        Student student = new Student();
        student.setSex("男");
        Example<Student> example = Example.of(student);

        System.out.println(studentService.count(example));
    }

    /**
     * 命令：db.student.aggregate([{$project:{name:1}}])
     * 指定展示字段
     */
    @Test
    public void project() {
        AggregationResults<Student> results = studentService.project();
        results.getMappedResults().forEach(student -> System.out.println(JSON.toJSONString(student)));
    }

    /**
     * 命令：db.student.aggregate([
                 {$match:{sex:"女"}},
                 {$group:{_id:null,age:{$max:"$age"}}}
                 ])
        用于过滤数据，只输出符合条件的文档
     */
    @Test
    public void match() {
        AggregationResults<Student> results = studentService.match();
        results.getMappedResults().forEach(student -> System.out.println(JSON.toJSONString(student)));
    }

    /**
     * 命令：db.student.aggregate([{$skip:1},{$limit:1}])
     */
    @Test
    public void skip() {
        AggregationResults<Student> results = studentService.skip();
        results.getMappedResults().forEach(student -> System.out.println(JSON.toJSONString(student)));
    }

    /**
     * 命令：db.student.aggregate([
             {$group:{_id:"$sex",count:{$sum:1}}},
             {$sort:{"count":-1}}
            ])
     */
    @Test
    public void sort() {
        AggregationResults<Student> results = studentService.sort();
        results.getMappedResults().forEach(student -> System.out.println(JSON.toJSONString(student)));
    }

    /**
     * 命令：
     *  db.student.insertOne({name:"数组","sex":"男","age":25,"skip":["java","H5","Mysql"]})
         db.student.aggregate([
            {$unwind:"$skip"}
         ])
     */
    @Test
    public void unwind() {
        AggregationResults<Student> results = studentService.unwind();
        results.getMappedResults().forEach(student -> System.out.println(JSON.toJSONString(student)));
    }
}
