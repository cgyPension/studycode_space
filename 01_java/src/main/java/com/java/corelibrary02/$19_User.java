package com.java.corelibrary02;

import java.io.Serializable;

/**
 * @author GyuanYuan Cai
 * 2021/7/14
 * Description:
 */

public class $19_User implements Serializable {
    private static final long serialVersionUID = -3890262934563267780L;// 序列化版本号
    private String userName;
    private String passWord;
    private String phoneNum;

    public $19_User() {
    }

    public $19_User(String userName, String passWord, String phoneNum) {
        this.userName = userName;
        this.passWord = passWord;
        this.phoneNum = phoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}