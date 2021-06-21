package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/13
 * Description:
 */

public class $02_this {
    String name;

    // 若在构造方法中出现了this关键字,则代表当前正在构造的对象
    // 若在成员方法中出现了this关键字,则代表当前正在调用的对象
    public $02_this() {
        this("调用有参");
        // this 代表当前正在构造的对象
        System.out.println("构造方法中 this: " + this);
    }

    public $02_this(String name) {
//        this(); // 调用无参
        this.name = name;
        System.out.println(name);
    }

    // 成员方法实现所有的特征打印 都隐含着this关键字
    void show(){
        System.out.println("成员方法中 this：" + this);
    }

    public static void main(String[] args) {
        // 声明ThisTest类型的引用指向该类型的对象
        $02_this tt = new $02_this();
        tt.show();
        System.out.println("tt = " + tt);

/*        $02_this t2 = null;
        t2.show();// 空指针异常*/

    }
}