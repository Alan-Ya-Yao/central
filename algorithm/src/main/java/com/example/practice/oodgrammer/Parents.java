package com.example.practice.oodgrammer;

/**
 * /**
 *
 * @ClassName: Parents
 * @description:
 * @author: pengyi
 * @create: 2021-04-16 18:08
 **/
public abstract class Parents {

    public void print_name(){
        System.out.println("parent's name");
        printOverrid();
    }

    public void printOverrid(){
        System.out.println("parent's override");
    }
}
