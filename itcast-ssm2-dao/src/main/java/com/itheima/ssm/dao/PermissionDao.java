package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    //根据roleId查询权限
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findById(String id);

    //查询所有
    @Select("select * from permission")
    public List<Permission> findAll() throws Exception;

    @Insert("insert into permission (permissionName,url) values(#{permissionName},#{url})")
    public Integer save(Permission permission);
}
