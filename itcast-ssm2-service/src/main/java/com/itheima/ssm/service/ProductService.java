package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface ProductService {

    public Integer saveProduct(Product product) throws Exception;

    public List<Product> findAll() throws Exception;
}
