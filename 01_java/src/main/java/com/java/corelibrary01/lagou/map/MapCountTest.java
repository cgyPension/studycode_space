package com.java.corelibrary01.lagou.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 准备一个HashMap集合，统计字符串"123,456,789,123,456"中每个数字字符串出现的次数并打印出来
 */
public class MapCountTest {

	public static void main(String[] args) {
		
		// 1.准备一个Map集合
		Map<String, Integer> map = new HashMap<>();
		
		// 2.构造String类型的对象并初始化
		String str = "123,456,789,123,456";
		
		// 3.切割字符串并将出现的字符串和对应的次数记录到集合中
		String[] strings = str.split(",");
		for(String ts : strings) {
			if(map.containsKey(ts)) {
				map.put(ts, map.get(ts)+1);
			} else {
				map.put(ts, 1);
			}
		}
		
		// 4.打印最终的统计结果
		Set<Map.Entry<String,Integer>> set = map.entrySet();
		for(Map.Entry<String,Integer> me : set) {
			System.out.println(me.getKey() + "出现了" + me.getValue() + "次！");
		}
	}

}
