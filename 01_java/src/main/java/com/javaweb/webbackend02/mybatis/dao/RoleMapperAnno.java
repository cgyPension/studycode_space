package com.javaweb.webbackend02.mybatis.dao;

import com.javaweb.webbackend02.mybatis.bean.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapperAnno {
    // 根据用户id查询对应角色
    @Select("SELECT * FROM test.sys_role r INNER JOIN test.sys_user_role ur oN ur.roleid =r.id where ur.userid=#{uid}")
    public List<Role> selectUid(Integer uid);

}
