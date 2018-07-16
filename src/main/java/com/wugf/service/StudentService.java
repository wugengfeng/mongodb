package com.wugf.service;

import com.wugf.model.Student;
import com.wugf.service.base.BaseService;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.List;

/**
 * Created by acer on 2018-6-27.
 */
public interface StudentService extends BaseService<Student, String> {

    long updateById(Student student);

    long updateByName(Student student);

    long deleteOperation(Student student);

    /********  查询 ********/

    /**
     * 不等于
     * @param student
     * @return
     */
    List<Student> ne(Student student);

    /**
     * 小于
     * @param student
     * @return
     */
    List<Student> lt(Student student);

    /**
     * 小于等于
     * @param student
     * @return
     */
    List<Student> lte(Student student);

    /**
     * 大于
     * @param student
     * @return
     */
    List<Student> gt(Student student);

    /**
     * 大于等于
     * @param student
     * @return
     */
    List<Student> gte(Student student);

    /**
     * 包含
     * @param student
     * @return
     */
    List<Student> in(String ...names);

    /**
     * 不包含
     * @param student
     * @return
     */
    List<Student> nin(String ...names);

    /**
     * 模糊查询（正则）
     * @param student
     * @return
     */
    List<Student> regex(Student student);

    /**
     * 获取最大值
     * @return
     */
    AggregationResults<Student> max();

    /**
     * 获取最小值
     * @return
     */
    AggregationResults<Student> min();

    /**
     * 获取平均值
     * @return
     */
    AggregationResults<Student> avg();

    /**
     * 求总和
     * @return
     */
    AggregationResults<Student> sum();

    /**
     * 获取第一条数据
     */
    AggregationResults<Student> first();

    /**
     * 获取最后一条数据
     */
    AggregationResults<Student> last();
}
