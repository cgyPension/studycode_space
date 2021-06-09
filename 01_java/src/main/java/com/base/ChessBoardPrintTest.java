package com.base;

/**
 * 使用二维数组和循环实现五子棋游戏棋盘的绘制
 */

public class ChessBoardPrintTest {

    public static void main(String[] args) {

        // 1.自定义二维数组来描述棋盘，默认初始值为0
        int[][] chessBoard = new int[16][16];

        // 2.使用双重for循环和数组来实现棋盘的绘制
        // 2.1 先绘制棋盘中第一行的坐标信息，也就是列坐标信息
        for (int i = 0; i < 17; i++) {
            if (0 == i) {
                System.out.print("  ");
            } else {
                // 按照十六进制的格式打印i-1的数值
                System.out.printf("%x ", i - 1);
            }
        }
        System.out.println();

        // 2.2 绘制棋盘中除了第一行之外的其它部分以及行坐标信息
        for (int i = 0; i < 16; i++) {
            // 用于打印行坐标信息
            System.out.printf("%x ", i);
            for (int j = 0; j < 16; j++) {
                // 刚开始棋盘中的所有内容都是+，因此直接打印，但是为了完成后续功能这里需要借助二维数组（先留个悬念哦！）
                System.out.print("+ ");
            }
            // 打印完毕一行的所有内容之后进行换行
            System.out.println();
        }
    }
}
