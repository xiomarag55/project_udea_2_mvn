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
        Map<String, Integer> vulnerablePersons = new HashMap<>();
        int sumSituationVulnerability = 0;
        for(Person person: persons){
            if(person.isPension() == 'N' && person.stratum() < 2){
                vulnerablePersons.put(person.identityDocument(), person.stratum());
                sumSituationVulnerability++;
            }
        }
        return sumSituationVulnerability;
    }

    @Override
    public int averagePensioners(List<Person> persons) {
        return 0;
    }

    @Override
    public int numberPensioners(List<Person> persons) {
        int sumPensioned = 0;
        for(Person person: persons) {
            if (person.isPension() == 'S') {
                sumPensioned++;
            }
        }
        return sumPensioned;
    }

    @Override
    public int numberNonePensioners(List<Person> persons) {
        int sumNonePensioned = 0;
        for(Person person: persons) {
            if (person.isPension() == 'N') {
                sumNonePensioned++;
            }
        }
        return sumNonePensioned;
    }

    @Override
    public int numberPensionersOveSixty(List<Person> persons) {
        int sumPensionedOveSixty = 0;
        for(Person person: persons){
            if(person.isPension() == 'S' && person.age() > 60){
                sumPensionedOveSixty++;
            }
        }
        return sumPensionedOveSixty;
    }

    @Override
    public int numberWomenPensioners(List<Person> persons) {
        int sumWomenPensioned = 0;
        for(Person person: persons){
            if(person.isPension() == 'S' && person.sex() == 'F'){
                sumWomenPensioned++;
            }
        }
        return sumWomenPensioned;
    }

    @Override
    public int numberWomenNonPensioners(List<Person> persons) {
        int sumWomenNonPensioned = 0;
        for(Person person: persons){
            if(person.isPension() == 'N' && person.sex() == 'F'){
                sumWomenNonPensioned++;
            }
        }
        return sumWomenNonPensioned;
    }
}
