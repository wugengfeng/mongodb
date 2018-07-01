package com.wugf;

import com.wugf.model.Student;
import com.wugf.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by acer on 2018-7-1.
 */
public class UpdateTest extends BaseTest {

    @Autowired
    private StudentService studentService;

    /**
     * 修改数据
     * db.collection.updateOne({query},{update})
     */
    @Test
    public void updateOne() {
        Student student = new Student();
        student.setId("5b350a2da31bed34ac672e41");
        student.setName("sexy girl");
        studentService.updateById(student);
    }

    /**
     * 批量修改
     * db.collection.update({quey},{update})
     */
    @Test
    public void updateMany() {
        Student student = new Student();
        student.setName("H5");
        student.setSex("男");
        System.out.println(studentService.updateByName(student));
    }
}
