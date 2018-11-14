package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.UserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("--------"+username);
        User user = null;
        try {
            UserInfo userInfo = userDao.findByUserName(username);
            System.out.println("--------"+userInfo);
            System.out.println("--------"+userInfo.getRoles());
            user = new User(userInfo.getUsername(), "{noop}"+userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,getauthorities(userInfo.getRoles()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    private List<SimpleGrantedAuthority> getauthorities(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
        list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
            System.out.println("--------"+role);
        }
        return list;
    }

    //添加用户
    @Override
    public Integer save(UserInfo user) throws Exception {
        Integer i = userDao.save(user);
        return i;
    }

    //查询所有userinfo对象
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> users = userDao.findAll();
        return users;
    }
}
