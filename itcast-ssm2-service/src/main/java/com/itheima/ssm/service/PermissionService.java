package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {

    public List<Permission> findAll() throws Exception;

    public Integer save(Permission permission);
}
