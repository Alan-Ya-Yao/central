package com.example.practice.mockito_202104;

/**
 * /**
 *
 * @ClassName: PersonService
 * @description:
 * @author: pengyi
 * @create: 2021-04-12 15:50
 **/
public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean update(int id, String name) {
        Person person = personDao.getPerson(id);
        if (person == null) {
            return false;
        }

        Person personUpdate = new Person(person.getId(), name);
        return personDao.update(personUpdate);
    }
}
