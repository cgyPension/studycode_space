package com.java.objectoriented;

// 支持多实现 接口能继承接口
public interface $13_Interface {
    int CNT=1;
    public abstract void show();// 里面只能有抽象方法

    public default void showDefault(){
        System.out.println("接口中的默认方法，实现类中可以自由选择是否重写");
    }
}
