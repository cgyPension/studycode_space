package com.java.corelibrary01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author GyuanYuan Cai
 * 2021/7/11
 * Description:
 */

public class $17_Map {
    public static void main(String[] args) {
        HashMap<String, String> m1 = new HashMap<>();
        m1.put("1","one");
        m1.put("2","two");
        m1.put("1","eleven");
        System.out.println("m1 = " + m1);


        System.out.println("-------------------------------- 查找 -----------------------------------");

        System.out.println("m1.containsKey(\"11\") = " + m1.containsKey("11"));
        System.out.println("m1.containsKey(\"1\") = " + m1.containsKey("1"));
        System.out.println("m1.containsValue(\"two\") = " + m1.containsValue("two"));

        String s1 = m1.get("5");
        System.out.println("s1 = " + s1);
        System.out.println("m1.get(\"1\") = " + m1.get("1"));

        System.out.println("-------------------------------- 删除 -----------------------------------");
        String re1 = m1.remove("1");
        System.out.println("被删除的value是：" + re1);
        System.out.println("m1 = " + m1);

        System.out.println("-----------------------------------------------------------------------");
        m1.put("1","one");
        m1.put("3","three");

        // 获取Map集合中所有的key 并组成Set视图
        Set<String> keys = m1.keySet();
        // 遍历所有的key
        for (String key : keys) {
            System.out.println("m1.get(key) = " + m1.get(key));
        }

        // 获取Map集合中所有的value 并组成Collection视图
        Collection<String> values = m1.values();
        // 遍历所有的key
        for (String value : values) {
            System.out.println(value);
        }

        System.out.println("-----------------------------------------------------------------------");
        // 获取Map集合中所有的键值对并组成Set视图
        Set<Map.Entry<String, String>> entries = m1.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }
    }

}