package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/9/20
 * @since 1.0.0
 */
public class HeapSorting {

    //手撕heap sorting，建立最大根
    //https://www.cnblogs.com/CherishFX/p/4643940.html

    //建立一个最小堆
    public int[] heaplify(int [] nums){
        for(int i = nums.length / 2 - 1; i >= 0; i--){
            heapShiftUp(nums, i, nums.length);
        }
        return nums;
    }

    //让某个字节点，满足最大堆
    public void heapShiftUp(int[] nums, int i, int length){
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;
        int maxIndex = i;
        if(leftChild < length && nums[leftChild] > nums[maxIndex]){
            maxIndex = leftChild;
        }
        if(rightChild < length && nums[rightChild] > nums[maxIndex]){
            maxIndex = rightChild;
        }
        if(maxIndex != i){
            int tmp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = tmp;
            heapShiftUp(nums, maxIndex, length); //交换节点后，子节点结构可能不满最大堆结构
        }
        return;
    }

    public void heapSorting(int[] array){
        heaplify(array);
        for(int i = array.length - 1; i >= 0; i--){
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            heapShiftUp(array, 0 , i);
        }
    }

    public static void main(String[] args) {
        HeapSorting solution = new HeapSorting();
        int[] nums = new int[]{4, 2, 3, 1, 5, 7, 8};
        System.out.println(Arrays.toString(nums));
        solution.heapSorting(nums);
        System.out.println(Arrays.toString(nums));
    }
}
