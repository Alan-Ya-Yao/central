package com.example.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 11/10/20
 * @since 1.0.0
 */
public class Subset2020_11 {

    /**
     *
     * leetcode 78
     *
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     *
     * Input: nums = [1,2,3]
     * Output:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     *
     * */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        subsets_backtracking(0, nums, new ArrayList<>(), result);
        return  result;
    }

    private void subsets_backtracking(int index, int[] nums, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<Integer>(path));
        if(index == nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            //去除重复
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            //经典必须是 i+1, 不能是++i这会导致i增加过多，不能是i++这会导致先传入i后i在自增，同时i的增加过度
            subsets_backtracking(i + 1, nums, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset2020_11 solution = new Subset2020_11();
        List<List<Integer>> res = solution.subsets(new int[]{3,2,1});
    }

}
