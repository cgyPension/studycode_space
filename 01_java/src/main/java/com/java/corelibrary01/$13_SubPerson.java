package com.java.corelibrary01;

/**
 * @author GyuanYuan Cai
 * 2021/7/10
 * Description:
 */

//public class $13_SubPerson extends $11_Person{ // 不保留泛型没有指定类型 此时Person类中的T默认为Object类型 擦除
//public class $13_SubPerson extends $11_Person<String>{ // 不保留泛型指定了泛型类型 此时Person类中的T被指定为String
//public class $13_SubPerson<T> extends $11_Person<T>{ // 保留父类泛型
public class $13_SubPerson<T,T1> extends $11_Person<T>{ // 保留父类泛型,同时在子类中增加新的泛型

}