package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/14
 * Description:
 * 回调模式 是指-如果一个方法的参数是接口类型,
 * 则在调用该方法时需要创建并传递一个实现此接口类型的对象;
 * 而该方法在运行时会调用到参数对象中所实现的方法(接口中定义的)。
 */

public class $19_AnonymousInterface {

    public static void test($13_Interface i) {
        i.show();
    }

    public static void main(String[] args) {
        $19_AnonymousInterface.test(new $14_InterfaceImpl());

        $19_AnonymousInterface.test(new $13_Interface() {
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        });

/*        $13_Interface i1=new $13_Interface() {
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        };*/
        $13_Interface i1=()-> System.out.println("lamda表达式原来是这么简单");

    }
}