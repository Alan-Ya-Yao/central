package main.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * /**
 *
 * @ClassName: TestSpring
 * @description:
 * @author: pengyi
 * @create: 2021-07-26 18:44
 **/
public class TestSpring {

    public static void main(String[] args) {
        //applicationContext.xml就是自己创建的配置文件
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //c就是后面配置文件的id
        Inheritance inheritance = (Inheritance) context.getBean("inheritance");
        inheritance.fCategory.printCategory();
        inheritance.printCategory();
//        FatherCategory fatherCategory = (FatherCategory) context.getBean("fatherCategory");
//        fatherCategory.printCategory();
//        ChildrenCategory childrenCategory = (ChildrenCategory) context.getBean("childrenCategory");
//        childrenCategory.printCategory();

    }
}
