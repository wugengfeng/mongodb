package com.wugf;

import com.wugf.dao.StudentRepository;
import com.wugf.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MongodbApplication.class)
public class MongodbApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private MongoTemplate template;

	@Test
	public void test(){
		List<Student> list = studentRepository.findAll();
		System.out.println(list.size());
	}
}
