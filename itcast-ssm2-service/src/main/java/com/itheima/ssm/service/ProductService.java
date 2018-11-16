package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface ProductService {

    public Integer saveProduct(Product product) throws Exception;

    public List<Product> findAll(Integer page, Integer pageZise) throws Exception;

    void deleteByIds(String[] ids);

    //根据id查询Product对象
    Product updateById(String id)throws Exception;

    Integer update(Product product);
}
