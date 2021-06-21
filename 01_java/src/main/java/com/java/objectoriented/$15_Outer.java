package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/14
 * Description:
 * 当一个类的定义出现在另外一个类的类体中时,那么这个类叫做内部类(Inner) ,
 * 而这个内部类所在的类叫做外部类(Outer)
 */


/*
,当一个类存在的价值仅仅是为某一个类单独服务时,那么就可以将这个类定义为所服务类中的内部类,
这样可以隐藏该类的实现细节并且可以方便的访问外部类的私有成员而不再需要提供公有的get和set方法。
 */
public class $15_Outer {

    // 外部类成员
    private int cnt = 1;

    // 内部类
    public class Inner {
        private int a=2;

        public Inner() {
        }
        public void show(){
            System.out.println("内部类方法 打印外部类私有属性："+cnt);
            System.out.println("a = " + a);
        }
    }
}