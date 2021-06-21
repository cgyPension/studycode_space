package com.java.objectoriented;

/**
 * @author GyuanYuan Cai
 * 2021/6/14
 * Description:
 */

public class $12_AbstractTwo extends $11_Abstract{
    @Override
    public void sss() {
        System.out.println("s");
    }

    /*
    在以后的开发中推荐使用多态的格式,此时父类类型引用直接调用的所有方法一定是父类中拥有的方法,
    若以后更换子时,只需要将new关键字后面的子类类型修改而其它地方无需改变就可以立即生效,
    从而提高了代码的可维护性和可扩展型。该方式的缺点就是:父类引用不能直接调用子类独有的方法,若调用则需要强制型转换。
     */
}