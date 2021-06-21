package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/14
 * Description: java中只支持单继承 但一个父类可以有多个子类
 */

public class $09_teacher extends $01_Person{
    private int salary;

    //无论使用何种方式构造子类的对象时都会自动调用父类的无参构造方法
    // 来初始化从父类中继承的成员变量,相当于在构造方法的第一行增加代码super(的效果。
    public $09_teacher() {
    }

    public $09_teacher(String name, int age, int salary) {
        super(name, age);// 调用父类的有参构造方法
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    /*
    要求方法名相同、参数列表相同以及返回值类型相同,从Java5开始允许返回子类类型。
    要求方法的访问权限不能变小,可以相同或者变大。要求方法不能抛出更大的异常(异常机制)。
     */
    @Override // 重写父类方法
    void show() {
        System.out.println("name = " + name + ", age = " + age+", salary = " + salary);
    }

    // 子类不能继承父类的构造方法和私有方法,但私有成员变量可以被继承只是不能直接访问
    public static void main(String[] args) {
        $09_teacher t1 = new $09_teacher();
        t1.setName("老师");
        t1.setAge(12);
        t1.show();

        // 多态
        $01_Person t2 = new $09_teacher();
        // 当teacher类没有show方法时候 会调用person的show方法
        // 当teacher类中重写show方法后,编译阶段调用person类的方法,运行阶段调用teacher类中的show方法
        // 当父类类型的引用指向子类类型的对象时,父类类型的引用不可以直接调用子类独有的方法。

        // 强转若不是父子关系会报错
        if (t2 instanceof $01_Person) {
            System.out.println("父子关系");
        } else {
            System.out.println("非父子关系");
        }

        t2.show();
    }
}