package com.example.algorithm.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * /**
 *
 * @ClassName: SpiralMatrix_202104
 * @description:
 * @author: pengyi
 * @create: 2021-04-18 18:15
 **/
public class SpiralMatrix_202104 {


    /**
     * 54. Spiral Matrix
     *
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,3,6,9,8,7,4,5]
     *
     * 注意定义边界线
     * **/
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<Integer>();
        int row  = matrix.length;
        int column = matrix[0].length;
        int totalSteps =  row * column;
        int top = 0, bottom = row - 1, left = 0, right = column - 1;
        int direction = 0; // 0向右 1向下 2向左 3向上
        int i = 0, j = 0;
        while(totalSteps != 0){
            switch (direction){
                case 0://向右
                    while(j <= right){
                        result.add(matrix[i][j]);
                        j++;
                        totalSteps--;
                    }
                    top ++;
                    j--;
                    i++;
                    direction = 1;
                    break;
                case 1://向下
                    while(i <= bottom){
                        result.add(matrix[i][j]);
                        i++;
                        totalSteps--;
                    }
                    i--;
                    j--;
                    right --;
                    direction = 2;
                    break;
                case 2://向左
                    while(j >= left){
                        result.add(matrix[i][j]);
                        j--;
                        totalSteps--;
                    }
                    j++;
                    i--;
                    bottom --;
                    direction = 3;
                    break;
                case 3://向上
                    while(i >= top){
                        result.add(matrix[i][j]);
                        i--;
                        totalSteps--;
                    }
                    i++;
                    j++;
                    left ++;
                    direction = 0;
                    break;
            }
        }
        return result;
    }


    public static List<Integer> spiralOrderII(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 ){
            return result;
        }
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        //
        int totalElements = matrix.length * matrix[0].length;
        int k = 0;
        while (k < totalElements) { // 每转一圈，k去判断totalElements
            //go left
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                k++;
            }
            if (++top > bottom) {
                break;
            }

            //go down
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                k++;
            }
            if (--right < left) {
                break;
            }

            //go right
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
                k++;
            }
            if (--bottom < top) {
                break;
            }

            // go up
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
                k++;
            }
            if (++left> right) {
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{ {1,2,3,4},
                                       {5,6,7,8},
                                     {9,10,11,12},
                                     {13,14,15,16} };
        SpiralMatrix_202104 solution = new SpiralMatrix_202104();
        List<Integer> result  = solution.spiralOrder(matrix);
        result.stream().forEach(e -> System.out.print(e + ","));
    }
}
