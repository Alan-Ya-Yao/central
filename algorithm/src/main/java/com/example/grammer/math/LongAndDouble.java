package com.example.grammer.math;

/**
 * /**
 *
 * @ClassName: LongAndDouble
 * @description:
 * @author: pengyi
 * @create: 2021-03-10 16:27
 **/
public class LongAndDouble {

        public static void main(String[] args) {
            double d = 88.88;
            long l = Math.round(d);
            System.out.println(l);

            long ll = 1613280900000l;
            double dd = (double) ll;
            System.out.println(dd);

            long l3 = (long) dd;
            System.out.println(l3);

    }
}
