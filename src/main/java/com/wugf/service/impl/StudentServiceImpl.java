package com.wugf.service.impl;

import com.wugf.dao.StudentRepository;
import com.wugf.model.Student;
import com.wugf.service.StudentService;
import com.wugf.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by acer on 2018-6-27.
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<Student, String> implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

}
