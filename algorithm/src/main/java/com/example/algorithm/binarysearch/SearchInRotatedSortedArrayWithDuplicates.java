package com.example.algorithm.binarysearch;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/2/20
 * @since 1.0.0
 */
public class SearchInRotatedSortedArrayWithDuplicates {

    public boolean search(int[] nums, int target) {

        boolean result = false;

        if(nums == null || nums.length == 0){
            return result;
        }

        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = (right + left) / 2;
            if(nums[mid] == target){
                return true;
            }
            //此题的关键
            //当mid值与right值相等时，开始删掉right这个，即开始夹逼
            if(nums[mid] == nums[right]){
                right --;
                continue;
            }
            if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
