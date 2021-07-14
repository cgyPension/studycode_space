package com.java.corelibrary02;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/7/13
 * Description:
 */

public class $09_File {
    // 自定义成员方法实现指定目录以及子目录中所有内容的打印
    public static void show(File tf){
        File[] filesArray = tf.listFiles();
        // 遍历数组
        for (File file : filesArray) {
            String name = file.getName();
            // 判断是否为文件，若是则直接打印文件名称
            if (file.isFile()) {
                System.out.println(name);
            } else if (file.isDirectory()) { // 若是目录 则使用[] 将目录名称括号起来
                System.out.println("[" + name + "]");
                show(file); // 递归
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 构造File类型的对象 d:/a.txt 文件关联
        File f1 = new File("d:/a.txt");
        if (f1.exists()) { // 若文件存在则执行相关操作
            System.out.println("文件的名称是：" + f1.getName());
            System.out.println("文件的大小是：" + f1.length());
            System.out.println("文件的最后一次修改时间：" + f1.lastModified());
            // 绝对路径 相对路径
            System.out.println("文件的绝对路径信息：" + f1.getAbsolutePath());
            System.out.println(f1.delete() ? "文件删除成功" : "文件删除失败");
        } else {
            // 若文件不存在则创建新的空文件
            System.out.println(f1.createNewFile() ? "文件创建成功" : "文件创建失败");
        }

        System.out.println("---------------------------------------------------------");
        // 实现目录的删除和创建
        File f2 = new File("d:/文件夹1/文件夹2");
        if (f2.exists()) {
            System.out.println("目录名称是：" + f1.getName());
            System.out.println(f2.delete() ? "目录删除成功" : "目录删除失败"); // 只能删除空目录
        } else {
            // 若文件不存在则创建新的空文件
            // System.out.println(f2.mkdir() ? "目录创建成功" : "目录创建失败");
            System.out.println(f2.mkdirs() ? "目录创建成功" : "目录创建失败");
        }

        System.out.println("---------------------------------------------------------");
        // 实现目录中的多有内容打印出来
        File f3 = new File("d:/文件夹1");
        File[] filesArray = f3.listFiles();
        // 遍历数组
        for (File file : filesArray) {
            String name = file.getName();
            // 判断是否为文件，若是则直接打印文件名称
            if (file.isFile()) {
                System.out.println(name);
            } else if (file.isDirectory()) { // 若是目录 则使用[] 将目录名称括号起来
                System.out.println("[" + name + "]");
            }
        }


        System.out.println("---------------------------------------------------------");
        // 实现目录中所有内容获取的同时进行过滤
        // 匿名内部类的语法格式： 接口/父类类型 引用变量名 = new 接口/父类类型(){方法体}
/*        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // 若是文件名是.avi为结尾 则返回true表示保留 否则返回false就是表示丢弃
                return pathname.getName().endsWith(".avi");
            }
        };*/
        // Lambda表达式: (参数列表)->{方法体}
        FileFilter fileFilter = (File pathname)->{ return pathname.getName().endsWith(".avi");};
        File[] filesArray2 = f3.listFiles(fileFilter);
        for (File file : filesArray2) {
            System.out.println(file);
        }

        System.out.println("---------------------------------------------------------");
        // 使用递归的思想获取目录以及子目录中的内容
        show(new File("d:/文件1"));

    }

}