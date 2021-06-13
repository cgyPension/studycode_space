package com.java.base;

/**
 * @author GyuanYuan Cai
 * 2021/6/5
 * Description:
 */

public class $05_Branch {
    public static void main(String[] args) {

        // if
        // if else
        // if else if else
        int score = 100;
        if (score >= 90 && score <= 100) {
            System.out.println("等级A");
        } else if (score >= 80) {
            System.out.println("等级B");
        } else if (score >= 70) {
            System.out.println("等级C");
        } else if (score >= 60) {
            System.out.println("等级D");
        } else {
            System.out.println("等级E");
        }


        switch (score / 10) {
            case 10:// case 穿透
//                System.out.println("等级A");
//                break;
            case 9:
                System.out.println("等级A");
                break;
            case 8:
                System.out.println("等级B");
                break;
            case 7:
                System.out.println("等级C");
                break;
            case 6:
                System.out.println("等级D");
                break;
            default:
                System.out.println("等级E");// break

        }

    }
}