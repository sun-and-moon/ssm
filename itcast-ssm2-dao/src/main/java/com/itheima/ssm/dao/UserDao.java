package com.itheima.ssm.dao;

import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {


    //添加用户
    @Insert("insert into user(email,username,password,phoneNum,status) value(#{email},#{username},#{password},#{phoneNum},#{status})")
    public Integer save(UserInfo user) throws Exception;

    //查询所有的user对象
    @Select("select * from Users")
    public List<UserInfo> findAll();


    //查询对应姓名的 user对象
    @Select("select * from Users where username=#{username}")
        @Results({
            @Result(id = true, column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
                //根据用户id查询角色
            @Result(column = "id",property = "roles",javaType = java.util.List.class,
                    many = @Many(select = "com.itheima.ssm.dao.RoleDao.findById"))
        })
    public UserInfo findByUserName(String username) throws Exception;
}
