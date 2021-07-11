package com.java.corelibrary01;

import java.util.LinkedList;

/**
 * @author GyuanYuan Cai
 * 2021/7/10
 * Description:
 */

public class $14_GenericTest {
    public static void main(String[] args) {
        // 泛型的继承 类型只见不具备父子类关系
       // 如果B是A的一个子类或子接口,而G是具有泛型声明的类或接口,则G<B>并不是G<A的子类型!比如: String是Object的子类,但是List<string>并不是List<object>的子类。
        // LinkedList<Animal> lt1 = new LinkedList<>();
        // LinkedList<Dog> lt2 = new LinkedList<>();
        // 试图将lt2的数值赋值给lt1 也就是发生List<Dog>类型向List<Animal>类型的转换
        // lt1 = lt2; 类型只见不具备父子类关系

        System.out.println("-------------------------------------------------------------------");

        // 有时候我们希望传入的类型在一个指定的范围内,此时就可以使用泛型通配符了。如：之前传入的类型要求为Integer类型，但是后来业务需要nteger的父类Number类也可以传入。
        // 泛中有三种通配符形式:
        // <?> 无限制通配符：表示我们可以传入任意类型的参数。
        // <? extends E>表示类型的上界是E,只能是E或者是E的子类。
        // <? super E>表示类型的下界是E,只能是E或者是E的父类。
        // LinkedList<?> lt3 = new LinkedList<>();
        // lt3=lt1; // 可以发生List<Animal>类型到List<?>类型的转换
        // lt3=lt2; // 可以发生List<Dog>类型到List<?>类型的转换

        // 向公共父类中添加元素 获取元素
        // lt3.add(new Animal()) Error 不能存放Animal类型的对象
        // Object o = lt3.get(0) 支持获取

        System.out.println("-------------------------------------------------------------------");

        //3．使用有限制的通配符进行使用
        // List<? extends Animal> 1t4 = new LinkedList<>();
        // 不支持元素的添加操作
        // Lt4. add (new Animal());
        // Lt4.add(new Dog());
        // t4. add (new object());
        // Animal animal = 1t4.get(e);

        // List<? super Animal> 1t5 = new LinkedList<>();
        // 1t5. add(new Animal());1t DDeclare final Dog());//n arrew object()); Error:超过了Animal类型的范围object object = 1t5.get(e);-");
    }

}