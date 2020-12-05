package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/3/20
 * @since 1.0.0
 */
public class QuickSorting {

    public static int[] quickSorting(int[] unsorted){
        quickSorting_divider_conquer(unsorted,0,unsorted.length - 1);
        return  unsorted;
    }

    public static void quickSorting_divider_conquer(int[] unsorted, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = unsorted[left];
        int l = left + 1, r = right;
        while(l <= r){
            while(l <= r && unsorted[l] <= pivot){
                l ++;
            }
            while(l <= r && unsorted[r] > pivot){
                r --;
            }
            if(l > r){
                break;
            }
            int tmp = unsorted[l];
            unsorted[l] = unsorted[r];
            unsorted[r] = tmp;
        }
        unsorted[left] = unsorted[r];
        unsorted[r] = pivot;
        quickSorting_divider_conquer(unsorted, left, r - 1);
        quickSorting_divider_conquer(unsorted, r + 1, right);
        return;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[]{3, 2, 1, 5, 6, 4};
        quickSorting(unsorted);
        Arrays.stream(unsorted).forEach(System.out::print);
    }
}
