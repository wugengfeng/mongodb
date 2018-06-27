package com.wugf.dao;

import com.wugf.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 类似mybatis 的 dao,直接继承 MongoRepository 提供 insert,delete,find基本操作
 */
public interface StudentRepository extends MongoRepository<Student, String> {

}
