package main.java;

/**
 * /**
 *
 * @ClassName: ChildrenCategory
 * @description:
 * @author: pengyi
 * @create: 2021-07-26 18:46
 **/
public class ChildrenCategory extends  FatherCategory{

    @Override
    public String getName() {
        return "I am Child, " + name;
    }

    @Override
    public void printCategory() {
        System.out.println(getName());
    }
}
