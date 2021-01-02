package com.example.company.bytedance_2020_12;

public class SearchRange {

    /*
    *  lc 34. Find First and Last Position of Element in Sorted Array
    *
    * */
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int firstIndex = searchFirstLocation(nums, target);
        int rightIndex = searchLastLocation(nums, target);
        return new int[]{firstIndex, rightIndex};
    }

    /**
     * 采用闭区间,
     * 求first location, 把right推到第一个小于target的值, 返回right + 1
     * 注意： right是否有被推动过，可能会报out of boundary
     * 例如 [1], 7
     */
    private int searchFirstLocation(int[]nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid  + 1;
            }
        }
        //处理 - right 边界 - 没有动
        if(right == nums.length - 1){
            return -1;
        }
        return nums[right + 1] == target ? right + 1: -1;
    }

    /**
     * 采用闭区间
     * 求last location, 把left推到一个大于target的值，返回left - 1
     * 注意，如果left没有被推动过，可能会报out of boundary
     * [1] 0
     */
    private static int searchLastLocation(int[]nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid  = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        //处理 - left边界  - 没有移动
        if(left == 0){
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        searchLastLocation(nums, 0);
    }
}
