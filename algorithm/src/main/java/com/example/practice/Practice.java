package com.example.practice;

import com.alibaba.fastjson.JSONObject;
import lombok.*;
import org.junit.Test;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 11/12/20
 * @since 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Practice {

    private String name;
    private String age;
    public static void main(String[] args) {
//        String json = "{\n" +
//                "    \"cpu\": \"0.25\",\n" +
//                "    \"cpuFrequency\": \"1\",\n" +
//                "    \"mem\": \"0.95\",\n" +
//                "    \"memFrequency\": \"1\",\n" +
//                "    \"error\": \"300\",\n" +
//                "    \"errorFrequency\":\"2\",\n" +
//                "    \"fgc\": \"0.9\",\n" +
//                "    \"fgcFrequency\":\"1\"\n" +
//                "}";
//
//        String s = JSONObject.toJSONString(json);
//        System.out.println(s);

        String selfHost = "riskmodelcenter-87-5191";
        System.out.println(selfHost.split("-")[0]);
    }


}
