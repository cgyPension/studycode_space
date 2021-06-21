package com.java.corelibrary01.lagou.poker;

import java.util.*;

/**
 * 编程使用集合实现斗地主游戏的部分功能
 */
public class PokerTest {

    /**
     * 自定义静态方法实现扑克牌的打印功能
     * @param i
     * @param list
     * @param pokerMap
     */
    public static void showPoker(int i, List<Integer> list, Map<Integer, String> pokerMap) {
        if (i <= 3) {
            System.out.print("第" + i + "个玩家的扑克牌有：");
        } else {
            System.out.print("底牌有：");
        }
        for (Integer integer : list) {
            System.out.print(pokerMap.get(integer) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // 1.准备List集合来存放4种花色和13种点数
        List<String> colorList = Arrays.asList("♠", "♥", "♣", "♦");
        List<String> pointList = Arrays.asList("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

        // 2.准备Map集合来存放生成的54张扑克牌，指定扑克牌的编号作为key，使用扑克牌作为value，从而实现对应关系的建立
        // 建立关系的目的是为了后续便于打乱后还能从大到小进行排序，需要单独记录所有编号
        Map<Integer, String> pokerMap = new HashMap<>();
        List<Integer> numberList = new ArrayList<>();
        // 2.1 单独存放大小王并指定编号
        int cnt = 0;
        numberList.add(cnt);
        pokerMap.put(cnt++, "大王");
        numberList.add(cnt);
        pokerMap.put(cnt++, "小王");
        // 2.2 存放花色和点数组合出来的52张扑克牌
        for (String point : pointList) {
            for (String color : colorList) {
                numberList.add(cnt);
                pokerMap.put(cnt++, color+point);
            }
        }

        // 3.打印生成的扑克牌并进行洗牌后再次打印
        // System.out.println(pokerMap);
        // System.out.println("扑克牌的数量是：" + pokerMap.size());
        // System.out.println("洗牌之前的扑克牌编号是：" + numberList);
        // 洗牌操作
        Collections.shuffle(numberList);
        // System.out.println("洗牌之后的扑克牌编号是：" + numberList);

        // 4.准备4个集合来记录3个玩家的扑克牌和底牌，当然使用上述洗牌之后的编号进行发牌
        List<Integer> player1 = new ArrayList<>();
        List<Integer> player2 = new ArrayList<>();
        List<Integer> player3 = new ArrayList<>();
        List<Integer> remains = new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {
            Integer integer = numberList.get(i);
            if (i >= 51) {
                remains.add(integer);
            } else if (0 == i%3) {
                player1.add(integer);
            } else if (1 == i%3) {
                player2.add(integer);
            } else {
                player3.add(integer);
            }
        }

        // 5.根据扑克牌的编号实现从大到小的排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(remains);

        // 6.再根据Map集合中的对应关系打印所有玩家的扑克牌和底牌
        showPoker(1, player1, pokerMap);
        showPoker(2, player2, pokerMap);
        showPoker(3, player3, pokerMap);
        showPoker(4, remains, pokerMap);
    }
}
