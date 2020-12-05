package com.example.grammer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 7/12/20
 * @since 1.0.0
 */
public class DatePractice {
        public static void main(String[] args) throws ParseException {
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //字符串变为时间Date类,解析p格式化f,pf
            long time = sdf.parse("2020-07-12 17:04:01.503").getTime();
            //获得时间毫秒值
//            long time2 = sdf.parse("2020-07-11 16:58:51.503").getTime();
            long time2 = System.currentTimeMillis();
            System.out.println((int)(time2-time) / 1000);
        }
}
