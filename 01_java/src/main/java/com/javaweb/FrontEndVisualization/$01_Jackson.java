package com.javaweb.FrontEndVisualization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/6/16
 * Description:
 *
 * Jackson 开源免费的json转换工具，springmvc转换默认使用jackson
 *
 * jackson的常用对象和方法.
 * objectMapper对象，可以将java对象转成json.
 * writeValueAsstring(java劝象)===>返回值是一个json
 *
 *
 * @JsonIgnore  // bean转换成json时候 跳过这个字段
 * @JsonFormat(pattern = "YYY-MM-dd") // 日期转换注解
 */

public class $01_Jackson {

    public static void method3() throws JsonProcessingException {
        // Map集合的数据转换成json
        HashMap<String,User> map = new HashMap();
        map.put("m1",new User("财神", 30, new Date(), "佛山"));
        map.put("m2",new User("鲸鱼", 30, new Date(), "佛山"));
        map.put("m3",new User("锦鲤", 30, new Date(), "佛山"));
        ObjectMapper om = new ObjectMapper();
        String jsonObj = om.writeValueAsString(map);
        System.out.println(jsonObj); // {"m1":{},"m2":{},"m3":{}}

    }


    public static void method2() throws JsonProcessingException {
        // List类型的数据转换成json
        List<User> list = new ArrayList();
        list.add(new User("财神", 30, new Date(), "佛山"));
        list.add(new User("鲸鱼", 10, new Date(), "佛山"));
        list.add(new User("锦鲤", 30, new Date(), "佛山"));
        ObjectMapper om = new ObjectMapper();
        //调用writeValueAsstring将user对象转成json
        String jsonObj = om.writeValueAsString(list);
        System.out.println(jsonObj); // [{},{},{}]

    }

    public static void method1() throws JsonProcessingException {
        User user = new User("财神", 30, new Date(), "佛山");
        // 创建jackson的核心对象
        System.out.println(user);
        ObjectMapper om = new ObjectMapper();
        //调用writeValueAsstring将user对象转成json
        String jsonObj = om.writeValueAsString(user);
        System.out.println(jsonObj);

    }

}