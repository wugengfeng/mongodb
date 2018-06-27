package com.wugf.dao;

import com.wugf.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by acer on 2018-6-28.
 */
public interface ProductRepository extends MongoRepository<Product, String> {
}
