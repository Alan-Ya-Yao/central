package com.example.company.bytedance_2020_12.medium;

import java.util.Objects;

public class ZigZagConversion_202012 {

    /**
     * 6. ZigZag Conversion
     *
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)

     *Example 1:
     *
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     *
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *
     * */
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        Character[][] steps = new Character[numRows][s.length()];
        int direction = 1; // 1 直接向下，2，斜上走
        int i = -1, j = 0;
        for(int step = 0; step < s.length(); step++){
            if(direction == 1){
                i += 1;
            }else{
                i -= 1;
                j += 1;
            }
            steps[i][j] = s.charAt(step);
            if(step !=0 && step % (numRows - 1) == 0){
                if(direction == 1){
                    direction = 0;
                }else{
                    direction = 1;
                }
            }
        }
        StringBuffer result = new StringBuffer();
        for(int h = 0; h < steps.length;h++){
            for(int t = 0; t < steps[0].length;t++){
                if(Objects.nonNull(steps[h][t])){
                    result.append(steps[h][t]);
                }
            }
        }
        return result.toString();
    }
}
