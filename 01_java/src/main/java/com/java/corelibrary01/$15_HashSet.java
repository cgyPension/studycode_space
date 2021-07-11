package com.java.corelibrary01;

import com.java.corelibrary01.lagou.manageStudent.Student;

import java.util.*;

/**
 * @author GyuanYuan Cai
 * 2021/7/10
 * Description:
 */

public class $15_HashSet {
    public static void main(String[] args) {

        Set<String> s1 = new HashSet<>();
        // HashSet<String> s1 = new LinkedHashSet<>(); // 将放入的元素使用双链表连接起来

        // Set 元素不能重复
        boolean b1 = s1.add("1");
        boolean b2 = s1.add("1");
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("s1 = " + s1);
        /**
         * 15.2.3元素放入HashSet集合的原理使用元素调用hashCode方法获取对应的哈希码值,再由某种哈希算法计算出该元素在数组中的索引位置。
         * 若该位置没有元素,则将该元素直接放入即可。若该位置有元素,则使用新元素与已有元素依次比较哈希值,若哈希值不相同,则将该元素直接放入。
         * 若新元素与已有元素的哈希值相同,则使用新元素调用equals方法与已有元素依次比较。若相等则添加元素失败,否则将元素直接放入即可。思考:为什么要求重写equals方法后要重写hashCode方法呢?
         * 解析:I当两个元素调用equals方法相等时证明这两个元素相同,重写hashCode方法后保证这两个元素得到的哈希码值相同,由同一个哈希算法生成的索引位置相同,
         * 此时只需要与该索引位置已有元素比较即可,从而提高效率并避免重复元素的出现。
         */

        System.out.println("-------------------------------- TreeSet -----------------------------------");

        /**
         * 15.2.5 TreeSet集合的概念二叉树主要指每个节点最多只有两个子节点的树形结构。满足以下3个特征的二叉树叫做有序二叉树。
         * a左子树中的任意节点元素都小于根节点元素值;b.右子树中的任意节点元素都大于根节点元素值;C.左子树和右子树的内部也遵守上述规则;
         * 由于TreeSet集合的底层采用红黑树进行数据的管理,当有新元素插入到TreeSet集合时,需要使用新元素与集合中已有的元素依次比较来确定新元素的合理位置。
         * 比较元素大小的规则有两种方式使用元素的自然排序规则进行比较并排序,让元素类型实现java.lang.Comparable接口使用比较器规则进行比较并排序,
         * 构造TreeSet集合时传入Java.util.Comparator接口;自然排序的规则比较单一,而比较器的规则比较多元化,而且比较器优先于自然排序;
         */
        Set<String> s2 = new TreeSet<>();
        s2.add("aa");
        s2.add("cc");
        s2.add("bb");
        // 由于TreeSet集合的底层采用红黑树实现的 因此元素有大小次序 默认从小到大打印
        System.out.println("s2 = " + s2);

        Set<$16_Student> s3 = new TreeSet<>();
        // 类实现Comparable 自然排序
        s3.add(new $16_Student("zhangsan",12));
        s3.add(new $16_Student("lisi",16));
        s3.add(new $16_Student("jane",18));
        System.out.println("s3 = " + s3);

        // 准备一个比较器对象作为参数传递给构造方法
        // 同时存在时 比较器优先于自然排序
        // 匿名内部类：接口/父类类型 引用变量名= new 接口/父类类型() {方法的重写};
     /*   Comparator<$16_Student> comparator = new Comparator<$16_Student>() {
            @Override
            public int compare($16_Student o1, $16_Student o2) { // o1表示新增加的对象 o2表示集合中已有的对象
                return o1.getAge() - o2.getAge();
            }
        };*/
        // java8 开始支持Lambda表达式：(参数列表)->{方法体}
        Comparator<$16_Student> comparator = ($16_Student o1, $16_Student o2)->{ return o1.getAge() - o2.getAge();};

                Set<$16_Student> s4 = new TreeSet<>(comparator);
        // 类实现Comparable 自然排序
        s4.add(new $16_Student("zhangsan",12));
        s4.add(new $16_Student("lisi",16));
        s4.add(new $16_Student("jane",18));
        System.out.println("s4 = " + s4);
    }

}