package com.example.algorithm.unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/5/20
 * @since 1.0.0
 *
 *
 * leetcode 547  friend circles
 * There are N students in a class. Some of them are friends, while some are not.
 * Their friendship is transitive in nature.
 * For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class.
 * If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not.
 * And you have to output the total number of friend circles among all the students.
 *
 *
 *
 * Input:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends,
 * the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends.
 * All of them are in the same friend circle, so return 1.
 *
 */
public class FriendsCircle {

    public int findCircleNum(int[][] M) {

        if(M == null || M.length == 0){
            return 0;
        }
        UnionFind uf = new UnionFind(M);
        for(int i = 0; i < M.length; i++){
            System.out.println(i);
            for(int j = i; j < M.length; j++){
                if(M[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        int result = 0;
        for(Map.Entry<Integer, Integer> e : uf.fathers.entrySet()){
            if(e.getKey().equals(e.getValue())){
                result++;
            }
        }
        return result;
    }

    public class UnionFind{

        //记录父子关系, 父节点为自己指向自己
        public HashMap<Integer, Integer> fathers ;
        //记录并集大小关系
        public HashMap<Integer, Integer> size ;

        //初始化查并集
        public UnionFind(int [][] M){

            fathers = new HashMap<>();
            size = new HashMap<>();

            for(int i = 0; i < M.length; i++){
                fathers.put(i, i);
                size.put(i, 1);
            }
        }

        //寻找父亲节点
        public int find(int i){
            int tmp = fathers.get(i);
            /**
             * 这种方法会导致 不会改变树深度
             * **/
//            if(tmp != i){
//                return find(tmp);
//            } else{
//                return tmp;
//            }
            /**
             * 让树深度接近为1
             * */
            if(tmp != i){
               tmp = find(tmp);
            }
            fathers.put(i, tmp);
            return tmp;
        }

        //并集操作
        public void union(int i, int j){

            int iFather = find(i);
            int jFather = find(j);
            if(jFather == iFather){
                return;
            }

            int iSize = size.get(iFather);
            int jSize = size.get(jFather);

            //优先让同size下，j集合并入i集合
            if(iSize >= jSize){
                // j集合 向 i集合 合并
                fathers.put(jFather, iFather);
                size.put(iFather, iSize + jSize);
            }else{
                fathers.put(iFather, jFather);
                size.put(jFather, jSize + iSize);
            }

            return;
        }
    }

    public static void main(String[] args) {
        int[][] friends = new int[][]{
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}};

        FriendsCircle solution = new FriendsCircle();
        System.out.println(solution.findCircleNum(friends));
    }
}
