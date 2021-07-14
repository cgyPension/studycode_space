package com.java.corelibrary02;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/7/13
 * Description:
 */

public class $05_SubExceptionMethod extends $04_ExceptionMethod{
    @Override
    // public void show() throws IOException {} // 子类重写的方法可以抛出和父类中方法一样的异常
    // public void show() throws FileNotFoundException {} // 子类可以抛出更小的异常
    public void show() {} // 子类可以不抛出异常
    // public void show() throws ClassNotFoundException{} // 子类可以不抛出平级 或者更大的异常


}