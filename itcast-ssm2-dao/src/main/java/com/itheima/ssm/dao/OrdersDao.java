package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {

    //查询orders表将数据存入list集合
    @Select("select * from orders")
    @Results({
        @Result(id = true,column = "id",property = "id"),
        @Result(column = "orderNum",property = "orderNum"),
        @Result(column = "orderTime",property = "orderTime"),
        @Result(column = "peopleCount",property = "peopleCount"),
        @Result(column = "orderDesc",property = "orderDesc"),
        @Result(column = "payType",property = "payType"),
        @Result(column = "orderStatus",property = "orderStatus"),
        @Result(column = "productid",property = "product",javaType = Product.class,
                one = @One(select = "com.itheima.ssm.dao.ProductDao.findById"))})
    public List<Orders> findAll();

    //根据id查询orders对象，通过多表联查将member，product，List<Traveller>存入该对象
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "memberid",property = "member",javaType = Member.class,
                    one = @One(select = "com.itheima.ssm.dao.MemberDao.findById")),
            @Result(column = "productid",property = "product",javaType = Product.class,
                    one = @One(select = "com.itheima.ssm.dao.ProductDao.findById")),
            @Result(column = "id",property = "travellers",javaType = java.util.List.class,
                    many = @Many(select = "com.itheima.ssm.dao.travellerDao.findById"))
    })
    public Orders findById(String id) throws Exception;

    @Delete("delete from orders where id = #{id}")
    void deleteById(String id);

    //根据orderNum片段模糊查询orders
    @Select("select * from orders where OrderNum like concat(concat('%',#{orderNum}),'%')")
    @Results({
        @Result(id = true,column = "id",property = "id"),
        @Result(column = "orderNum",property = "orderNum"),
        @Result(column = "orderTime",property = "orderTime"),
        @Result(column = "peopleCount",property = "peopleCount"),
        @Result(column = "orderDesc",property = "orderDesc"),
        @Result(column = "payType",property = "payType"),
        @Result(column = "orderStatus",property = "orderStatus"),
        @Result(column = "memberid",property = "member",javaType = Member.class,
                one = @One(select = "com.itheima.ssm.dao.MemberDao.findById")),
        @Result(column = "productid",property = "product",javaType = Product.class,
                one = @One(select = "com.itheima.ssm.dao.ProductDao.findById")),
        @Result(column = "id",property = "travellers",javaType = java.util.List.class,
                many = @Many(select = "com.itheima.ssm.dao.travellerDao.findById"))
    })
    Orders findByLikeOrderNum(String orderNum);
}
