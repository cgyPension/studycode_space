package com.javaweb.webbackend02.spring01IOC.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GyuanYuan Cai
 * 2021/9/29
 * Description:
 *
 * daoImpl实现 实例化对象获取
 */

public class BeanFactory {

    private static Map<String, Object> iocMap = new HashMap<>();

    // 程序启动时，初始化对象实例
    static{
        // 读取配置文件
        InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
        // 使用dom4j解析xml
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(resourceAsStream);
            // 编写xpath表达式
            String xpath = "//bean";
            // 获取到所有的bean标签
            List<Element> list = document.selectNodes(xpath);
            // 遍历并使用反射创建对象实例,存到map集合(ioc容器)中
            for (Element element : list) {
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                // 使用放射生成实例对象
                Object o = Class.forName(className).newInstance();
                // 存到map中 key:id value:o
                iocMap.put(id,o);
            }
        } catch (DocumentException | ClassNotFoundException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String beanId){
        Object o = iocMap.get(beanId);
        return o;
    }

}