package com.itheima.ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.ProductDao;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Integer saveProduct(Product product) throws Exception{
        //调用dao层储存方法
        Integer i = productDao.saveProduct(product);
        return i;
    }

    public List<Product> findAll(Integer page, Integer pageZise) throws Exception {
        PageHelper.startPage(page,pageZise);
        List<Product> list = productDao.findAll();
        return list;
    }

    @Override
    public void deleteByIds(String[] ids) {
        for (String id : ids) {
        productDao.deleteByIds(id);
        }
    }

    //根据id查询Product对象
    @Override
    public Product updateById(String id)throws Exception {
        Product product = productDao.updateById(id);
        return product;
    }

    @Override
    public Integer update(Product product) {
        Integer i = productDao.update(product);
        return i;
    }
}

