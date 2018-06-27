package com.wugf.service.impl;

import com.wugf.dao.ProductRepository;
import com.wugf.model.Product;
import com.wugf.service.ProductService;
import com.wugf.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by acer on 2018-6-28.
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, String> implements ProductService{

    @Autowired
    private ProductRepository productRepository;

}
