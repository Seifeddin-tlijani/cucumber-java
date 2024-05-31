package com.tlijani.cucumber;

import com.tlijani.cucumber.PersonService;
import com.tlijani.cucumber.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private List<Person> personList = new ArrayList<>() ;
    @Override
    public List<Person> init() {
        personList.add(new Person(1L,"Seif", "Tlijani" , 21));
        personList.add(new Person(2L,"john", "Doe" , 30));
        personList.add(new Person(3L,"mark", "Depon" , 40));
        personList.add(new Person(4L,"Amina", "Slim" , 22));
        personList.add(new Person(5L,"Mohamed", "Belhadj" , 21));

        return personList;
    }

    @Override
    public Person save(Person person) {
        if (person==null){
            return person;
        }
        person.setId((long) (personList.size()+1));
        personList.add(person);
        return person;
    }

    @Override
    public List<Person> findAll() {
        return personList;
    }
}
