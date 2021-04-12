package com.example.practice.mockito_202104;

/**
 * /**
 *
 * @ClassName: Person
 * @description:
 * @author: pengyi
 * @create: 2021-04-12 15:50
 **/
public class Person {

    private final int    id;
    private final String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

