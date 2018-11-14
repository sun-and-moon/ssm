package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {
//private String id;
//    private String roleName;
//    private String roleDesc;
//    private List<Permission> permissions;
//    private List<UserInfo> users;
    @Select("select * from role where id in(select roleId from USERS_ROLE where userId = #{userId})")
        @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,
            many = @Many(select = "com.itheima.ssm.dao.PermissionDao.findById"))
//            @Result(column = "id",property = "users");
        })
    public List<Role> findById(String userId) throws Exception;

    //查询所有role
    @Select("select * from role")
    public List<Role> findAll();

    //添加角色
    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public Integer save(Role role) throws Exception;
}
