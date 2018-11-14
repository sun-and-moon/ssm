package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    //根据id查询所有userinfo对象
    public UserInfo findById(String id);

    //添加用户
    public Integer save(UserInfo user) throws Exception;


    //查询所有userinfo对象
    public List<UserInfo> findAll();

    List<Role> findUserByIdAndAllRole(String userId)throws Exception;

    void addRoleToUser(String userId, List<String> ids);
}
