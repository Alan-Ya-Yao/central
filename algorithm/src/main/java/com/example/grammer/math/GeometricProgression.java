package com.example.grammer.math;

import java.util.ArrayList;
import java.util.List;

/**
 * /**
 *
 * @ClassName: GeometricProgression
 * @description:
 * @author: pengyi
 * @create: 2021-02-19 20:46
 **/
public class GeometricProgression {
    public static void main(String[] args) {
        int max = 8;
        int min = 1;
        int num = 20;
        Double commonRatio = Math.pow(max/ min, 1.0 / (num - 1));
        List<Double> an = new ArrayList<>();
        for(int i = 0; i < num - 1; i++) {
            Double ai = min * Math.pow(commonRatio, i);
            an.add(ai);
            Double ai_1 = min * Math.pow(commonRatio, i + 1);
            if (i == num - 2) {
                //最后一个数据向上取整
                ai_1 = Math.ceil(ai_1);
                an.add(ai_1);
            }
        }
        System.out.println(an);
        System.out.println(an.size());
    }
}
