package com.example.grammer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 7/17/20
 * @since 1.0.0
 */
public class LambdaPractice {

    public static void eat_conversion_example(){
        Function<String,String> func =  String::toUpperCase;
        List<String> ls = Arrays.asList("a", "b", "c");
        List<String>  ls1 = ls.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
        List<String>  ls2 = ls.stream().map(func).collect(Collectors.toList());
        System.out.println(ls1.toString());
        System.out.println(ls2.toString());


    }



    public static void main(String[] args) {
        int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2); // 这一步是ok的，可以输出3
//        num = 5; // 会报错 Error:(18, 93)
        // java: local variables referenced from a lambda expression must be final or effectively final

        eat_conversion_example();
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }
}
