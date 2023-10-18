package org.elderCare.service;

import org.elderCare.model.Person;
import org.elderCare.repository.PersonInMemoryRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonServiceImpl implements PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);
    public PersonServiceImpl(PersonInMemoryRepositoryImpl personInMemoryRepository){

    }
    //Number of people who are in stratum 1 by id Number
    @Override
    public void peopleSituationVulnerability(List<Person> persons) {
        Map<String, Integer> vulnerablePerson = new HashMap<>();
        int totalSituationVulnerability = 0;
        for (Person person : persons) {
            if (person.isPension() == 'N' && person.stratum() < 2) {
                vulnerablePerson.put(person.identityDocument(), person.stratum());
                totalSituationVulnerability++;
            }
        }
        for (Map.Entry<String, Integer> person : vulnerablePerson.entrySet()) {
            System.out.println("Document: " + person.getKey() + " Stratum: " + person.getValue());
        }
    }

    @Override
    public int totalSituationVulnerability(List<Person> persons) {
        return 0;
    }

    @Override
    public int averagePensioners(List<Person> persons) {
        return 0;
    }

    @Override
    public int numberPensioners(List<Person> persons) {
        return 0;
    }

    @Override
    public int numberNonePensioners(List<Person> persons) {
        return 0;
    }

    @Override
    public int numberPensionersOveSixty(List<Person> persons) {
        return 0;
    }

    @Override
    public int numberWomenPensioners(List<Person> persons) {
        return 0;
    }

    @Override
    public int numberWomenNonPensioners(List<Person> persons) {
        return 0;
    }
}