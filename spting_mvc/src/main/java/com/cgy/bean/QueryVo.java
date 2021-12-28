package com.cgy.bean;

import lombok.Data;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

/**
 * @author GyuanYuan Cai
 * 2021/10/5
 * Description:
 */
@Data
public class QueryVo {
    private String keyword;
    private User user;
    private List<User> userList;
    private Map<String, User> userMap;

}