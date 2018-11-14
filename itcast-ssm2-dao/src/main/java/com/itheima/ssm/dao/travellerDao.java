package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface travellerDao {

    //根据orderid查询中间表得到travellerid，在用子表查询法，查询traveller表并将结果存入list集合
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderid = #{id})")
    public List<Traveller> findById(String id) throws Exception;
}
