package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findAll(Integer page, Integer pageSize) throws Exception;

    //为指定id添加角色
    public Integer save(Role role) throws Exception;

    List<Permission> findRoleByIdAndAllPermission(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] ids);

    Role findById(String id);
}
