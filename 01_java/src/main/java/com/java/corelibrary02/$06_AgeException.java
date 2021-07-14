package com.java.corelibrary02;

/**
 * @author GyuanYuan Cai
 * 2021/7/13
 * Description:
 */

public class $06_AgeException extends Exception{
    static final long serialVersionUID = 7818375828146090155L; // 序列化的版本号 与序列化的操作有关

    public $06_AgeException() {
    }

    public $06_AgeException(String message) {
        super(message);
    }
}