package org.elderCare.service;

import org.elderCare.model.Person;
import org.elderCare.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);
    private final PersonRepository personRepository ;
    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    private static final char PENSION_YES = 'S';
    private static final char PENSION_NO = 'N';
    private static final char GENDER_FEMALE = 'F';

    //Number of people who are in stratum 1 by id Number
    @Override
    public void peopleSituationVulnerability() {
        LOGGER.info("You are printing people in situation of vulnerability");
        personRepository.findAllPersons().stream()
                .filter(person -> person.isPension() == PENSION_NO && person.stratum() < 2)
                .collect(Collectors.toMap(Person::identityDocument, Person::stratum))
                .forEach((document, stratum) -> System.out.println("Document: " + document + " Stratum: " + stratum));
    }

    @Override
    public int totalSituationVulnerability() {
        LOGGER.info("You are calculating the total people in vulnerability situation");
        return (int) personRepository.findAllPersons().stream()
                .filter(person -> person.isPension() == PENSION_NO && person.stratum() < 2)
                .count();
    }

    @Override
    public double percentPensioners() {
        LOGGER.info("You are calculating the percent of pensioners");
        return Math.round(((double)numberPensioners() / (double)personRepository.findAllPersons().size())*100);
    }

    @Override
    public double percentNonPensioners() {
        LOGGER.info("You are calculating the percent of non-pensioners");
        return Math.round(((double)numberNonePensioners() / (double)personRepository.findAllPersons().size())*100);
    }

    @Override
    public List<Person> allPersonsToRevision() {
        return personRepository.findAllPersons();
    }

    @Override
    public int numberPensioners() {
        LOGGER.info("Method to calculate number of pensioners");
        return (int) personRepository.findAllPersons().stream()
                .filter(person -> person.isPension() == PENSION_YES)
                .count();
    }

    @Override
    public int numberNonePensioners() {
        LOGGER.info("Method to calculate number of non-pernsioners");
        return (int) personRepository.findAllPersons().stream()
                .filter(person -> person.isPension() == PENSION_NO)
                .count();
    }

    @Override
    public int numberPensionersOveSixty() {
        LOGGER.info("Method to calculate number of pensioners over sixty");
        return (int) personRepository.findAllPersons().stream()
                .filter(person -> person.isPension() == PENSION_YES && person.age() > 60)
                .count();
    }

    @Override
    public int numberWomenPensioners() {
        LOGGER.info("Method to calculate number of pensioner women");
        return (int) personRepository.findAllPersons().stream()
                .filter(person -> person.isPension() == PENSION_YES && person.sex() == GENDER_FEMALE)
                .count();
    }

    @Override
    public int numberWomenNonPensioners() {
        LOGGER.info("Method to calculate women no-pensioners");
        return (int) personRepository.findAllPersons().stream()
                .filter(person -> person.isPension() == PENSION_NO && person.sex() == GENDER_FEMALE)
                .count();
    }
}
