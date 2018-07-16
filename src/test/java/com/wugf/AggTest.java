package com.wugf;

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
}
