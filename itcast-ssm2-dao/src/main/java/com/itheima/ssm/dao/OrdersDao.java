package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersDao {


    @Select("select * from orders")
    @Results({
        @Result(id = true,column = "id",property = "id"),
        @Result(column = "orderNum",property = "orderNum"),
        @Result(column = "orderTime",property = "orderTime"),
        @Result(column = "peopleCount",property = "peopleCount"),
        @Result(column = "orderDesc",property = "orderDesc"),
        @Result(column = "payType",property = "payType"),
        @Result(column = "orderStatus",property = "orderStatus"),
//        @Result(column = "memberid",property = "memberid"),
        @Result(column = "productid",property = "product",javaType = Product.class,
                one = @One(select = "com.itheima.ssm.dao.ProductDao.findById"))
    })
    public List<Orders> findAll();
}
