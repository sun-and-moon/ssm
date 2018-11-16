package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {

    public List<Permission> findAll(Integer page, Integer pageSize) throws Exception;

    public Integer save(Permission permission);
}
