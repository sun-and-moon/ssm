package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.OrdersDao;
import com.itheima.ssm.dao.ProductDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.OrdersService;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    //分页查询所有订单
    @Override
    public List<Orders> findAll(int page,int Size) throws Exception {
        //调用pagehelper中的starpage方法对查询方法进行分页
        PageHelper.startPage(page,Size);
        List<Orders> list = ordersDao.findAll();
//        for (Orders orders : list) {
//            System.out.println(orders);
//        }

        return list;
    }

    //根据id查询订单对象
    @Override
    public Orders findById(String id) throws Exception {
        Orders orders = ordersDao.findById(id);
        return orders;
    }
}
