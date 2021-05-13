package com.example.algorithm.datastrcture.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * /**
 *
 * @ClassName: SimpleListNode
 * @description:
 * @author: pengyi
 * @create: 2021-04-29 20:46
 **/
public class SimpleListNode {
    int val;
    List<SimpleListNode> nexts;

    public SimpleListNode(int val){
        this.val = val;
        nexts = new ArrayList<>();
    }

    public SimpleListNode copy(CallListNode callListNode){
        if(callListNode == null){
            return null;
        }
        SimpleListNode simpleListNode = new SimpleListNode(callListNode.val);
        copyOfTree(simpleListNode, callListNode);
        return  simpleListNode;
    }

    public void copyOfTree(SimpleListNode simpleListNode, CallListNode callListNode){
        if(callListNode == null){
            return;
        }
        for(CallListNode node : callListNode.nexts){
            SimpleListNode child = new SimpleListNode(node.val);
            simpleListNode.nexts.add(child);
            copyOfTree(child,node);
        }
        return;
    }

    public static void main(String[] args) {
        CallListNode root = new CallListNode(1);
        CallListNode child2 = new CallListNode(2);
        CallListNode child3 = new CallListNode(3);
        root.nexts.add(child2);
        root.nexts.add(child3);
        CallListNode child4 = new CallListNode(4);
        child2.nexts.add(child4);
        CallListNode child5 = new CallListNode(5);
        CallListNode child6 = new CallListNode(6);
        child3.nexts.add(child5);
        child5.nexts.add(child6);
        /**
         *              1
         *             / \
         *            2   3
         *           /     \
         *          4       5
         *                  \
         *                   6
         *
         *
         *
         * **/

        SimpleListNode solution = new SimpleListNode(-1);
        SimpleListNode simpleListNode = solution.copy(root);
        System.out.println(1111);
    }
}
