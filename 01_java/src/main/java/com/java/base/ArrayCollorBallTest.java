package com.java.base;

import java.util.Random;

/**
 * 实现双色球抽奖游戏中奖号码的生成，中奖号码由6个红球号码和1个蓝球号码组成。
 * 其中红球号码要求随机生成6个1~33之间不重复的随机号码。
 * 其中蓝球号码要求随机生成1个1~16之间的随机号码。
 */
public class ArrayCollorBallTest {
	
	public static void main(String[] args) {
		
		// 1.声明一个长度为7元素类型为int类型的一维数组
		int[] arr = new int[7];
		
		// 2.随机生成6个1 ~ 33之间的红色号码放入数组中
		Random ra = new Random();
		for(int i = 0; i < arr.length-1; i++) {
			//int temp = ra.nextInt(33)+1;
			//System.out.println("生成的随机号码是：" + temp);
			arr[i] = ra.nextInt(33)+1;
			// 针对每个随机生成的红色号码来说都要进行去重处理
			for(int j = i-1; j >= 0; j--) {
				if(arr[i] == arr[j]) {
					i--;  // 屏蔽上面的i++，将重复的数据覆盖掉
					break; // 跳出内层循环
				}
			}
		}
		
		// 3.随机生成1个1 ~ 16之间的蓝色号码放入数组中
		arr[arr.length-1] = ra.nextInt(16)+1;
		
		// 4.打印最终的中奖号码
		System.out.print("本期开奖号码为：");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
} 