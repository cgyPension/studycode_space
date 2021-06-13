package com.java.base;

/**
 * @author GyuanYuan Cai
 * 2021/6/9
 * Description:
 */

public class $07_Array01 {
    public static void main(String[] args) {

        // 一维数组本质上就是在内存空间中申请一段连续的存储单元。数组是相同数据类型的多个元素的容器,元素按线性顺序排列,在Java语言中体现为一种引用数据类型。
        // 数组内存空间中放的数据是在堆中的内存地址信息
        // 数组下标-主要指数组元素在数组中的编号,从0开始可以取到长度-1
        // 数组优点：可以通过下标（索引）的方式访问指定位置的元素 速度很快
        // 数组缺点：数组要求所有元素的类型相同 数组要求内存空间连续 并且长度一旦确定就不能修改 增加和删除元素时可能移动大量元素，效率低
        int[] arr1=new int[2];

        System.out.println("a数据的长度是： " + arr1.length);
        System.out.println("下标为0的元素是： " + arr1[0]);
        System.out.println("下标为1的元素是： " + arr1[1]);
//        System.out.println("下标为2的元素是： " + arr1[2]);  //数组下标越界

        // 遍历数组
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("下标为" +i+"的元素是："+ arr1);
        }
        for (int i : arr1) {
            System.out.println(i);
        }

        // 声明数组的时候初始化 静态方式
        char[] arr2={'a','b','c','d'};

        System.out.println("--------------------------------------------------------------------");
        int[] arr3={11,22,33,44};
        // 将55 插入到下标为0的位置
        for (int i = arr3.length-1; i >0; i--) {
           arr3[i]=arr3[i-1];
        }
        arr3[0]=55;
        for (int i : arr3) {
            System.out.println("i = " + i);
        }
        System.out.println("--------------------------------------------------------------------");
        // 将数据55从数组中删除,删除方式为后续元素向前移动,最后一个位置置为0
        for (int i = 0; i < arr3.length; i++) {
            arr3[i]=arr3[i+1];
        }
        arr3[4]=0;

        System.out.println("--------------------------------------------------------------------");
        // 查找数组中是否有元素22 若有则修改为220
        for (int i = 0; i < arr3.length; i++) {
            if (22 == arr3[i])arr3[i]=220;
        }



    }

}