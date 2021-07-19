package com.javaweb.mysql.xml;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/6/19
 * Description:
 */

public class $04_TestDom4j {
    public static void main(String[] args) throws DocumentException {
        //1.获取XML解析对象
        SAXReader reader = new SAXReader();

        //2.解析XML获取文档对象document
        Document document = reader.read("D:\\code\\studycode_space\\01_java\\src\\main\\java\\com\\javaweb\\mysql\\xml\\$03_student.xml");

        // 获取根元素
        Element rootElement = document.getRootElement();

        // 获取根元素名称
        System.out.println(rootElement.getName());

        // 获取根元素小的标签
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            System.out.println("根标签下的子节点 " + element.getName());
            List<Element> eList = element.elements();
            for (Element e : eList) {
                System.out.println("标签下的子节点 " + e.getName());
            }
        }

        // 获取集合中的第一个 子节点
        Element student = elements.get(0);
        String number = student.attributeValue("number");
        String name = student.elementText("name");
        String age = student.elementText("age");
        // String hobby = student.element("hobby").getText();
        System.out.println(number+" "+name+" "+age);

    }

}