package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/15
 * Description:
 */

public enum $21_DirectionInterfaceEnum implements $13_Interface{

    // 2.声明本类类型的引用指向本类类型的对象
    UP("上"){
        @Override
        public void show() {

        }
    },DOWN("下"){
        @Override
        public void show() {

        }
    },LEFT("左"){
        @Override
        public void show() {

        }
    },RIGHT("右"){
        @Override
        public void show() {

        }
    };

    private final String desc;//用于描述方向字符串的成员变量

    // 通过构造方法实现成员变量的初始化，更加灵活
    // 1.私有化构造方法，此时该构造方法只能在本类的内部使用
    private $21_DirectionInterfaceEnum(String desc) {
        this.desc = desc;
    }

    // 通过公有的qet方法可以在本类的外部访问该类成员变量的数值
    public String getDesc() {
        return desc;
    }


}