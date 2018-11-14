package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.RoleDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll()throws Exception {

        return roleDao.findAll();
    }

    //为指定id添加角色
    @Override
    public Integer save(Role role) throws Exception {
        return roleDao.save(role);
    }
}
