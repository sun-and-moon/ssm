package com.itheima.ssm.service;

import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    //添加用户
    public Integer save(UserInfo user) throws Exception;


    //查询所有userinfo对象
    public List<UserInfo> findAll();

}
