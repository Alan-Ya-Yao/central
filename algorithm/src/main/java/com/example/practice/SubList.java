package com.example.practice;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * /**
 *
 * @ClassName: SubList
 * @description: DivideListsIntoSublist
 * @author: pengyi
 * @create: 2021-06-15 15:49
 **/
public class SubList {

    @Test
    public void test() {
        // 创建并初始化List集合
        List<Integer> numList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

        List<List<Integer>> partition = Lists.partition(numList, 1);
        System.out.println(JSON.toJSONString(partition));
    }

    @Test
    public void testCeiling(){
        double x = 15;
        double y = 4;
        System.out.println((int)Math.ceil(x/y));
    }
}
