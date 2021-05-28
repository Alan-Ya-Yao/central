package com.example.grammer;


import java.io.PrintWriter;
import java.io.StringWriter;
/**
 * /**
 *
 * @ClassName: ExceptionPractice
 * @description:
 * @author: pengyi
 * @create: 2021-05-21 15:37
 **/
public class ExceptionPractice {

//    public static void main(String[] args) {
//        try{
//            int denominator = 0;
//            int numerator = 1;
//            System.out.println(numerator / denominator);
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println(" failed, " + e.getMessage());
//        }
//    }
    public static void main(String[] args) {
        String s = null;
        try {
            s.length();
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String msg =sw.toString();
            System.out.println(msg);
            //当然如果你懒得想提示信息的话，直接这样log.error("", e);
        }
    }


}
