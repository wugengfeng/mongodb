package com.wugf.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by acer on 2018-6-27.
 */
public abstract class BaseServiceImpl<T, ID>{
    protected MongoRepository<T, ID> mongoRepository;

    @Autowired
    public void setMongoRepository(MongoRepository<T, ID> mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    public <S extends T> S save(S s) {
        return mongoRepository.save(s);
    }

    public <S extends T> List<S> saveAll(Iterable<S> entites) {
        return mongoRepository.saveAll(entites);
    }

    public Optional<T> findById(ID id) {
        return mongoRepository.findById(id);
    }

    public boolean existsById(ID id) {
        return mongoRepository.existsById(id);
    }

    public List<T> findAll() {
        return mongoRepository.findAll();
    }

    public Iterable<T> findAllById(Iterable<ID> iterable) {
        return mongoRepository.findAllById(iterable);
    }

    public long count() {
        return mongoRepository.count();
    }

    public void deleteById(ID id) {
        mongoRepository.deleteById(id);
    }

    public void delete(T t) {
        mongoRepository.delete(t);
    }

    public void deleteAll(Iterable<? extends T> iterable) {
        mongoRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        mongoRepository.deleteAll();
    }

    public List<T> findAll(Sort sort) {
        return mongoRepository.findAll(sort);
    }

    public Page<T> findAll(Pageable pageable) {
        return mongoRepository.findAll(pageable);
    }

    public <S extends T> S insert(S entity) {
        return mongoRepository.insert(entity);
    }

    public <S extends T> List<S> insert(Iterable<S> entities) {
        return mongoRepository.insert(entities);
    }

    public <S extends T> Optional<S> findOne(Example<S> example) {
        return mongoRepository.findOne(example);
    }

    public <S extends T> List<S> findAll(Example<S> example) {
        return mongoRepository.findAll(example);
    }

    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return mongoRepository.findAll(example, sort);
    }

    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return mongoRepository.findAll(example, pageable);
    }

    public <S extends T> long count(Example<S> example) {
        return mongoRepository.count();
    }

    public <S extends T> boolean exists(Example<S> example) {
        return mongoRepository.exists(example);
    }
}
