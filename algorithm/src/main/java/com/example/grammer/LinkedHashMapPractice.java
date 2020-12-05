package com.example.grammer;

import java.util.LinkedHashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/24/20
 * @since 1.0.0
 */
public class LinkedHashMapPractice {

    public static void main(String[] args) {
        LinkedHashMap<String, String> lmp = new LinkedHashMap<>();
        lmp.put("nama", "aValue");
        lmp.put("namc", "cValue");
        lmp.put("namb", "bValue");
        lmp.entrySet().stream().forEach((e) -> {
            System.out.println("key is :" + e.getKey() + ", value is: " + e.getValue() );
        });
    }
}
