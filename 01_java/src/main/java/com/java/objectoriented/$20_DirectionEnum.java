package com.java.objectoriented;

// 编程实现所有方向的枚举，所有的方向:向上、向下、向左、向右
// 枚举类型要求所有枚举值必须放在枚举类型的最前面
public enum $20_DirectionEnum{
    // 2.声明本类类型的引用指向本类类型的对象
    UP("上"),DOWN("下"),LEFT("左"),RIGHT("右");

    private final String desc;//用于描述方向字符串的成员变量

    // 通过构造方法实现成员变量的初始化，更加灵活
    // 1.私有化构造方法，此时该构造方法只能在本类的内部使用
    private $20_DirectionEnum(String desc) {
        this.desc = desc;
    }

    // 通过公有的qet方法可以在本类的外部访问该类成员变量的数值
    public String getDesc() {
        return desc;
    }

    /*
    static T[] values()返回当前枚举类中的所有对象
    String toString()返回当前枚举类对象的名称
    int ordinal()获取枚举对象在枚举类中的索引位置
    tatic T valueOf(String str) 将参数指定的字符串名转为当前枚举类的对象
    int compareTo(E o) 比较两个枚举对象在定义时的顺序
     */
    public static void main(String[] args) {
        $20_DirectionEnum d1 = $20_DirectionEnum.UP;
        System.out.println("d1 = " + d1.getDesc());
    }
}
