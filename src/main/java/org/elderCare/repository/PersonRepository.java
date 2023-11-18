package org.elderCare.repository;

import org.elderCare.model.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> findAllPersons();
    void addPerson(Person person);
    void removePerson(String personId);
}