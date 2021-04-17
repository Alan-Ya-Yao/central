package com.example.company.shopee_202104;

import java.util.*;

/**
 * /**
 *
 * @ClassName: TopKFrequentElements
 * @description:
 * @author: pengyi
 * @create: 2021-04-15 19:50
 **/
public class TopKFrequentElements {

    /**
     * 347. Top K Frequent Elements
     *Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     *
     * **/
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i : nums){
            hm.compute(i, (key ,value)->{
                if(value == null){
                    return 1;
                }else{
                    return value + 1;
                }
            });
        }
        List<Integer> listKey = new ArrayList<Integer>(hm.keySet());
        Collections.sort(listKey,(v1, v2)->{
            if(hm.get(v1).equals(hm.get(v2))){
                return v1.compareTo(v2);
            }else{
                return hm.get(v1).compareTo(hm.get(v2));
            }
        });
        return Arrays.copyOf(nums, k);
    }
}
