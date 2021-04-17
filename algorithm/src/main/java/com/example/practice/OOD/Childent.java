package com.example.practice.OOD;

/**
 * /**
 *
 * @ClassName: Childent
 * @description:
 * @author: pengyi
 * @create: 2021-04-16 18:09
 **/
public class Childent extends Parents {
    @Override
    public void printOverrid() {
        System.out.println("Childent overRid");
    }

    public static void main(String[] args) {
        Childent childent = new Childent();
        childent.print_name();
    }
}
