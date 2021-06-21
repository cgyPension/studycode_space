package com.java.corelibrary01.lagou.string;

/**
 * 编程统计字符串"ABCD123!@#$%ab"中大写字母、小写字母、数字、其它字符的个数并打印出来
 */
public class CountStringTest {

	public static void main(String[] args) {
		
		// 1.构造String类型的对象并初始化
		String str1 = new String("ABCD123!@#$%ab");

		// 2.准备一个长度为4元素类型为int类型的一维数组
		int[] arr = new int[4];
		
		// 3.拆分字符串中的每个字符并进行判断和统计
		for(int i = 0; i < str1.length(); i++) {
			char cv = str1.charAt(i);
			// 若是大写字母，则将数组中下标为0的元素加1
			if(cv >= 'A' && cv <= 'Z') {
				arr[0]++;
			}
			// 若是小写字母，则将数组中下标为1的元素加1
			else if(cv >= 'a' && cv <= 'z') {
				arr[1]++;
			}
			// 若是数字字符，则将数组中下标为2的元素加1
			else if(cv >= '0' && cv <= '9') {
				arr[2]++;
			}
			// 若是其它字符，则将数组中下标为3的元素加1
			else {
				arr[3]++;
			}
		}
		
		// 4.打印最终的统计结果 4  2  3  5
		System.out.println("其中大写字母出现了" + arr[0] 
			+ "次，其中小写字母出现了" + arr[1] + "次，"
			+ "其中数字字符出现了" + arr[2] + "次，"
			+ "其它字符出现了" + arr[3] + "次！"); 
	}

}
