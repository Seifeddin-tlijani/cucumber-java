package com.tlijani.cucumber;

import com.tlijani.cucumber.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> init();

    Person save(Person person);

    List<Person> findAll();
}
