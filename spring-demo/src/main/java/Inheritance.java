package main.java;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * /**
 *
 * @ClassName: Inheritance
 * @description:
 * @author: pengyi
 * @create: 2021-07-26 18:49
 **/
public class Inheritance {

//    @Autowired
    Category fCategory;



//    @Autowired
    Category cCategory;


    public void printCategory(){
        fCategory.printCategory();
        cCategory.printCategory();
    }

    public void setfCategory(FatherCategory fCategory) {
        this.fCategory = fCategory;
    }

    public void setcCategory(Category cCategory) {
        this.cCategory = cCategory;
    }
}
