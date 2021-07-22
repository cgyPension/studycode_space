package com.cgy;

import java.io.*;
import java.net.*;
import java.util.*;
import com.alibaba.fastjson.*;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.codec.binary.Base64;
import org.jeecg.modules.insurance.service.IHisKylinApiService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HisKylinApiServiceImpl implements IHisKylinApiService {

	private static String encoding;
	private static final String baseURL = "http://192.168.1.180:7070/kylin/api";

	@Override
	// 登录功能
	public String login(String user, String passwd) throws Exception {
		String method = "POST";
		String para = "/user/authentication";
		byte[] key = (user + ":" + passwd).getBytes();
		encoding = Base64.encodeBase64String(key);// 对用户名和密码拼接的串，使用Base64加密成一个字符串
		return excute(para, method, null);
	}

	@Override
	// 查询所有的cube
	public String listCubes(String dataclass) throws Exception {
		login("ADMIN", "KYLIN");
		String method = "GET";
		String para = "/cubes";
		String output = excute(para, method, null);
		List<String> listCubes = new ArrayList<String>();// 保存所有的cube的名字
		String cubeName = "";// 保存cube的名字
		String projectName = "";// 保存project的名字
		JSONArray baseJsonArray = JSONArray.parseArray(output);
		JSONObject jsonObject = null;// 保存从JSON数组中解析出的每一个json对象
		
		JSONArray cubes = new JSONArray();// 保存 所有cube名字 的json数组
		JSONObject cube = null;// 保存 每一个cube的名字的json对象
		String cubeJson ="";//最终返回的结果
		if (baseJsonArray.size() > 0) {
			for (int i = 0; i < baseJsonArray.size(); i++) {
				jsonObject = baseJsonArray.getJSONObject(i);
				cubeName = jsonObject.getString("name");
				projectName = jsonObject.getString("project");
				if (projectName.toLowerCase().contains(dataclass.toLowerCase())) {
					cube = new JSONObject();
					cube.put("cubeName", cubeName);// 增加cube的名字
					cubes.add(cube);// 把cube加入数组中
				}
			}
			cubeJson=cubes.toJSONString();
		}
		return cubeJson;
	}

	@Override
	// 获取指定cube的状态
	public String getCubeStatus(String cubeName) throws Exception {
		login("ADMIN", "KYLIN");
		String output = getCube(cubeName);// 获取指定的cube相关信息
		JSONObject jsonObject = JSONObject.parseObject(output);// 把cube的相关信息保存成JSON对象
		String cubeStatus = "build";// 保存cube的状态：build、DISABLED、READY
		JSONArray segmentsJsonArray = jsonObject.getJSONArray("segments");// cube中的segment
		if (segmentsJsonArray.size() > 0) {// cube中的segment有数据的话
			cubeStatus = jsonObject.getString("status");
		}
		return cubeStatus;
	}

	@Override
	// 获取指定cube相关信息
	public String getCube(String cubeName) throws Exception {
		login("ADMIN", "KYLIN");
		String method = "GET";
		String para = "/cubes/" + cubeName;
		return excute(para, method, null);
	}

	@Override
	// 让指定cube生效
	public String enableCube(String cubeName) throws Exception {
		login("ADMIN", "KYLIN");
		String cubeStatus = getCubeStatus(cubeName);
		if (cubeStatus.equals("DISABLED"))// 当前cube的状态是：DISABLED，才能enbale操作
		{
			String method = "PUT";
			String para = "/cubes/" + cubeName + "/enable";
			excute(para, method, null);
			return "操作成功";
		} else if (cubeStatus.equals("build")) {
			return "当前cube中没有数据，需要先build";
		}
		return "状态已经是enable";
	}

	@Override
	// 让指定cube失效
	public String disableCube(String cubeName) throws Exception {
		login("ADMIN", "KYLIN");
		String cubeStatus = getCubeStatus(cubeName);
		if (cubeStatus.equals("READY")) {
			String method = "PUT";
			String para = "/cubes/" + cubeName + "/disable";
			excute(para, method, null);
			return  "操作成功";
		} else if (cubeStatus.equals("build")) {
			return "当前cube中没有数据，需要先build";
		}
		return "状态已经是disable";

	}

	@Override
	// 清空指定cube中的数据
	public String purgeCube(String cubeName) throws Exception {
		login("ADMIN", "KYLIN");
		disableCube(cubeName);// 要先disable
		String method = "PUT";
		String para = "/cubes/" + cubeName + "/purge";
		excute(para, method, null);
		return  "操作成功"; 

	}

	@Override
	// 重新构建指定的cube
	public String buildCube(String cubeName, String startTime, String endTime) throws Exception {
		login("ADMIN", "KYLIN");
		String body = "{\"startTime\":" + startTime + ",\"endTime\":" + endTime + " ,\"buildType\": \"BUILD\"}";
		String method = "PUT";
		String para = "/cubes/" + cubeName + "/build";
		excute(para, method, body);
		return "操作开始";
	}

	@Override
	// 最终调用，去kylin真正执行的部分
	public String excute(String para, String method, String body) throws Exception {
		StringBuilder out = new StringBuilder();
		try {
			URL url = new URL(baseURL + para);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 得到URLConnection对象，使用他的子类HttpURLConnection去做链接和网络传输工作
			connection.setRequestMethod(method);// 指定请求方式为PUT或GET
			connection.setDoOutput(true);// URL连接可用于输入和/或输出。如果打算使用 URL 连接进行输出，则将
											// DoOutput 标志设置为 true
			String value = "Basic " + encoding;
			connection.setRequestProperty("Authorization", value);// 设置http请求头，身份验证
			connection.setRequestProperty("Content-Type", "application/json");// 设置http请求头，内容格式是JSON
			if (body != null) {
				byte[] outputInBytes = body.getBytes("UTF-8");// 设置编码
				OutputStream os = connection.getOutputStream(); // 使用getOutputStream()，会自动调用connect()
				os.write(outputInBytes);// 把 相关参数 写操作
				os.close();// 关闭输出流
			}
			InputStream content = (InputStream) connection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(content)); // 获取请求的内容，封装成流
			String line;
			while ((line = in.readLine()) != null) {// 输出流中的每一行内容
				out.append(line);
			}
			in.close();
			connection.disconnect();// 关闭连接，释放资源
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("操作异常");
		}
		return out.toString(); // 返回最终响应信息
	}
}
