package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/14
 * Description: 单例设计模式
 *
 * 在某些特殊场合中,一个类对外提供且只提供一个对象时,这样的类叫做单例类,
 * 而设计单例的流程和思想叫做单例设计模式。
 */

public class $08_Singleton {
    // 声明本类类型的引用指向本类类型的对象,使用private static关键字共同修饰
    private static $08_Singleton sin =new $08_Singleton(); // 饿汉式 更推荐
    private static $08_Singleton sin2 =null; // 懒汉式式
    // 私有化构造方法,使用private关键字修饰
    private $08_Singleton(){};
    // 提供公有的qet方法负责将对象返回出去,使用public static关键字共同修饰
    public static $08_Singleton getInstance(){
        return sin;
    }

    // 懒汉式式
    public static $08_Singleton getInstance2(){
        if (null==sin) {
            sin = new $08_Singleton();
        }
        return sin;
    }

    public static void main(String[] args) {
        $08_Singleton s1 = $08_Singleton.getInstance();
        $08_Singleton s2 = $08_Singleton.getInstance();
        System.out.println(s1==s2); // true
    }
}