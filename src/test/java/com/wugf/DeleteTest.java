package com.wugf;

import com.wugf.model.Student;
import com.wugf.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by acer on 2018-7-2.
 */
public class DeleteTest extends BaseTest{

    @Autowired
    private StudentService studentService;

    /**
     * 根据id删除
     * db.collection.remove("_id":ObjectId("5b350a2da31bed34ac672e41"))
     */
    @Test
    public void delete() {
        studentService.deleteById("5b350a2da31bed34ac672e41");
    }

    /**
     * 根据属性删除
     */
    @Test
    public void deleteOperation() {
        Student student = new Student();
        student.setName("H5");
        System.out.println(studentService.deleteOperation(student));
    }


}
