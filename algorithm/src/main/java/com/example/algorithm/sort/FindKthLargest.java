package com.example.algorithm.sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/3/20
 * @since 1.0.0
 * leetcode 215
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class FindKthLargest {

    public static int findKthLargest(int[]nums, int k){

        if(nums == null || nums.length == 0){
            return 0;
        }

        return quickSort(nums, 0, nums.length - 1, k);
    }

    public static int quickSort(int[] nums, int left, int right, int position){
        if(left >= right){
            return nums[left];
        }

        int pivot = nums[left];
        int i = left + 1, j = right;

        while(i <= j){
            while(i <= j && nums[i] <= pivot){
                i++;
            }
            while(i <=j && nums[j] > pivot){
                j--;
            }
            if(i > j){
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        nums[left] = nums[j];
        nums[j] = pivot;

        if(j == nums.length - position){
            return nums[j];
        }else if(j < nums.length - position){
           return quickSort(nums, j + 1, right, position);
        }else{
           return quickSort(nums, left, j - 1, position);
        }
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 1));
    }
}
