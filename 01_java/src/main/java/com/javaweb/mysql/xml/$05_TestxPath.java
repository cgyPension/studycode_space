package com.javaweb.mysql.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/7/18
 * Description:
 */

public class $05_TestxPath {
    public static void main(String[] args) throws DocumentException {
        //1.获取XML解析对象
        SAXReader reader = new SAXReader();

        //2.解析XML获取文档对象document
        Document document = reader.read("D:\\code\\studycode_space\\01_java\\src\\main\\java\\com\\javaweb\\mysql\\xml\\$02_student.xml");

        // 通过selectsingleNode() 方法获取name节点
        Node node1 = document.selectSingleNode("/students/student/name");
        System.out.println("节点的名称：" + node1.getName());
        System.out.println("第一个学生名字：" + node1.getText());

        // 获取第二个学生的名字
        Node node2 = document.selectSingleNode("/students/student[2]/name");
        System.out.println("第二个学生名字：" + node2.getText());

        System.out.println("---------------------------------------------------------");
        //
        Node node3 = document.selectSingleNode("/students/student/attribute::number");
        System.out.println("第一个学生的number属性值：" + node3.getText());

        System.out.println("---------------------------------------------------------");
        // 获取最后一个student节点的id属性值
        Node node4 = document.selectSingleNode("/students/student[last()]/attribute::number");
        System.out.println("最后一个学生的number属性值：" + node3.getText());

        System.out.println("---------------------------------------------------------");
        //3.通过id的值获取student2节点中的名字
        Node node5 = document.selectSingleNode("/students/student[@number='s2']");

        System.out.println("---------------------------------------------------------");
        String name = node5.selectSingleNode("name").getText();
        System.out.println("number为s2的学生 名字是：" + name);

        System.out.println("---------------------------------------------------------");
        // 查询所有的节点
        List<Node> list = document.selectNodes("//*");
        for (Node node : list) {
            System.out.println("节点名：" + node.getName());
        }

        // 获取所有的学生名
        List<Node> list1 = document.selectNodes("//name");
        for (Node node : list1) {
            System.out.println("学生名： " + node.getText());
        }

        // 获取number为s2的学生 所有内容
        List<Node> list3 = document.selectNodes("/students/student[@number='s2']//*");
        for (Node node : list3) {
            System.out.println(node.getName()+":"+node.getText());
        }
    }

}