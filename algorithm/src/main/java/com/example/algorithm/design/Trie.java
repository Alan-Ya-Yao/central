package com.example.algorithm.design;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 8/6/20
 * @since 1.0.0
 */
public class Trie {


    /**
     * leetcode 208 https://leetcode-cn.com/problems/implement-trie-prefix-tree/
     *
     * 设计这个TrieNode 为重点
     * */
    class TrieNode{
        private TrieNode[] nextKeys;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode(){
            nextKeys = new TrieNode[R];
        }

        public boolean containsTrieKey(char ch){
            return nextKeys[ch - 'a'] != null;
        }

        public TrieNode getTrieNode(char ch){
            return nextKeys[ch - 'a'];
        }

        public void putTrieNode(char ch, TrieNode node){
            nextKeys[ch - 'a'] = node;
        }

        public void setEnd(){
            isEnd = true;
        }

        public boolean getEnd(){
            return isEnd;
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsTrieKey(ch)){
                node.putTrieNode(ch, new TrieNode());
            }
            node = node.getTrieNode(ch);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode next = node.getTrieNode(ch);
            if(next == null){
                return false;
            }
            node = next;
        }
        return node.getEnd()? true:false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            TrieNode nextTrieNode = node.getTrieNode(ch);
            if(nextTrieNode == null){
                return false;
            }
            node = nextTrieNode;
        }
        return true;
    }
}
