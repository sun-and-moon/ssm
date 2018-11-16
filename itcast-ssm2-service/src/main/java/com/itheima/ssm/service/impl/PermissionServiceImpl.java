package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.PermissionDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll(Integer page, Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return permissionDao.findAll();
    }

    @Override
    public Integer save(Permission permission) {
        return permissionDao.save(permission);
    }
}
