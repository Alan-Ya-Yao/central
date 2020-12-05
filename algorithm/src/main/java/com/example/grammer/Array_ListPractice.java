package com.example.grammer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/26/20
 * @since 1.0.0
 */
public class Array_ListPractice {


    public static void arrayOperation(){



        // 1-D array
        Integer[] ars = new Integer[]{1, 2, 3, 4};
        System.out.println(ars); // [I@7a0ac6e3]
        System.out.println(Arrays.toString(ars)); //[1, 2, 3, 4]

        // convert array to list
        List<Integer> arsList = Arrays.asList(ars);
        arsList.size();
        System.out.println(arsList);

        // convert list to array
        Integer[] arsArray = arsList.toArray(new Integer[arsList.size()]);
        Arrays.stream(arsArray).forEach(System.out::println);



        // convert int[] to integer list
        int[] intArray = new int[]{1, 2, 3, 4, 5};
        List integerList_1  = Arrays.asList(intArray);
        List<Integer> integersList = Arrays.stream(intArray).boxed().collect(Collectors.toList());

        // convert integer list to int[]
        int[] intArrayCopy = integersList.stream().mapToInt(i -> i).toArray();


    }

    public static void listOperation(){
        List<String> list = new ArrayList<>();
        list.add("two");
        list.add("three");
        list.add(0, "one");
        list.add(list.size() , "four");

        System.out.println(list.toString());
    }

    public static void main(String[] args) {
//        arrayOperation();
        listOperation();

    }
}
