package com.example.practice.mockito_202104;

/**
 * /**
 *
 * @ClassName: PersonDao
 * @description:
 * @author: pengyi
 * @create: 2021-04-12 15:50
 **/
public interface PersonDao {

    Person getPerson(int id);

    boolean update(Person person);
}
