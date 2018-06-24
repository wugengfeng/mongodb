package com.wugf.dao;

import com.wugf.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by acer on 2018-6-24.
 */
public interface StudentRepository extends MongoRepository<Student, String> {

}
