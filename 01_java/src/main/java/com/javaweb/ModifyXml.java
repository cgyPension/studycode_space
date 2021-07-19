package com.javaweb;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class ModifyXml {

	public static void main(String[] args) {
		//ModifyXml.modifyktrConnectionType("d:/db_to_hive.ktr", "MSSQLNATIVE");//ORACLE  MYSQL  MSSQLNATIVE
		
	}

	public static void modifyJobParameters(String xmlPath, int offset, List<String> keyList) {
		try {
			// 1.得到DOM解析器的工厂实例
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(xmlPath);
			// 指定要操作的是第几个 parameters
			Element parametersElement = (Element) doc.getElementsByTagName("parameters").item(offset);

			if (offset == 0) {
				for (int i = 0; i < keyList.size(); i++) {
					// 创parameter建节点
					Element parameterElement = doc.createElement("parameter");

					// 创建name节点
					Element nameElement = doc.createElement("name");
					nameElement.setTextContent("sub" + keyList.get(i));

					// 创建default_value节点
					Element default_valueElement = doc.createElement("default_value");
					default_valueElement.setTextContent("${" + keyList.get(i) + "}");

					// 创建description节点
					Element descriptionElement = doc.createElement("description");

					// 添加父子关系
					parameterElement.appendChild(nameElement);
					parameterElement.appendChild(default_valueElement);
					parameterElement.appendChild(descriptionElement);

					parametersElement.appendChild(parameterElement);
				}
			} else if (offset == 1) {
				for (int i = 0; i < keyList.size(); i++) {
					// 创parameter建节点
					Element parameterElement = doc.createElement("parameter");

					// 创建name节点
					Element nameElement = doc.createElement("name");
					nameElement.setTextContent("sub_" + keyList.get(i));

					// 创建stream_name节点
					Element stream_nameElement = doc.createElement("stream_name");

					// 创建value节点
					Element valueElement = doc.createElement("value");
					valueElement.setTextContent("${sub" + keyList.get(i) + "}");

					// 添加父子关系
					parameterElement.appendChild(nameElement);
					parameterElement.appendChild(stream_nameElement);
					parameterElement.appendChild(valueElement);

					parametersElement.appendChild(parameterElement);
				}
			}
			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			StreamResult result = new StreamResult(new FileOutputStream(xmlPath));
			// 把DOM树转换为xml文件
			transformer.transform(domSource, result);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void modifyktrConnectionType(String xmlPath, String ConnectionType) {
		try {
			// 1.得到DOM解析器的工厂实例
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(xmlPath);
			// 找出 根下的第7个 connection
			Element connectionElement = (Element) doc.getElementsByTagName("connection").item(6);// doc取，代表从根下取connection
			// 取出connection下所有的子节点														
			NodeList childList = connectionElement.getChildNodes();
			for (int i = 0; i < childList.getLength(); i++) {// 遍历connection下所有的子节点
				if (childList.item(i).getNodeType() == Node.ELEMENT_NODE&&childList.item(i).getNodeName().equals("type")) {
					Element typeElement = (Element) childList.item(i);
					typeElement.setTextContent(ConnectionType);
				}
			}
			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			StreamResult result = new StreamResult(new FileOutputStream(xmlPath));
			// 把DOM树转换为xml文件
			transformer.transform(domSource, result);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void modifyktrSql(String xmlPath, String sqlStirng) {
		try {
			// 1.得到DOM解析器的工厂实例
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(xmlPath);
			// 指定要操作的是第1个 sql
			Element sqlElement = (Element) doc.getElementsByTagName("sql").item(0);
			// 给sql标签重新赋值
			sqlElement.setTextContent(sqlStirng);
			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			StreamResult result = new StreamResult(new FileOutputStream(xmlPath));
			// 把DOM树转换为xml文件
			transformer.transform(domSource, result);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void modifykjbSql(String xmlPath, String sqlStirng) {
		try {
			// 1.得到DOM解析器的工厂实例
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(xmlPath);
			// 指定要操作的是第1个 sql
			Element sqlElement = (Element) doc.getElementsByTagName("sql").item(0);
			// 给sql标签重新赋值
			sqlElement.setTextContent(sqlStirng);
			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			StreamResult result = new StreamResult(new FileOutputStream(xmlPath));
			// 把DOM树转换为xml文件
			transformer.transform(domSource, result);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void modifyktrFields(String xmlPath, List<String> getColumns) {
		try {
			// 1.得到DOM解析器的工厂实例
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(xmlPath);
			// 指定要操作的是第几个 fields
			Element fieldsElement = (Element) doc.getElementsByTagName("fields").item(0);
			fieldsElement.setTextContent("");// 先清空 fields标签内容
			for (int i = 0; i < getColumns.size(); i++) {// 循环遍历 目标表所有的列，进行拼接
															// 输出列
				// 创field建节点
				Element fieldElement = doc.createElement("field");

				// 创建name节点
				Element nameElement = doc.createElement("name");
				nameElement.setTextContent(getColumns.get(i));

				// 创建type节点
				Element typeElement = doc.createElement("type");
				typeElement.setTextContent("String");

				// 创建format节点
				Element formatElement = doc.createElement("format");

				// 创建currency节点
				Element currencyElement = doc.createElement("currency");

				// 创建decimal节点
				Element decimalElement = doc.createElement("decimal");

				// 创建group节点
				Element groupElement = doc.createElement("group");

				// 创建nullif节点
				Element nullifElement = doc.createElement("nullif");

				// 创建trim_type节点
				Element trim_typeElement = doc.createElement("trim_type");
				trim_typeElement.setTextContent("both");

				// 创建length节点
				Element lengthElement = doc.createElement("length");
				lengthElement.setTextContent("-1");

				// 创建precision节点
				Element precisionElement = doc.createElement("precision");
				precisionElement.setTextContent("-1");

				// 添加父子关系
				fieldElement.appendChild(nameElement);
				fieldElement.appendChild(typeElement);
				fieldElement.appendChild(formatElement);
				fieldElement.appendChild(currencyElement);
				fieldElement.appendChild(decimalElement);
				fieldElement.appendChild(groupElement);
				fieldElement.appendChild(nullifElement);
				fieldElement.appendChild(trim_typeElement);
				fieldElement.appendChild(lengthElement);
				fieldElement.appendChild(precisionElement);

				fieldsElement.appendChild(fieldElement);
			}
			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			StreamResult result = new StreamResult(new FileOutputStream(xmlPath));
			// 把DOM树转换为xml文件
			transformer.transform(domSource, result);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
