package com.wugf.service;

import com.wugf.model.Student;
import com.wugf.service.base.BaseService;

/**
 * Created by acer on 2018-6-27.
 */
public interface StudentService extends BaseService<Student, String> {

    long updateById(Student student);

    long updateByName(Student student);
}
