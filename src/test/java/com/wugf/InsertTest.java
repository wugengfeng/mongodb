package com.wugf;

import com.wugf.model.Student;
import com.wugf.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by acer on 2018-6-27.
 */
public class InsertTest extends BaseTest {

    @Autowired
    private StudentService studentService;

    /**
     * 新增
     * 命令 : db.clooection.insert({})
     */
    @Test
    public void insert() {
        Student student = new Student();
        student.setAge(18);
        student.setSex("男");
        student.setName("java");
        student.setTags(Arrays.asList("H5","DB"));

        // 可以自定义id
        //student.setId("1");

        student = studentService.insert(student);
        System.out.println(student.getId());
    }

    /**
     * 当指定id且id存在则进行update 否则进行insert
     * 命令: db.collection.save({})
     */
    @Test
    public void save() {
        Student student = new Student();
        student.setAge(20);
        student.setSex("女");
        student.setName("H5");
        student.setTags(Arrays.asList("html"));

        student = studentService.save(student);
        System.out.println(student.getId());
    }

    @Test
    public void insertList() {
        List<Student> list = new ArrayList<>();
        Student s1 = new Student();
        s1.setName("小米");
        s1.setSex("男");
        s1.setAge(25);
        list.add(s1);

        Student s2 = new Student();
        s2.setName("华为");
        s2.setSex("男");
        s2.setAge(30);
        list.add(s2);

        list = studentService.insert(list);

        list.forEach((e) -> System.out.println(e.getId()));
    }
}
