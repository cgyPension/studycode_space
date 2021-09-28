package com.javaweb.webbackend02.dao;

import com.javaweb.webbackend02.bean.Role;

import java.util.List;

public interface RoleMapper {
    // 根据用户id查询对应角色
    public List<Role> selectUid(Integer uid);

}
