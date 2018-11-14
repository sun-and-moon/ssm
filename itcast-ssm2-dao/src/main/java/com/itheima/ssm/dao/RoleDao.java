package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {

    @Select("select * from role where id in(select roleId from USERS_ROLE where userId = #{userId})")
    public List<Role> findById(String userId) throws Exception;
}
