package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {


    //根据id查询用户
    @Select("select * from Users where id=#{id}")
        @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = java.util.List.class,
            many = @Many(select = "com.itheima.ssm.dao.RoleDao.findById"))
        })
    public UserInfo findById(String id);

    //添加用户
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
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

    //通过用户id查收所有不关联的角色
    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    public List<Role> findUserByIdAndAllRole(String userId);

    //将用户id和角色id产生管理（添加到关联表）
    @Insert("insert into users_role values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId")String roleId);
}
