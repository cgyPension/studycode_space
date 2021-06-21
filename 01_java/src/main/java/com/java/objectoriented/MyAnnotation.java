package com.java.objectoriented;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 自定义注解
//若一个注解中没有任何的成员，则这样的注解叫做标记注解/标识注解
// 元注解是可以注解到注解上的注解,或者说元注解是一种基本注解,但是它能够应用到其它的注解上面。
// 元注解主要有@Retention,@Documented, @Targt @Inherited @Repeatable.
@Retention(RetentionPolicy.SOURCE) // 表示下面注解在源代码中有效
@Documented //表示下面的注解信息可以被javadoc工具提取到API文档中
// @Target用于指定被修饰的注解能用于哪些元素的修饰,取值如下
// @Inherited并不是说注解本身可以继承,而是说如果一个超类被该注解标记过的注解进行注解时,如果子类没有被任何注解应用时,则子类就继承超类的注解。
// @Repeatable表示自然可重复的含义,从Java8开始增加的新特性。
public @interface MyAnnotation {
    /*
    注解的使用方式
    注解体中只有成员变量没有成员方法,而注解的成员变量以"无形参的方法"形式来声明,
    其方法名定义了该成员变量的名字,其返回值定义了该成员变量的类型。
    如果注解只有一个参数成员,建议使用参数名为value ,
    而类型只能是八种基本数据类型、String类型、Class类型、enum类型及Annotation类型。
     */
    public String value(); //声明一个string类型的成员变量，名字为value

    public String value2() default "123"; // 设置默认值

    // 预制注解就是Java语言自身提供的注解@return 等 @Deprecated 表示方法已经过时 不建议使用
}
