package com.example.practice.oodgrammer;

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

        /**
         * 子类调用父类的方法，父类方法里的方法被子类重写，则这个方法使用子类
         * parent's name
         * Childent overRid
         *
         * */
        Childent childent = new Childent();
        childent.print_name();

    }
}
