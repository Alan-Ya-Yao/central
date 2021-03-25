package com.example.design.ood_202103;

/**
 * /**
 *
 * @ClassName: Trie
 * @description:
 * @author: pengyi
 * @create: 2021-03-23 17:38
 **/
public class Trie {

    /**
     *
     * leetcode 208
     * Trie (we pronounce "try") or prefix tree is a tree data structure used to retrieve a key in a strings dataset.
     * There are various applications of this very efficient data structure, such as autocomplete and spellchecker.
     *
     * Implement the Trie class:
     *
     * Trie() initializes the trie object.
     * void insert(String word) inserts the string word to the trie.
     * boolean search(String word) returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
     * boolean startsWith(String prefix) returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
     *
     * Input
     * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
     * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
     * Output
     * [null, null, true, false, true, null, true]
     *
     * */

    /** Initialize your data structure here. */
    TrieNode root;

    static class TrieNode{
        Character cur;
        TrieNode[] children;
        Boolean isEnd;

        TrieNode(char cur){
            this.cur = cur;
            children = new TrieNode[26];
            isEnd = false;
        }

        Boolean contains(char child){
            return children[child - 'a'] != null;
        }

        void add(char child){
            TrieNode toAdd = new TrieNode(child);
            children[child - 'a'] = toAdd;
        }

        TrieNode get(char child){
            return children[child - 'a'];
        }
    }
    public Trie() {
        root = new TrieNode('r');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = root;
        for(int i = 0; i < word.length(); i++){
            char cchar = word.charAt(i);
            if(!curNode.contains(cchar)){
               curNode.add(cchar);
            }
           curNode = curNode.get(cchar);
            if(i == word.length() - 1){
                curNode.isEnd = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = root;
        for(int i = 0; i < word.length(); i++){
            char cchar = word.charAt(i);
            if(!curNode.contains(cchar)){
                return false;
            }
            curNode = curNode.get(cchar);
            if(i == word.length() - 1){
                return curNode.isEnd;
            }
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for(int i = 0; i < prefix.length(); i++){
            char cchar = prefix.charAt(i);
            if(!curNode.contains(cchar)){
                return false;
            }
            curNode = curNode.get(cchar);
        }
        return true;
    }
}
