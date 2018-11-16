package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.RoleDao;
import com.itheima.ssm.domain.Permission;
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
    public List<Role> findAll(Integer page, Integer pageSize)throws Exception {
        PageHelper.startPage(page,pageSize);
        return roleDao.findAll();
    }

    //为指定id添加角色
    @Override
    public Integer save(Role role) throws Exception {
        return roleDao.save(role);
    }

    // 角色关联权限-通过角色id查询无关联权限并返回
    @Override
    public List<Permission> findRoleByIdAndAllPermission(String roleId) throws Exception {
        List<Permission> permissions = roleDao.findRoleByIdAndAllPermission(roleId);
        return permissions;
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        for (String PermissionId : ids) {
        roleDao.addPermissionToRole(roleId,PermissionId);
        }
    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findByRoleId(roleId);
    }
}
