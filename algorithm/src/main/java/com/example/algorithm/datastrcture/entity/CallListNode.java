package com.example.algorithm.datastrcture.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * /**
 *
 * @ClassName: CallListNode
 * @description:
 * @author: pengyi
 * @create: 2021-04-29 20:47
 **/
public class CallListNode {
    int val;
    List<CallListNode> nexts;

    public CallListNode(int val){
        this.val = val;
        nexts = new ArrayList<>();
    }

}
