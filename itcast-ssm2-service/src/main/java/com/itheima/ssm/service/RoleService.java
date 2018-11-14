package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findAll() throws Exception;

    //为指定id添加角色
    public Integer save(Role role) throws Exception;
}
