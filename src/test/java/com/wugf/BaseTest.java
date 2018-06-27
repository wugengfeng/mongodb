package com.wugf;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by acer on 2018-6-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MongodbApplication.class)
public abstract class BaseTest {
}
