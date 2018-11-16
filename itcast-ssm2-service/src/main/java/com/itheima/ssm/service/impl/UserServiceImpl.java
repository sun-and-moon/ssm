package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.UserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.UserService;
import com.itheima.ssm.utils.BCryptPasswordEncoderUtils;
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

        User user = null;

        try {
            UserInfo userInfo = userDao.findByUserName(username);
            user = new User(userInfo.getUsername(), userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,getauthorities(userInfo.getRoles()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    private List<SimpleGrantedAuthority> getauthorities(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
        list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }


    //根据id查询所有userinfo对象
    @Override
    public UserInfo findById(String id) {
        UserInfo userInfo = userDao.findById(id);
        return userInfo;
    }

    //添加用户
    @Override
    public Integer save(UserInfo user) throws Exception {
        user.setPassword(BCryptPasswordEncoderUtils.encoderPassword(user.getPassword()));
        Integer i = userDao.save(user);
        return i;
    }

    //查询所有userinfo对象
    @Override
    public List<UserInfo> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<UserInfo> users = userDao.findAll();
        return users;
    }

    //通过用户id查收所有不关联的角色
    @Override
    public List<Role> findUserByIdAndAllRole(String userId) throws Exception {
        return userDao.findUserByIdAndAllRole(userId);
    }

    //将用户id和角色id产生管理
    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String roleId : ids) {
//            System.out.println(userId+"------------"+roleId);
            userDao.addRoleToUser(userId,roleId);
        }

    }
}
