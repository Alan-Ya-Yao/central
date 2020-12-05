package com.example.algorithm.unionfind;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/3/20
 * @since 1.0.0
 */
public class LongestConsecutive {

    /*
    * 查并集
    * leetcode 128 longest consecutive sequence
    * 查并集关键 如何确定并集
    * 1 find 操作 - recursion method，同时限制查并集形成的数结构深度为 1
    * 2 union 操作 - 合并两个集合
    *
    * 查并集应用过程中，只会调用union 函数，调用union函数时，计算出想要的结果
    * */

    public int longestConsecutive(int[] nums) {
        int result = 0;
        if(nums == null || nums.length == 0){
            return result;
        }
        //定义并初始化两个集合father集合 和 集合大小属性（没有集合大小属性-完成不了O(n)的complexity）
        UnionFind uf = new UnionFind(nums);

        //判断两个集合是否可以做并
        // nums[i], nums[i] - 1 理应合并在一起
        for(int i = 0; i < nums.length; i++){
            if(uf.father.containsKey(nums[i] - 1)){
                uf.union(nums[i], nums[i] - 1 );
            }
        }
        return uf.max;
    }

    public class UnionFind{

        //记录当前最大集合的size
        int max;
        //用于记录父子关系
        HashMap<Integer, Integer> father;
        //用于让小集合向大集合合并
        HashMap<Integer, Integer> size;

        public UnionFind(int[] nums){

            father = new HashMap<>();
            size = new HashMap<>();

            for(int i = 0; i < nums.length; i++){
                father.put(nums[i], nums[i]);
                size.put(nums[i], 1);
            }
        }

        // find 找到父亲节点 - 采用迭代,找到根节点
        public int find(int val){
           int tmp = father.get(val);
           if(tmp != val){
               //迭代
               tmp = find(tmp);
           }
           //这里有一个并集优化，让查并集的深度接近于 1。
           father.put(val, tmp);
           return tmp;
        }


        // union 两个节点合并
        public void union(int i, int j){
            int ifather = find(i);
            int jfather = find(j);
            if(ifather != jfather){

                // i集合，向 j集合合并
                int isize = size.get(ifather);
                int jsize = size.get(jfather);
                if(isize < jsize){
                    father.put(i, j);
                    size.put(j, isize + jsize);
                }else{
                    father.put(j, i);
                    size.put(i, isize + jsize);
                }
                max = Math.max(max, isize + jsize);
            }

        }

    }



    public static void main(String[] args) {
        int[] array = new int[]{100, 4, 200, 1, 3, 2};
        LongestConsecutive solution = new LongestConsecutive();
        System.out.println(solution.longestConsecutive(array));
    }
}
