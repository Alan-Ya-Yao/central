package main.java;

import java.util.Locale;

/**
 * /**
 *
 * @ClassName: FatherCategory
 * @description:
 * @author: pengyi
 * @create: 2021-07-26 18:43
 **/

public class FatherCategory implements Category {


    protected String name;

    public String getName() {
        return "I am father, "  + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printCategory() {
        System.out.println(getName());
    }
}
