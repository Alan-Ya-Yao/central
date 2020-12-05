package com.example.company.tengcent_2020;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 9/12/20
 * @since 1.0.0
 */
public class CountPrimes {
    /**
     *  leetcode 204. 计数质数
     *  0,1 不是质数，2是最小的质数
     *
     * */
    public int countPrimes(int n) {
        int count = 0;
        for(int i = 2; i <= n; i++){
            count = isPrime(i)?count + 1: count;
        }
        return count;
    }

    private boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
