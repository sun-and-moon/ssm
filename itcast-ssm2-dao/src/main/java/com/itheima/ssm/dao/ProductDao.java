package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductDao {


    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public int saveProduct(Product product) throws Exception;

    @Select("select * from product")
    public List<Product> findAll();

    //根据id查询产品
    @Select("select * from product where id = #{id}")
    public Product findById(String id) throws Exception;


    @Delete("delete from product where id = #{id}")
    void deleteByIds(String id);

    //根据id查询Product对象
    @Select("select * from product where id = #{id}")
    Product updateById(String id) throws Exception;

    @Update("update PRODUCT set productNum = #{productNum},productName = #{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productNum} where id = #{id}")
    Integer update(Product product);
}
