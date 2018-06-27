package com.wugf;

import com.wugf.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by acer on 2018-6-27.
 */

public class QueryTest extends BaseTest{

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

}
