package org.elderCare.service;

import org.elderCare.model.Person;
import org.elderCare.repository.PersonInMemoryRepositoryImpl;
import org.elderCare.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonServiceImpl implements PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);
    PersonRepository personRepository = new PersonInMemoryRepositoryImpl();
    public PersonServiceImpl(PersonInMemoryRepositoryImpl personInMemoryRepository){

    }
    //Number of people who are in stratum 1 by id Number
    @Override
    public void peopleSituationVulnerability() {
        LOGGER.info("You are printing people in situation of vulnerability");
        Map<String, Integer> vulnerablePerson = new HashMap<>();
        int totalSituationVulnerability = 0;
        for (Person person : personRepository.findAllPersons()) {
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
    public int totalSituationVulnerability() {
        LOGGER.info("You are calculating the total people in vulnerability situation");
        Map<String, Integer> vulnerablePersons = new HashMap<>();
        int sumSituationVulnerability = 0;
        for(Person person: personRepository.findAllPersons()){
            if(person.isPension() == 'N' && person.stratum() < 2){
                vulnerablePersons.put(person.identityDocument(), person.stratum());
                sumSituationVulnerability++;
            }
        }
        return sumSituationVulnerability;
    }

    @Override
    public double percentPensioners() {
        LOGGER.info("You are calculating the percent of pensioners");
        return ((double)numberPensioners() / (double)personRepository.findAllPersons().size())*100;
    }

    @Override
    public double percentNonPensioners() {
        LOGGER.info("You are calculating the percent of non-pensioners");
        return ((double)numberNonePensioners() / (double)personRepository.findAllPersons().size())*100;
    }

    @Override
    public int numberPensioners() {
        LOGGER.info("Method to calculate number of pensioners");
        int sumPensioned = 0;
        for(Person person: personRepository.findAllPersons()) {
            if (person.isPension() == 'S') {
                sumPensioned++;
            }
        }
        return sumPensioned;
    }

    @Override
    public int numberNonePensioners() {
        LOGGER.info("Method to calculate number of non-pernsioners");
        int sumNonePensioned = 0;
        for(Person person: personRepository.findAllPersons()) {
            if (person.isPension() == 'N') {
                sumNonePensioned++;
            }
        }
        return sumNonePensioned;
    }

    @Override
    public int numberPensionersOveSixty() {
        LOGGER.info("Method to calculate number of pensioners over sixty");
        int sumPensionedOveSixty = 0;
        for(Person person: personRepository.findAllPersons()){
            if(person.isPension() == 'S' && person.age() > 60){
                sumPensionedOveSixty++;
            }
        }
        return sumPensionedOveSixty;
    }

    @Override
    public int numberWomenPensioners() {
        LOGGER.info("Method to calculate number of pensioner women");
        int sumWomenPensioned = 0;
        for(Person person: personRepository.findAllPersons()){
            if(person.isPension() == 'S' && person.sex() == 'F'){
                sumWomenPensioned++;
            }
        }
        return sumWomenPensioned;
    }

    @Override
    public int numberWomenNonPensioners() {
        LOGGER.info("Method to calculate women no-pensioners");
        int sumWomenNonPensioned = 0;
        for(Person person: personRepository.findAllPersons()){
            if(person.isPension() == 'N' && person.sex() == 'F'){
                sumWomenNonPensioned++;
            }
        }
        return sumWomenNonPensioned;
    }
}
